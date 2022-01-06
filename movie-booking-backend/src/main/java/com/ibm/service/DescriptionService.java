package com.ibm.service;

import java.util.List;

import com.ibm.entity.Description;

public interface DescriptionService {
	
	void addDescription(Description d);
	
	void updateDescription(Description d);
	
	boolean deleteDescription(int desId);
	
	Description findByDescriptionId(int DesId);

}
