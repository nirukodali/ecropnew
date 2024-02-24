package com.ecrops.service;

import java.util.List;

import com.ecrops.projection.RbkDetailsProjection;


public interface RbkService {
	public List<RbkDetailsProjection> getEmployeeDetails(Integer district, Integer mandal, String rbkUserId);
}
