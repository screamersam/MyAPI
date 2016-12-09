package com.anhanguera.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.anhanguera.dao.PessoaDao;
import com.anhanguera.entity.PessoaEntity;

@RestController
@RequestMapping(value="/myapi")
public class PessoaController {

	@Autowired
	PessoaDao dao;
	
	@RequestMapping(value="/pessoa/", method=RequestMethod.GET)
	public List<PessoaEntity> findAllPeoples(){
		
		return dao.findAllPeoples();
	}
	
	@RequestMapping(value="/pessoa/{id}", method=RequestMethod.GET)
	public PessoaEntity findPeople(@PathVariable("id") int id){
		
		return dao.findPeople(id);
	}
		
	@RequestMapping(
			value="/pessoa/",
			method=RequestMethod.POST,
			consumes="application/json",
			produces="application/json"
			)
	public PessoaEntity insert(@RequestBody PessoaEntity p){
		
		return dao.insert(p);
	}
	
	@RequestMapping(
			value="/pessoa/{id}",
			method=RequestMethod.PUT			
			)
	public PessoaEntity update(@PathVariable("id") int id, @RequestBody PessoaEntity p){
		return dao.update(id, p);
	}
	
	@RequestMapping(value="/pessoa/{id}", method=RequestMethod.DELETE)
	public boolean delete(@PathVariable("id") int id){
		
		dao.delete(id);
		return true; 
	}	
}
