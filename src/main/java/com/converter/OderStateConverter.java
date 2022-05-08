package com.converter;

import com.bean.state.OrderState;
import org.springframework.core.convert.converter.Converter;
public class OderStateConverter implements Converter<String,OrderState> {
    @Override
    public OrderState convert(String source) {
        int num = Integer.parseInt(source);
        OrderState status = OrderState.getStatus(num);
        return status;
    }

}
