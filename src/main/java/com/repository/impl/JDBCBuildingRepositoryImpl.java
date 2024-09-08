package com.repository.impl;
import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.builder.BuildingSearchBuilder;
import com.repository.buildingRepository;
import com.repository.entity.BuildingEntity;
import com.utils.Stringutil ;
import com.utils.UtilConnectionJDBC;
@Repository
public class JDBCBuildingRepositoryImpl implements buildingRepository {

    public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder sql) 
    {
    	Integer staffid =  buildingSearchBuilder.getStaffid() ;
    	if (staffid != null) {
	    	sql.append(" INNER JOIN assignmentbuilding d ON d.buildingid = a.id ") ;
    	}
    	List<String> buildingtypecode = buildingSearchBuilder.getBuildingtypecode() ; 
    	if (buildingtypecode != null && !buildingtypecode.isEmpty())
    	{
    		sql.append(" INNER JOIN buildingrenttype f ON f.buildingid = a.id ") ;
    		sql.append(" INNER JOIN renttype g ON g.id = f.renttypeid ") ;
    	}	
    	Integer areamin = buildingSearchBuilder.getAreamin() ;
    	Integer areamax = buildingSearchBuilder.getAreamax() ; 
    	if (areamin != null || areamax != null) {
    		sql.append(" INNER JOIN rentarea c ON c.buildingid = a.id ") ;
    	}
    }
    public static void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where)
    { 
    	try
    	{
    		Field[] fields = BuildingSearchBuilder.class.getDeclaredFields() ; 
    		for(Field item: fields) 
    		{
    			item.setAccessible(true);
    			String fieldName = item.getName() ; 
    			if(!fieldName.equals("staffid") && !fieldName.equals("areamin") && !fieldName.equals("areamax") 
        				&& !fieldName.equals("buildingtypecode") && !fieldName.equals("rentpricemin") && !fieldName.equals("rentpricemax"))
    			{
    				Object value = item.get(buildingSearchBuilder) ; 
    				if(value != null)
        			{
        				if(item.getType().getName().equals("java.lang.Integer"))
        				{
        					where.append(" AND a." + fieldName +  " =" + value ) ;  
        				}
        				else if(item.getType().getName().equals("java.lang.String")) // String
        				{
        					where.append(" AND a." + fieldName + " like '%" + value + "%' ") ;
        				}
        			}
    			}
    		}
    		
    	}
    	catch(Exception e)
    	{
    		e.printStackTrace();  
    	}
    }
    public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) 
    { 
    	Integer staffid =  buildingSearchBuilder.getStaffid() ;
    	if (staffid != null) {
    		where.append(" AND d.staffid=" + staffid);
    	}
    	Integer areamin = buildingSearchBuilder.getAreamin() ;
    	Integer areamax = buildingSearchBuilder.getAreamax() ; 
    	if (areamin != null) {
    		where.append(" AND c.value >=" + areamin);
    	}
    	if (areamax != null) {
    		where.append(" AND c.value <=" + areamax);
    	}
    	Integer rentpricemin = buildingSearchBuilder.getRentpricemin() ;
    	Integer rentpricemax = buildingSearchBuilder.getRentpricemax() ; 
    	if (rentpricemin != null) {
    		where.append(" AND a.rentprice >=" + rentpricemin);
    	}
    	if (rentpricemax != null) {
    		where.append(" AND a.rentprice <=" + rentpricemax);
    	}
    	List<String> buildingtypecode = buildingSearchBuilder.getBuildingtypecode() ; 
		if (buildingtypecode != null && !buildingtypecode.isEmpty())
		{
			 boolean typeflag = false ; 
			 where.append(" AND (") ; 
			 for (String type : buildingtypecode) {
			     if(typeflag == false) {
			    	 where.append(" g.code LIKE '%" + type + "%'");
				 typeflag = true ; 
			 }
			 else {
				 where.append(" OR g.code LIKE '%" + type + "%'");
			     }
			 }
			 where.append(")") ;
		}
    }
    @Override
    public List<BuildingEntity> Finall(BuildingSearchBuilder buildingSearchBuilder) {
        StringBuilder sql = new StringBuilder("SELECT "
        	+ "a.id, "
        	+ "a.name AS 'name', "
            + "a.floorarea AS 'floorarea', "
            + "a.districtid AS 'districtid', "
            + "a.ward AS 'ward', "
            + "a.street AS 'street', "
            + "a.numberofbasement AS 'numberofbasement', "
            + "a.direction AS 'direction', "
            + "a.level AS 'level', "
            + "a.rentprice AS 'rentprice', "
            + "a.managername AS 'managername', "
            + "a.managerphonenumber AS 'managerphonenumber', "
            + "a.servicefee, "
            + "a.brokeragefee AS 'brokeragefee' "
            + "FROM building a " ); 
            
            joinTable(buildingSearchBuilder, sql) ; 
            StringBuilder where = new StringBuilder(" WHERE 1=1 ") ;
            
            queryNormal(buildingSearchBuilder, where) ;
            querySpecial(buildingSearchBuilder, where) ;
            where.append(" GROUP BY a.id") ; 
            sql.append(where) ; 
            
            System.out.println(sql.toString());
        List<BuildingEntity> result = new ArrayList<>();
        try {
            // Tải driver (tùy thuộc vào cơ sở dữ liệu)
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Tạo kết nối
            try (Connection conn = UtilConnectionJDBC.getConnection();
                 Statement stmt = conn.createStatement();           		            		
                 ResultSet rs = stmt.executeQuery(sql.toString())) {   
                // Xử lý kết quả
                while (rs.next()) {
                    BuildingEntity building = new BuildingEntity();
                    building.setId(rs.getInt("a.id"));
                    building.setName(rs.getString("name"));
                    building.setFloorarea(rs.getInt("floorarea"));
//                    building.setDistrictid(rs.getInt("districtid"));
                    building.setWard(rs.getString("ward"));
                    building.setStreet(rs.getString("street"));
                    building.setNumberOfBasement(rs.getInt("numberofbasement"));
                    building.setDirection(rs.getString("direction"));
                    building.setLevel(rs.getString("level"));          
                    building.setRentprice(rs.getInt("rentprice"));
                    building.setManagername(rs.getString("managername"));
                    building.setManagerphonenumber(rs.getString("managerphonenumber"));
                    building.setServicefee(rs.getInt("a.servicefee"));            
                    building.setBrokeragefee(rs.getInt("brokeragefee"));
                    result.add(building);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }
}
