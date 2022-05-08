package com.dao;

import com.bean.Address;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AddressMapper {

    Integer insertAddress(Address address);
}
