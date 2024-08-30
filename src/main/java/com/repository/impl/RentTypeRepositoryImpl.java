package com.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.repository.RentTypeRepository;
import com.repository.entity.RentTypeEntity;
import com.utils.UtilConnectionJDBC;
@Repository 

public class RentTypeRepositoryImpl implements RentTypeRepository{
	@Override
	public List<RentTypeEntity> FindAreaById(Integer id) {
		String sql = "SELECT value FROM rentarea d WHERE d.buildingid = " + id + ";" ;
		List<RentTypeEntity> result = new ArrayList<>();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            try (Connection conn = UtilConnectionJDBC.getConnection();
                 Statement stmt = conn.createStatement();           		            		
                 ResultSet rs = stmt.executeQuery(sql)) {   
                while (rs.next()) {
                	RentTypeEntity area = new RentTypeEntity() ; 
                	area.setValue(rs.getString("value"));
                	result.add(area) ; 
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
	}
}
