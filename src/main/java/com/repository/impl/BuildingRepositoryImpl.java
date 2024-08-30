package com.repository.impl;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.repository.buildingRepository;
import com.repository.entity.BuildingEntity;
import com.utils.NumberUtil;
import com.utils.Stringutil ;
import com.utils.UtilConnectionJDBC;
@Repository
public class BuildingRepositoryImpl implements buildingRepository {

    public static void joinTable(Map<String, Object> param, List<String> buildingtypecode, StringBuilder sql) 
    {
    	String staffid = (String) param.get("staffid") ;
    	if (Stringutil.checkString(staffid)) {
	    	sql.append(" INNER JOIN assignmentbuilding d ON d.buildingid = a.id ") ;
    	}
    	if (buildingtypecode != null && !buildingtypecode.isEmpty())
    	{
    		sql.append(" INNER JOIN buildingrenttype f ON f.buildingid = a.id ") ;
    		sql.append(" INNER JOIN renttype g ON g.id = f.renttypeid ") ;
    	}	
    	String areamin = (String) param.get("areamin") ;
    	String areamax = (String) param.get("areamax") ; 
    	if (Stringutil.checkString(areamin) || Stringutil.checkString(areamax)) {
    		sql.append(" INNER JOIN rentarea c ON c.buildingid = a.id ") ;
    	}
    }
    public static void queryTable(Map<String, Object> param, List<String> buildingtypecode, StringBuilder sql) 
    {
    	if(Stringutil.checkString((String)param.get("name"))) {
            sql.append(" AND a.name LIKE '%" + param.get("name") + "%'");
        }
        if (param.get("floorarea") != null) {
            sql.append(" AND a.floorarea=" + param.get("floorarea"));
        }
        if (param.get("districtid") != null) {
            sql.append(" AND a.districtid=" + param.get("districtid"));
        }
    	if(Stringutil.checkString((String)param.get("ward"))) {
            sql.append(" AND a.ward LIKE '%" + param.get("ward") + "%'");
        }
    	if(Stringutil.checkString((String)param.get("street"))) {
            sql.append(" AND a.street LIKE '%" + param.get("street") + "%'");
        }
        if (param.get("numberofbasement") != null) {
            sql.append(" AND a.numberofbasement=" + param.get("numberofbasement"));
        }
    	if(Stringutil.checkString((String)param.get("direction"))) {
            sql.append(" AND a.direction LIKE '%" + param.get("direction") + "%'");
        }
    	if(Stringutil.checkString((String)param.get("level"))) {
            sql.append(" AND a.level LIKE '%" + param.get("level") + "%'");
        }
//        if (param.get("areamin") != null) {
//            sql.append(" AND c.value >=" + param.get("areamin"));
//        }
//        if (param.get("areamax") != null) {
//            sql.append(" AND c.value <=" + param.get("areamax"));
//        }
        if (param.get("rentpricemin") != null) {
            sql.append(" AND a.rentprice >=" + param.get("rentpricemin"));
        }
        if (param.get("rentpricemax") != null) {
            sql.append(" AND a.rentprice <=" + param.get("rentpricemax"));
        }
    	if(Stringutil.checkString((String)param.get("managername"))) {
            sql.append(" AND a.managername LIKE '%" + param.get("managername") + "%'");
        }
    	if(Stringutil.checkString((String)param.get("managerphonenumber"))) {
            sql.append(" AND a.managerphonenumber LIKE '%" + param.get("managerphonenumber") + "%'");
        }
//        if (param.get("staffid") != null) {
//            sql.append(" AND d.staffid=" + param.get("staffid"));
//        }
//        if (buildingtypecode != null && !buildingtypecode.isEmpty())
//        {
//        	boolean typeflag = false ; 
//        	sql.append(" AND (") ; 
//        	 for (String type : buildingtypecode) {
//                 if(typeflag == false) {
//                	 sql.append(" g.code LIKE '%" + type + "%'");
//                	 typeflag = true ; 
//                 }
//                 else {
//                	 sql.append(" OR g.code LIKE '%" + type + "%'");
//                 }
//        	 }
//        	 sql.append(")") ;
//        }

        sql.append("GROUP BY a.id;") ;
    }
    public static void queryNormal(Map<String, Object> param, StringBuilder where)
    { 
    	for(Map.Entry<String, Object> item: param.entrySet())
    	{
    		if(!item.getKey().equals("staffid") && !item.getKey().equals("areamin") && !item.getKey().equals("areamax") 
    				&& !item.getKey().equals("buildingtypecode") && !item.getKey().equals("rentpricemin") && !item.getKey().equals("rentpricemax"))
    		{
    			String value = item.getValue().toString() ; 
    			if(Stringutil.checkString(value))
    			{
    				if(NumberUtil.isNumber(value))
    				{
    					where.append(" AND a." + item.getKey() +  " =" + value ) ;  
    				}
    				else 
    				{
    					where.append(" AND a." + item.getKey() + " like '%" + value + "%' ") ;
    				}
    			}
    			
    		}
    	}
    	
    }
    public static void querySpecial(Map<String, Object> param, List<String> buildingtypecode, StringBuilder where) 
    { 
    	String staffid = (String) param.get("staffid") ;
    	if (Stringutil.checkString(staffid)) {
    		where.append(" AND d.staffid=" + param.get("staffid"));
    	}
    	String areamin = (String) param.get("areamin") ;
    	String areamax = (String) param.get("areamax") ; 
    	if (Stringutil.checkString(areamin)) {
    		where.append(" AND c.value >=" + param.get("areamin"));
    	}
    	if (Stringutil.checkString(areamax)) {
    		where.append(" AND c.value <=" + param.get("areamax"));
    	}
    	String rentpricemin = (String) param.get("rentpricemin") ;
    	String rentpricemax = (String) param.get("rentpricemax") ; 
    	if (Stringutil.checkString(rentpricemin)) {
    		where.append(" AND a.rentprice >=" + param.get("rentpricemin"));
    	}
    	if (Stringutil.checkString(rentpricemax)) {
    		where.append(" AND a.rentprice <=" + param.get("rentpricemax"));
    	}

		if (buildingtypecode != null && !buildingtypecode.isEmpty())
		{
//			List<String> code = new ArrayList<>() ; 
//			for(String item: buildingtypecode) 
//			{
//				code.add("'" + item + "'") ; 				
//			}
//			where.append(" AND g.code IN(" + String.join(",", code) + ") ") ; 
//			where.append(" AND g.code IN(" + String.join(",", buildingtypecode) + ") ") ; 
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
    public List<BuildingEntity> Finall(Map<String, Object> param, List<String> buildingtypecode) {
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
            //+ "c.value AS 'rentarea', "
            + "a.rentprice AS 'rentprice', "
            + "a.managername AS 'managername', "
            + "a.managerphonenumber AS 'managerphonenumber', "
            + "a.servicefee, "
            //+ "e.fullname AS 'staff', "
            //+ "g.name AS 'buildingtype', "
            + "a.brokeragefee AS 'brokeragefee' "
            + "FROM building a " ); 
            
            joinTable(param, buildingtypecode, sql) ; 
            StringBuilder where = new StringBuilder(" WHERE 1=1 ") ;
            
            queryNormal(param, where) ;
            querySpecial(param, buildingtypecode, where) ;
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
                    building.setDistrictid(rs.getInt("districtid"));
                    building.setWard(rs.getString("ward"));
                    building.setStreet(rs.getString("street"));
                    building.setNumberOfBasement(rs.getInt("numberofbasement"));
                    building.setDirection(rs.getString("direction"));
                    building.setLevel(rs.getString("level"));
//                    if(Stringutil.checkString((String) param.get("areamin")) || Stringutil.checkString((String) param.get("areamax")))
//                    {
//                    	 building.setRentarea(rs.getInt("rentarea"));
//                    }              
                    building.setRentprice(rs.getInt("rentprice"));
                    building.setManagername(rs.getString("managername"));
                    building.setManagerphonenumber(rs.getString("managerphonenumber"));
//                    building.setStaff(rs.getString("staff"));
//                    building.setBuildingtype(rs.getString("buildingtype"));
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
