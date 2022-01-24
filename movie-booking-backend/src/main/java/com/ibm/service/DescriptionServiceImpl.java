package com.ibm.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.entity.Description;
import com.ibm.entity.Movie;
import com.ibm.repo.DescriptionRepository;
import com.ibm.repo.MovieRepository;
/**
 * author : Ramya*/
@Service
public class DescriptionServiceImpl implements DescriptionService {

	@Autowired
	private DescriptionRepository repo;
	
	@Transactional
	@Override
	public void addDescription(Description d) {
		repo.save(d);
	}

	@Transactional
	@Override
	public void updateDescription(Description d) {
		repo.save(d);
	}

	@Transactional
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

	@Override
	public int findDes(String actor, String actress, String director, String producer, String writer) {
		// TODO Auto-generated method stub
		return repo.findDes(actor, actress, director, producer, writer);
	}

	@Override
	public List<Description> findAll() {
		// TODO Auto-generated method stub
		return repo.findAll();
	}
}
