package com.ibm.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.entity.Description;
import com.ibm.repo.MovieRepository;
import com.ibm.service.DescriptionService;

@CrossOrigin
@RestController
public class DescriptionController {
	
	@Autowired
	private DescriptionService service;

	@PostMapping(value="/des",consumes = "application/json")
	public int addDes(@RequestBody Description des)
	{
		service.addDescription(des);
		return des.getDescriptionId();
	}
	
	@PutMapping(value="/des/update",consumes = "application/json")
	public void updateDes(@RequestBody Description des)
	{
		service.updateDescription(des);
	}
	
	@DeleteMapping(value="/des/delete/{desId}",produces = "application/json")
	public boolean deleteDes(@PathVariable int desId)
	{
		return service.deleteDescription(desId);
	}
	
	@GetMapping(value="/des/show/{desId}",produces = "application/json")
	public Description findByDesId(@PathVariable int desId)
	{
		return service.findByDescriptionId(desId);
	}
	
	@GetMapping(value="/des/{actor}/{actress}/{director}/{producer}/{writer}",produces = "application/json")
	public int findDes(@PathVariable String actor,@PathVariable String actress,@PathVariable String director,@PathVariable String producer,@PathVariable String writer)
	{
		return service.findDes(actor, actress, director, producer, writer);
	}
	
	@GetMapping(value="/des/all",produces = "application/json")
	public List<Description> findAll()
	{
		return service.findAll();
	}
	
	
}
