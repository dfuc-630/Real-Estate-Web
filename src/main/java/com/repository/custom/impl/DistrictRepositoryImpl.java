package com.repository.custom.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.springframework.stereotype.Repository;

import com.repository.DistrictRepository;
import com.repository.entity.DistrictEntity;
import com.utils.UtilConnectionJDBC;
@Repository 
public class DistrictRepositoryImpl implements DistrictRepository {
	@Override
	public DistrictEntity findNameById(Integer id) {
		String sql = "SELECT d.name FROM district d WHERE d.id = " + id + ";" ;
		DistrictEntity result = new DistrictEntity();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            // Tạo kết nối
            try (Connection conn = UtilConnectionJDBC.getConnection();
                 Statement stmt = conn.createStatement();           		            		
                 ResultSet rs = stmt.executeQuery(sql)) {   
                // Xử lý kết quả
                while (rs.next()) {
                	result.setName(rs.getString("name"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}

}
