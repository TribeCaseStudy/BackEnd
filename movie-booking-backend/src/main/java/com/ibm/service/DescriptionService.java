package com.ibm.service;

import java.util.List;

import com.ibm.entity.Description;

public interface DescriptionService {
	
	void addDescription(Description d);
	
	void updateDescription(Description d);
	
	List<Description> deleteDescription();
	
	Description findByDescriptionId(int DesId);

}
