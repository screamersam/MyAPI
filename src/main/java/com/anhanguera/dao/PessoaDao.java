package com.anhanguera.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.anhanguera.dao.mapper.PessoaMapper;
import com.anhanguera.entity.PessoaEntity;

@Repository
public class PessoaDao extends BaseDao{

	private String tableName = "Pessoa";
	private String primaryKey = "idPessoa";
	private ArrayList<String> columns = new ArrayList<String>();
	
	public PessoaDao(){
		columns.add("nome");
		columns.add("idade");
	}
	
	public List<PessoaEntity> findAllPeoples(){
		
		List<PessoaEntity> result = new  ArrayList<PessoaEntity>();
		
		String sql = "SELECT * FROM " + tableName;		
			
		result = jdbcTemplate.query(sql, new PessoaMapper());
				
		return result;
	}
	
	public PessoaEntity findPeople(int id){
				
		String sql = "SELECT * FROM " + tableName + " WHERE " + primaryKey + "= ?"; 
				
		return jdbcTemplate.query(sql, new PessoaMapper(), id).get(0);
	}
	
	public PessoaEntity insert(PessoaEntity p){	
		
		SimpleJdbcInsert i = new SimpleJdbcInsert(jdbcTemplate);
		i.setTableName(tableName);
		i.setColumnNames(columns);
		i.setGeneratedKeyName(primaryKey);		
		Number key = i.executeAndReturnKey(new BeanPropertySqlParameterSource(p));		
		p.setIdPessoa(key.intValue());		
				
		return p;
	}
	
	public PessoaEntity update(int id, PessoaEntity p){
		
		String sql = "UPDATE "+ tableName + " SET "+columns.get(0)+" = ? ,"+ columns.get(1)+" = ? WHERE "+ primaryKey +" = ?";
		jdbcTemplate.update(sql, p.getNome(), p.getIdade(), id);
		p.setIdPessoa(id);
		return p;
	}
	
	public boolean delete(int id){
		
		String sql = "DELETE FROM " + tableName + " WHERE "+ primaryKey +" = ?";
		jdbcTemplate.update(sql,
				id);		
		return true;
 	}
}
