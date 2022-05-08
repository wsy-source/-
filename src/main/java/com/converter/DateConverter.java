package com.converter;

import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String source) {
        String s = source.replaceAll("/", "-");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            return simpleDateFormat.parse(s);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public <U> Converter<String, U> andThen(Converter<? super Date, ? extends U> after) {
        return Converter.super.andThen(after);
    }
}
