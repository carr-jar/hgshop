package com.zyp.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.zyp.bean.Brand;

public interface BrandMapper {
	
	List<Brand> list(@Param("name")String name);

	int add(Brand brand);

	int delete(int id);

	int deleteBatch(int[] ids);

	Brand findById(int id);

	int update(Brand brand);

	/**
	 * 获取所有的品牌
	 * @return
	 */
	@Select("SELECT id,name,first_char as firstChar "
			+ " FROM hg_brand "
			+ "where deleted_flag=0"
			+ " ORDER BY name ")
	List<Brand> getAllBrands();

	
}
