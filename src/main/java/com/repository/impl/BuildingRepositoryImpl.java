package com.repository.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.repository.ParamCatcher;
import com.repository.buildingRepository;
import com.repository.entity.BuildingEntity;

@Repository
public class BuildingRepositoryImpl implements buildingRepository {

    private static final String URL = "jdbc:mysql://localhost:3306/estate";
    private static final String USER = "root";
    private static final String PASSWORD = "Phuc06032004@";

    @Override
    public List<BuildingEntity> Finall(Map<String, Object> param, List<String> buildingtypecode) {
        StringBuilder sql = new StringBuilder("SELECT "
            + "a.name AS 'name', "
            + "a.floorarea AS 'floorarea', "
            + "b.name AS 'district', "
            + "a.ward AS 'ward', "
            + "a.street AS 'street', "
            + "a.numberofbasement AS 'numberofbasement', "
            + "a.direction AS 'direction', "
            + "a.level AS 'level', "
            + "c.value AS 'rentarea', "
            + "a.rentprice AS 'rentprice', "
            + "a.managername AS 'managername', "
            + "a.managerphonenumber AS 'managerphonenumber', "
            + "e.fullname AS 'staff', "
            + "g.name AS 'buildingtype', "
            + "a.brokeragefee AS 'brokeragefee' "
            
            + "FROM building a "
            + "LEFT JOIN district b ON a.districtid = b.id "
            + "LEFT JOIN rentarea c ON c.buildingid = a.id "
            + "LEFT JOIN assignmentbuilding d ON d.buildingid = a.id "
            + "LEFT JOIN user e ON e.id = d.staffid "
            + "LEFT JOIN buildingrenttype f ON f.buildingid = a.id "
            + "LEFT JOIN renttype g ON g.id = f.renttypeid "
            
            + "WHERE 1=1");

        if (param.get("name") != null && !((String) param.get("name")).trim().isEmpty()) {
            sql.append(" AND a.name LIKE '%" + param.get("name") + "%'");
        }
        if (param.get("floorarea") != null) {
            sql.append(" AND a.floorarea=" + param.get("floorarea"));
        }
        if (param.get("districtid") != null) {
            sql.append(" AND a.districtid=" + param.get("districtid"));
        }
        if (param.get("ward") != null && !((String) param.get("ward")).trim().isEmpty()) {
            sql.append(" AND a.ward LIKE '%" + param.get("ward") + "%'");
        }
        if (param.get("street") != null && !((String) param.get("street")).trim().isEmpty()) {
            sql.append(" AND a.street LIKE '%" + param.get("street") + "%'");
        }
        if (param.get("numberofbasement") != null) {
            sql.append(" AND a.numberofbasement=" + param.get("numberofbasement"));
        }
        if (param.get("direction") != null && !((String) param.get("direction")).trim().isEmpty()) {
            sql.append(" AND a.direction LIKE '%" + param.get("direction") + "%'");
        }
        if (param.get("level") != null && !((String) param.get("level")).trim().isEmpty()) {
            sql.append(" AND a.level LIKE '%" + param.get("level") + "%'");
        }
        if (param.get("areamin") != null) {
            sql.append(" AND c.value >=" + param.get("areamin"));
        }
        if (param.get("areamax") != null) {
            sql.append(" AND c.value <=" + param.get("areamax"));
        }
        if (param.get("rentpricemin") != null) {
            sql.append(" AND a.rentprice >=" + param.get("rentpricemin"));
        }
        if (param.get("rentpricemax") != null) {
            sql.append(" AND a.rentprice <=" + param.get("rentpricemax"));
        }
        if (param.get("managername") != null && !((String) param.get("managername")).trim().isEmpty()) {
            sql.append(" AND a.managername LIKE '%" + param.get("managername") + "%'");
        }
        if (param.get("managerphonenumber") != null && !((String) param.get("managerphonenumber")).trim().isEmpty()) {
            sql.append(" AND a.managerphonenumber LIKE '%" + param.get("managerphonenumber") + "%'");
        }
        if (param.get("staffid") != null) {
            sql.append(" AND d.staffid=" + param.get("staffid"));
        }
        if (buildingtypecode != null && !buildingtypecode.isEmpty())
        {
        	boolean typeflag = false ; 
        	sql.append(" AND (") ; 
        	 for (String type : buildingtypecode) {
                 if(typeflag == false) {
                	 sql.append(" g.code LIKE '%" + type + "%'");
                	 typeflag = true ; 
                 }
                 else {
                	 sql.append(" OR g.code LIKE '%" + type + "%'");
                 }
        	 }
        	 sql.append(")") ;
        }

        sql.append(";");
        System.out.println(sql.toString());
        List<BuildingEntity> result = new ArrayList<>();
        try {
            // Tải driver (tùy thuộc vào cơ sở dữ liệu)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tạo kết nối
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement();
            		
            		
                 ResultSet rs = stmt.executeQuery(sql.toString())) {
            	 
                // Xử lý kết quả
                while (rs.next()) {
                    BuildingEntity building = new BuildingEntity();
                    building.setName(rs.getString("name"));
                    building.setFloorarea(rs.getInt("floorarea"));
                    building.setDistrict(rs.getString("district"));
                    building.setWard(rs.getString("ward"));
                    building.setStreet(rs.getString("street"));
                    building.setNumberOfBasement(rs.getInt("numberofbasement"));
                    building.setDirection(rs.getString("direction"));
                    building.setLevel(rs.getString("level"));
                    building.setRentarea(rs.getInt("rentarea"));
                    building.setRentprice(rs.getInt("rentprice"));
                    building.setManagername(rs.getString("managername"));
                    building.setManagerphonenumber(rs.getString("managerphonenumber"));
                    building.setStaff(rs.getString("staff"));
                    building.setBuildingtype(rs.getString("buildingtype"));
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
