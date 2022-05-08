package com.handler;

import com.bean.state.OrderState;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;
import org.springframework.stereotype.Component;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class OrderStateTypeHandler implements TypeHandler<OrderState> {
    @Override
    public void setParameter(PreparedStatement ps, int i, OrderState parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getNum());
    }

    @Override
    public OrderState getResult(ResultSet rs, String columnName) throws SQLException {
        int num = rs.getInt(columnName);
        return OrderState.getStatus(num);
    }

    @Override
    public OrderState getResult(ResultSet rs, int columnIndex) throws SQLException {
        int num = rs.getInt(columnIndex);
        return OrderState.getStatus(num);
    }

    @Override
    public OrderState getResult(CallableStatement cs, int columnIndex) throws SQLException {
        return null;
    }
}
