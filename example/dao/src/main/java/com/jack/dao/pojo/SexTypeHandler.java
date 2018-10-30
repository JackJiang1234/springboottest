package com.jack.dao.pojo;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@MappedJdbcTypes(JdbcType.INTEGER)
@MappedTypes(value = SexEnum.class)
public class SexTypeHandler extends BaseTypeHandler<SexEnum> {
    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, SexEnum parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getId());
    }

    @Override
    public SexEnum getNullableResult(ResultSet rs, String columnName) throws SQLException {
        int sex = rs.getInt(columnName);
        if (sex != 1 && sex != 2) {
            return null;
        } else {
            return SexEnum.getEnumById(sex);
        }
    }

    @Override
    public SexEnum getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        int sex = rs.getInt(columnIndex);
        if (sex != 1 && sex != 2) {
            return null;
        } else {
            return SexEnum.getEnumById(sex);
        }
    }

    @Override
    public SexEnum getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        int sex = cs.getInt(columnIndex);
        if (sex != 1 && sex != 2) {
            return null;
        } else {
            return SexEnum.getEnumById(sex);
        }
    }
}
