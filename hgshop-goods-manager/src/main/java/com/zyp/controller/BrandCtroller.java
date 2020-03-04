package com.zyp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageInfo;
import com.zyp.bean.Brand;
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
			@RequestParam(defaultValue="1") int pageNum) {
		
		PageInfo<Brand> pageInfo = brandService.list(pageNum);
		request.setAttribute("p", pageInfo);
		return "brand/list";
	}

}
