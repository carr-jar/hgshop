package com.zyp.service;

import com.github.pagehelper.PageInfo;
import com.zyp.bean.Brand;

public interface BrandService {

	PageInfo<Brand> list(int pageNum, String name);

	int add(Brand brand);

	int delete(int id);

	int deleteBatch(int[] ids);

	Brand findById(int id);

	int update(Brand brand);
	
}
