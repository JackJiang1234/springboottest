package com.jack.dao.service;

import com.jack.dao.pojo.SexEnum;
import com.jack.dao.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.util.List;

@Service
public class JdbcTmplUserServiceImpl implements JdbcTmplUserService {

    @Autowired
    private JdbcTemplate jdbcTemplate = null;

    private RowMapper<User> getUserMapper(){
        return (ResultSet rs, int rownum) -> {
            User user = new User();
            user.setId(rs.getLong("id"));
            user.setUserName(rs.getString("user_name"));
            int sexId = rs.getInt("sex");
            user.setSex(SexEnum.getEnumById(sexId));
            user.setNote(rs.getString("note"));

            return user;
        };
    }

    @Override
    public User getUser(Long id) {
        String sql = "select id, user_name, sex, note from t_user where id = ?";
        Object[] params = new Object[]{ id };
        return jdbcTemplate.queryForObject(sql, params, getUserMapper());
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        String sql = "select id, user_name, sex, note from t_user where user_name like concat('%', ?, '%') and note like concat('%', ?, '%');";
        Object[] params = new Object[]{ userName, note };
        return jdbcTemplate.query(sql, params, getUserMapper());
    }

    @Override
    @Transactional
    public int insertUser(User user) {
        String sql = "insert into t_user(user_name, sex, note)values(?, ?, ?);";
        int result = jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote());
        //throw  new RuntimeException("test");
        return  result;
    }

    @Override
    public int updateUser(User user) {
        String sql = "update t_user set user_name=?, sex=?, note=? where id=?;";
        return jdbcTemplate.update(sql, user.getUserName(), user.getSex().getId(), user.getNote(), user.getId());
    }

    @Override
    public int deleteUser(Long id) {
        return jdbcTemplate.update("delete from t_user where id = ?;", id);
    }
}
