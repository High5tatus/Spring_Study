package org.person.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class Person2DAOImpl implements Person2DAO{
	@Autowired
	private JdbcTemplate template;
	
	@Override
	public void person_insert(PersonVO person) {
		String sql = "insert into person values(?,?,?,?,?)";
		Object[] param = new Object[] {
			person.getId(),person.getName(),person.getPassword(),person.getGender(),person.getJob()
		};
		template.update(sql, param);
	}

	@Override
	public List<PersonVO> person_list() {
		String sql = "select * from person";
		List<PersonVO> personlist = template.query(sql, new RowMapper<PersonVO>() {

			@Override
			public PersonVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonVO person = new PersonVO();
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
	public PersonVO person_view(String id) {
		String sql = "select * from person where id='"+id+"'";
		PersonVO user = template.queryForObject(sql, new RowMapper<PersonVO>(){
			@Override
			public PersonVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				PersonVO person = new PersonVO();
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
	public void person_update(PersonVO person) {
		String sql = "update person set name=?,job=?,gender=?,password=? where id=?";
		Object[] param = new Object[] {
			person.getName(),person.getJob(),person.getGender(),person.getPassword(),person.getId()	
		};
		template.update(sql,param);
		
	}

	@Override
	public void person_delete(String id) {
		String sql = "delete from person where id = '" + id + "'";
		template.update(sql);
		
		
	}

}
