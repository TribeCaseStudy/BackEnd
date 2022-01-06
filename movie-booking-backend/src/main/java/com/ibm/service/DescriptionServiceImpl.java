package com.ibm.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Description;
import com.ibm.repo.DescriptionRepository;

@Service
public class DescriptionServiceImpl implements DescriptionService {

	@Autowired
	private DescriptionRepository repo;
	
	@Override
	public void addDescription(Description d) {
		repo.save(d);
	}

	@Override
	public void updateDescription(Description d) {
		repo.save(d);
	}

	@Override
	public boolean deleteDescription(int desId) {
		repo.deleteById(desId);
		return true;
	}

	@Override
	public Description findByDescriptionId(int DesId) {
		// TODO Auto-generated method stub
		return repo.findById(DesId).get();
	}

}
