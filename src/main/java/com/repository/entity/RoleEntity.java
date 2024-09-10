package com.repository.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "role")
public class RoleEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id ; 
	
	@Column(name = "username", nullable = false) 
	private String name ; 
	
	@Column(name = "code", nullable = false, unique = true) 
	private String code ;
	
//	@OneToMany(mappedBy = "role", fetch = FetchType.LAZY)
//	private List<UserRoleEntity> userRoleEntities = new ArrayList<>() ;
//
//	public List<UserRoleEntity> getUserRoleEntities() {
//		return userRoleEntities;
//	}

//	public void setUserRoleEntities(List<UserRoleEntity> userRoleEntities) {
//		this.userRoleEntities = userRoleEntities;
//	}
	
	@ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
	private List<UserEntity> users = new ArrayList<>() ; 

	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	
}
