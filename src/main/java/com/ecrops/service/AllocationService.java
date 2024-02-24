package com.ecrops.service;

import java.util.List;
import java.util.Optional;



import com.ecrops.projection.RbkDetailsProjection;
import com.ecrops.projection.WbVillageMastProjection;

public interface AllocationService {
	
	
	
	
	
	
	
	
	
	
	
	
	

	public List<WbVillageMastProjection> getWebLandDetails(Integer district, Integer mandal);

	public List<RbkDetailsProjection> getRbkUserId(Integer rbkCode, Integer empCode);



}
