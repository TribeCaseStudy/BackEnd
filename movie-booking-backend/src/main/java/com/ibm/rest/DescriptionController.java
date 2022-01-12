package com.ibm.rest;

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
import com.ibm.service.DescriptionService;

@CrossOrigin
@RestController
public class DescriptionController {
	
	@Autowired
	private DescriptionService service;

	@PostMapping(value="/des",consumes = "application/json")
	public void addDes(@RequestBody Description des)
	{
		service.addDescription(des);
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
}
