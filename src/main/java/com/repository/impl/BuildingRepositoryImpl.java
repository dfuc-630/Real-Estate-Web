package com.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.cache.support.NullValue;
import org.springframework.stereotype.Repository;

import com.repository.buildingRepository;
import com.repository.entity.BuildingEntity;
@Repository
public class BuildingRepositoryImpl implements buildingRepository {
	  String url = "jdbc:mysql://localhost:3306/estate";
      String user = "root";
      String password = "Phuc06032004@";
	@Override
	public List<BuildingEntity> Finall(String name, Integer floorarea,Integer districtid, String ward,String street, Integer numberofbasement,
			 String direction, String level, Integer areamin, Integer areamax, Integer rentpricemin,Integer rentpricemax,String managername,
			 String managerphonenumber,Integer staffid,String buildingtypecode) 
	
	{
  	  StringBuilder sql = new StringBuilder("SELECT a.name AS 'name', a.floorarea AS 'floorarea', b.name AS 'district', "
  	  		+ "a.ward AS 'ward', a.street AS 'street', "
  	  		+ "a.numberofbasement AS 'numberofbasement', a.direction AS 'direction', a.level AS 'level', c.value AS 'rentarea', "
  	  		+ "a.rentprice AS 'rentprice', a.managername AS 'managername', "
  	  		+ "a.managerphonenumber AS 'managerphonenumber', e.fullname AS 'staff', g.name AS 'buildingtype', a.brokeragefee AS 'brokeragefee' "
  	  		+ "FROM building a") ; 
  	  
  	  
  	  sql.append(" JOIN district b ON a.districtid = b.id") ;
  	  sql.append(" JOIN rentarea c ON c.buildingid = a.id") ;
  	  sql.append(" JOIN assignmentbuilding d ON d.buildingid = a.id") ;
  	  sql.append(" JOIN user e ON e.id = d.staffid") ;
  	  
  	  sql.append(" JOIN buildingrenttype f ON f.buildingid = a.id") ;
	  sql.append(" JOIN renttype g ON g.id = f.renttypeid") ;
	  
  	  sql.append(" WHERE") ; 
  	  boolean firstCondition = true ; 
  	  if(name != null && !name.equals(""))
  	  {
  		firstCondition = false ; 
  		  sql.append(" a.name like '%" + name + "%'") ; 
  	  }
  	  if(floorarea != null) 
  	  {
  		if (!firstCondition) sql.append(" AND");
  		sql.append(" a.floorarea=" + floorarea) ;
  		firstCondition = false ; 
  	  }
  	  if(districtid != null) 
  	  {
    		if (!firstCondition) sql.append(" AND");
  		  sql.append(" a.districtid=" + districtid) ; firstCondition = false ; 
  	  }
  	  if(ward != null && !ward.equals(""))
	  {
    		if (!firstCondition) sql.append(" AND");
		  sql.append(" a.ward like '%" + ward + "%'") ; firstCondition = false ; 
	  }
  	  if(street != null && !street.equals(""))
	  {
    		if (!firstCondition) sql.append(" AND");
		  sql.append(" a.street like '%" + street + "%'") ; firstCondition = false ; 
	  }
  	  if(numberofbasement != null) 
	  {
    		if (!firstCondition) sql.append(" AND");
		  sql.append(" a.numberofbasement=" + numberofbasement) ; firstCondition = false ; 
	  }
  	  if(direction != null && !direction.equals(""))
	  {
  		if (!firstCondition) sql.append(" AND");
		  sql.append(" a.direction like '%" + direction + "%'") ; firstCondition = false ; 
	  }
  	  if(level != null && !level.equals(""))
	  {
  		if (!firstCondition) sql.append(" AND");
		  sql.append(" a.level like '%" + level + "%'") ; firstCondition = false ; 
	  }
  	  if(areamin != null && areamax != null) 
	  {
  		if (!firstCondition) sql.append(" AND");
		  sql.append(" c.value>=" + areamin + " AND c.value<=" + areamax)  ; firstCondition = false ; 
	  }
  	  if(rentpricemin != null && rentpricemax != null) 
	  {
  		if (!firstCondition) sql.append(" AND");
		  sql.append(" a.rentprice>=" + rentpricemin + " AND a.rentprice<=" + rentpricemax)  ;firstCondition = false ;  
	  }
  	  if(managername != null && !managername.equals(""))
	  {
  		if (!firstCondition) sql.append(" AND");
		  sql.append(" a.managername like '%" + managername + "%'") ; firstCondition = false ; 
	  }
  	  if(managerphonenumber != null && !managerphonenumber.equals(""))
	  {
  		if (!firstCondition) sql.append(" AND");
		  sql.append(" a.managerphonenumber like '%" + managerphonenumber + "%'") ; firstCondition = false ; 
	  }
  	  if(staffid != null) 
	  {
  		if (!firstCondition) sql.append(" AND");
		  sql.append(" d.staffid=" + staffid) ; firstCondition = false ; 
	  }
  	  if(buildingtypecode != null && !buildingtypecode.equals(""))
	  {
  		if (!firstCondition) sql.append(" AND");
		  sql.append(" g.code like '%" + buildingtypecode + "%'") ; firstCondition = false ; 
	  }
  	  sql.append(";") ; 
  	  
  	  

  	  List<BuildingEntity> result = new ArrayList<>() ; 
  	  try {
            // Tải driver (tùy thuộc vào cơ sở dữ liệu)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Tạo kết nối
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Tạo đối tượng Statement
            Statement stmt = conn.createStatement();
            
            // Thực hiện truy vấn
            System.out.print(sql.toString());
            ResultSet rs = stmt.executeQuery(sql.toString());
            
            
            
            //  	String name, Integer floorarea,Integer districtid, String ward,String street, Integer numberofbasement,
//	 String direction, String level, Integer areamin, Integer areamax, Integer rentpricemin,Integer rentpricemax,String managername,
//	 String managerphonenumber,Integer staffid,String buildingtypecode
            // Xử lý kết quả
            while (rs.next()) 
            {
            	BuildingEntity building = new BuildingEntity() ; 
                building.setName(rs.getString("name")) ; 
                building.setFloorarea(rs.getInt("floorarea"));
                building.setDistrict(rs.getString("district")) ; 	         
                building.setWard(rs.getString("ward")) ; 
                building.setStreet(rs.getString("street")) ;  
                building.setNumberOfBasement(rs.getInt("numberofbasement")) ; 
                building.setDirection(rs.getString("direction")) ; 
                building.setLevel(rs.getString("level")) ;
                building.setRentarea(rs.getInt("rentarea")) ; 
                building.setRentprice(rs.getInt("rentprice")) ;
                building.setManagername(rs.getString("managername")) ; 
                building.setManagerphonenumber(rs.getString("managerphonenumber")) ; 
                building.setStaff(rs.getString("staff")) ; 
                building.setBuildingtype(rs.getString("buildingtype")) ; 
                building.setBrokeragefee(rs.getInt("brokeragefee"));
                result.add(building) ; 
            }
            
            
            
            // Đóng kết nối
            rs.close();
            stmt.close();
            conn.close();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		return result;
	}

}
