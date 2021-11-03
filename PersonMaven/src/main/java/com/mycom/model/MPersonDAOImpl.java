package com.mycom.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class MPersonDAOImpl implements MPersonDAO{
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void per_insert(Person person) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = {
				person.getId(),person.getName(),person.getPassword(),person.getGender(),person.getJob()
		};		
		template.update(sql, param);
	}

	@Override
	public List<Person> per_lsit() {
		String sql = "select * from person";
		List<Person> personlist = template.query(sql, new RowMapper<Person>() {

			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setGender(rs.getString("gender"));
				person.setId(rs.getString("id"));
				person.setJob(rs.getString("job"));
				person.setName(rs.getString("name"));
				person.setPassword(rs.getString("password"));
				return person;
			}
			
		});
		
		return personlist;
	}

	@Override
	public Person per_view(String id) {
		String sql = "select * from person where id='"+id+"'";
		Person user = template.queryForObject(sql, new RowMapper<Person>(){
			@Override
			public Person mapRow(ResultSet rs, int rowNum) throws SQLException {
				Person person = new Person();
				person.setGender(rs.getString("gender"));
				person.setId(rs.getString("id"));
				person.setJob(rs.getString("job"));
				person.setName(rs.getString("name"));
				person.setPassword(rs.getString("password"));
				return person;
			}
		});
		return user;
	}

	@Override
	public void per_update(Person person) {
		String sql = "update person set name=?,job=?,gender=?,password=? where id=?";
		Object[] param = new Object[] {
			person.getName(),person.getJob(),person.getGender(),person.getPassword(),person.getId()	
		};
		template.update(sql,param);
	}

	@Override
	public void per_delete(String id) {
		String sql = "delete from person where id = '" + id + "'";
		template.update(sql);
		
	}

	@Override
	public int per_count() {
		String sql = "select count(*) from person";
		int count = template.queryForObject(sql, Integer.class);
	
		return count;
	}

}
