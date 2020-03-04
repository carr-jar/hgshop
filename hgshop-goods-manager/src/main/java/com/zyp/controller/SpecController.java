package com.zyp.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.dubbo.config.annotation.Reference;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.zyp.bean.Spec;
import com.zyp.service.SpecService;

/**
 * 规格的管理
 */
@Controller
@RequestMapping("spec")
public class SpecController {
	
	@Reference
	SpecService specService;
	
	/**
	 * 进入规格的列表
	 * @param page
	 * @return
	 */
	@RequestMapping("list")
	public String list(HttpServletRequest request,
			@RequestParam(defaultValue="1") int pageNum,
			@RequestParam(defaultValue="") String name
	) {
		 PageInfo<Spec> pageInfo = specService.list(name, pageNum);
		 request.setAttribute("p", pageInfo);
		return "spec/list";
	}
	
	/**
	 * 添加
	 * @param request
	 * @param page
	 * @param name
	 * @return
	 */
	@RequestMapping("add")
	@ResponseBody
	public Object add(HttpServletRequest request,Spec spec 
	) {
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		//System.out.println("spec 处理后：" + spec);
		//调用服务
		int add = specService.add(spec);
		return add>0;
	}

}
