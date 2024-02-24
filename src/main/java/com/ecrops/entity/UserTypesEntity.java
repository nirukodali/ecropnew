package com.ecrops.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usertypes")
public class UserTypesEntity {

	@Id
	@Column(name = "usertype")
	public Integer userType;

	@Column(name = "name")
	public String typeName;

	public Integer getUserType() {
		return userType == null ? 0 : userType;
	}

	public void setUserType(Integer userType) {
		this.userType = userType;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	@Override
	public String toString() {
		return "UserTypesEntity [userType=" + userType + ", typeName=" + typeName + "]";
	}

}
