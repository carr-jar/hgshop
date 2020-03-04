package com.zyp.service.imp;

import org.apache.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyp.bean.Brand;
import com.zyp.mapper.BrandMapper;
import com.zyp.service.BrandService;

@Service(interfaceClass=BrandService.class)
public class BrandServiceImp implements BrandService{
	@Autowired
	BrandMapper brandMapper;
	@Override
	public PageInfo<Brand> list(int pageNum) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 3);
		return new PageInfo<Brand>(brandMapper.list());
	}

}
