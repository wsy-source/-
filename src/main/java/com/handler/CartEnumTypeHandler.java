package com.handler;

import com.bean.state.CartState;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class CartEnumTypeHandler implements TypeHandler<CartState> {
    @Override
    public void setParameter(PreparedStatement ps, int i, CartState parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getNum());
    }

    @Override
    public CartState getResult(ResultSet rs, String columnName) throws SQLException {
        return CartState.getStatus(rs.getInt(columnName));
    }

    @Override
    public CartState getResult(ResultSet rs, int columnIndex) throws SQLException {
        return CartState.getStatus(rs.getInt(columnIndex));
    }

    @Override
    public CartState getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
