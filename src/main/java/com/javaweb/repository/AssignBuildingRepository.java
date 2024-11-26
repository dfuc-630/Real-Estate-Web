package com.javaweb.repository;

import com.javaweb.entity.AssignBuildingEntity;
import com.javaweb.entity.BuildingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssignBuildingRepository extends JpaRepository<AssignBuildingEntity, Integer> {
    // Có thể thêm các phương thức truy vấn tùy chỉnh nếu cần, ví dụ:
    // List<AssignBuildingEntity> findByBuildingEntity_Id(Integer buildingId);
    // List<AssignBuildingEntity> findByUserEntity_Id(Integer staffId);
    void deleteByBuildingEntity(BuildingEntity buildingEntity) ;
}