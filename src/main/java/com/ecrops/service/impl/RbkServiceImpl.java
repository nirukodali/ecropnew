//package com.ecrops.service.impl;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//
//import com.ecrops.entity.Employeename;
//import com.ecrops.projection.RbkDetailsProjection;
//import com.ecrops.repo.RbkRepo;
//import com.ecrops.service.RbkService;
//
//public class RbkServiceImpl implements RbkService{
//	
//	@Autowired
//	private RbkRepo rbkRepo;
//
//	@Override
//	public List<RbkDetailsProjection> getEmployeeDetails(Integer district, Integer mandal, String rbkUserId) {
//		return rbkRepo.getEmployeeDetails(district, mandal, rbkUserId);
//	}
//
//	
//}
