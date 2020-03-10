package com.zyp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zyp.bean.Brand;
import com.zyp.bean.Spec;
import com.zyp.service.BrandService;

/**
 * 品牌管理
 *
 */
@Controller
@RequestMapping("brand")
public class BrandCtroller {
	@Reference
	BrandService brandService;
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue="1") int pageNum,String name) {
		
		PageInfo<Brand> pageInfo = brandService.list(pageNum,name);
		request.setAttribute("p", pageInfo);
		return "brand/list";
	}
	/*
	 * 添加品牌
	 */
	@ResponseBody
	@RequestMapping("add")
	public Object add(Brand brand) {
		return brandService.add(brand)>0;
	}

	/**
	 * 删除品牌
	 */
	@RequestMapping("delBrand")
	@ResponseBody
	public String delSpec(HttpServletRequest request,int id) {
		//调用服务
		int delNum = brandService.delete(id);
		return delNum>0?"success":"false";
	}
	
	/**
	 * 批量删除品牌
	 */
	@RequestMapping("delBrandBatch")
	@ResponseBody
	public String delSpecBatch(HttpServletRequest request,@RequestParam(name="ids[]") int[] ids) {
		//调用服务
		int delNum = brandService.deleteBatch(ids);
		return delNum>0?"success":"false";
	}
	
	/*
	 * 修改回显
	 */
	@RequestMapping("getBrand")
	@ResponseBody
	public Brand getSpec(int id){
		return brandService.findById(id);
		
	}
	
	/*
	 * 修改品牌
	 */
	@RequestMapping("update")
	@ResponseBody
	public Object update(Brand brand) {
		int update = brandService.update(brand);  
		return update>0;
	}
}
