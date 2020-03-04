package com.zyp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.zyp.bean.Brand;

public interface BrandMapper {
	
	List<Brand> list();
	
}
