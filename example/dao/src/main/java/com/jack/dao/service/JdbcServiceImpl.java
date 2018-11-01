package com.jack.dao.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@Service
public class JdbcServiceImpl implements JdbcService {

    @Autowired
    private DataSource dataSource = null;

    @Override
    public int insertUser(String userName, String note) {
        Connection conn = null;
        int result = 0;
        try {
            conn = dataSource.getConnection();
            conn.setAutoCommit(false);
            conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);

            PreparedStatement ps = conn.prepareStatement("insert into t_user(user_name, note) values(?, ?)");
            ps.setString(1, userName);
            ps.setString(2, note);
            result = ps.executeUpdate();

            conn.commit();
        } catch (Exception ex) {
            if (conn != null){
                try{
                    conn.rollback();
                }
                catch (SQLException el){
                    el.printStackTrace();
                }
            }
            ex.printStackTrace();
        } finally {
            try {
                if (conn != null && !conn.isClosed()){
                    conn.close();
                }
            }catch(SQLException e){
                e.printStackTrace();
            }
        }
        return result;
    }
}
