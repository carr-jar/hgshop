package com.zyp.service.imp;

import org.apache.dubbo.config.annotation.Service;

import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyp.bean.Brand;
import com.zyp.bean.Spec;
import com.zyp.mapper.BrandMapper;
import com.zyp.service.BrandService;

@Service(interfaceClass=BrandService.class)
public class BrandServiceImp implements BrandService{
	@Autowired
	BrandMapper brandMapper;
	@Override
	public PageInfo<Brand> list(int pageNum,String name) {
		// TODO Auto-generated method stub
		PageHelper.startPage(pageNum, 3);
		return new PageInfo<Brand>(brandMapper.list(name));
	}
	@Override
	public int add(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.add(brand);
	}
	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		return brandMapper.delete(id);
	}
	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		return brandMapper.deleteBatch(ids);
	}
	@Override
	public Brand findById(int id) {
		// TODO Auto-generated method stub
		return brandMapper.findById(id);
	}
	@Override
	public int update(Brand brand) {
		// TODO Auto-generated method stub
		return brandMapper.update(brand);
	}
}
