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
	public List<BuildingEntity> Finall(String name, Integer districtid) {
  	  StringBuilder sql = new StringBuilder("SELECT * FROM building WHERE 1 = 1 ") ; 
  	  if(name != null && !name.equals(""))
  	  {
  		  sql.append("AND name like '%" + name + "%' ") ; 
  	  }
  	  if(districtid != null) 
  	  {
  		  sql.append("AND districtid=" + districtid + " ") ; 
  	  }
  	  List<BuildingEntity> result = new ArrayList<>() ; 
  	  try {
            // Tải driver (tùy thuộc vào cơ sở dữ liệu)
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Tạo kết nối
            Connection conn = DriverManager.getConnection(url, user, password);
            
            // Tạo đối tượng Statement
            Statement stmt = conn.createStatement();
            
            // Thực hiện truy vấn
            ResultSet rs = stmt.executeQuery(sql.toString());
            
            // Xử lý kết quả
            while (rs.next()) 
            {
            	BuildingEntity building = new BuildingEntity() ; 
                building.setName(rs.getString("name")) ; 
                building.setStreet(rs.getString("street")) ;   
                building.setWard(rs.getString("ward")) ; 
                building.setNumberOfBasement(rs.getInt("NumberOfBasement")) ; 
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
