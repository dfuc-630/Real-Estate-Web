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
    public List<BuildingEntity> Finall(Map<String, Object> param) {
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

        if (param.name != null && !V.name.isEmpty()) {
            sql.append(" AND a.name LIKE '%" + V.name + "%'");
        }
        if (V.floorarea != null) {
            sql.append(" AND a.floorarea=" + V.floorarea);
        }
        if (V.districtid != null) {
            sql.append(" AND a.districtid=" + V.districtid);
        }
        if (V.ward != null && !V.ward.isEmpty()) {
            sql.append(" AND a.ward LIKE '%" + V.ward + "%'");
        }
        if (V.street != null && !V.street.isEmpty()) {
            sql.append(" AND a.street LIKE '%" + V.street + "%'");
        }
        if (V.numberofbasement != null) {
            sql.append(" AND a.numberofbasement=" + V.numberofbasement);
        }
        if (V.direction != null && !V.direction.isEmpty()) {
            sql.append(" AND a.direction LIKE '%" + V.direction + "%'");
        }
        if (V.level != null && !V.level.isEmpty()) {
            sql.append(" AND a.level LIKE '%" + V.level + "%'");
        }
        if (V.areamin != null) {
            sql.append(" AND c.value >=" + V.areamin);
        }
        if (V.areamax != null) {
            sql.append(" AND c.value <=" + V.areamax);
        }
        if (V.rentpricemin != null) {
            sql.append(" AND a.rentprice >=" + V.rentpricemin);
        }
        if (V.rentpricemax != null) {
            sql.append(" AND a.rentprice <=" + V.rentpricemax);
        }
        if (V.managername != null && !V.managername.isEmpty()) {
            sql.append(" AND a.managername LIKE '%" + V.managername + "%'");
        }
        if (V.managerphonenumber != null && !V.managerphonenumber.isEmpty()) {
            sql.append(" AND a.managerphonenumber LIKE '%" + V.managerphonenumber + "%'");
        }
        if (V.staffid != null) {
            sql.append(" AND d.staffid=" + V.staffid);
        }
        if (V.buildingtypecode != null && !V.buildingtypecode.isEmpty()) {
            sql.append(" AND g.code LIKE '%" + V.buildingtypecode + "%'");
        }

        sql.append(";");

        List<BuildingEntity> result = new ArrayList<>();
        try {
            // Tải driver (tùy thuộc vào cơ sở dữ liệu)
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Tạo kết nối
            try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql.toString())) {
            	 System.out.println(sql.toString());
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
