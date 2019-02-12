package com.example.demo.dao;

import com.example.demo.util.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

@Repository
public class UserDao {

    @Autowired
    JdbcTemplate jdbcTemplate ;

    public User getUser(Long userId){
        String sql = "select * from user where id=?";
        User user = jdbcTemplate.queryForObject(sql,new UserRowMapper()
        ,userId);
        return user;



    }

    public List<User> getUserByDepartmentId(Long departmentId){

        String sql = "select * from user where department_id=?";
        List<User> users = jdbcTemplate.query(sql,new UserRowMapper(),departmentId);
        return users;
    }

    //新增用户，返回id
    public Integer insertUser(final User user){
        final String sql = "insert into user(name,department_id,create_time,password) values(?,?,?,?)";
        KeyHolder keyHolder = new GeneratedKeyHolder();
        jdbcTemplate.update(new PreparedStatementCreator() {
            @Override
            public PreparedStatement createPreparedStatement(Connection connection) throws SQLException {
                PreparedStatement ps = connection.prepareStatement(sql,new String[]{"id"});
                ps.setString(1,user.getName());
                ps.setDate(3,new java.sql.Date(System.currentTimeMillis()));
                ps.setInt(2,user.getDepartmentId());
                ps.setString(4,user.getPwd());
                return ps;
            }
        },keyHolder);
        return keyHolder.getKey().intValue();

    }

    static class UserRowMapper implements  RowMapper<User>{
        public User mapRow(ResultSet rs,int rowNum) throws SQLException{
            User user = new User();
            user.setName(rs.getString("name"));
            user.setId(rs.getInt("id"));
            user.setPwd(rs.getString("password"));
            user.setCreateDate(rs.getDate("create_time"));
            user.setDepartmentId(rs.getInt("department_id"));
            return user;
        }

    }



    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }
}
