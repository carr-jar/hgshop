package com.zyp.service;

import com.github.pagehelper.PageInfo;
import com.zyp.bean.Brand;

public interface BrandService {

	PageInfo<Brand> list(int pageNum);
	
}
