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
		 request.setAttribute("name", name);
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
		//调用服务
		int add = specService.add(spec);
		return add>0;
	}
	
	
	@RequestMapping("update")
	@ResponseBody
	public Object update(HttpServletRequest request,Spec spec) {
		spec.getOptions().removeIf(x->{return x.getOptionName()==null;});
		//调用服务
		int update = specService.update(spec);  
		return update>0;
	}
	
	
	
	/**
	 * 用于修改数据时候的回显
	 * @param request
	 * @param id 规格id
	 * @return
	 */
	@RequestMapping("getSpec")
	@ResponseBody
	public Spec getSpec(HttpServletRequest request, int id){
		return specService.findById(id);
		
	}
	
	
	/**
	 * 删除规格
	 * @param request
	 * @param id  规格的id
	 * @return
	 */
	@RequestMapping("delSpec")
	@ResponseBody
	public String delSpec(HttpServletRequest request,int id) {
		//调用服务
		int delNum = specService.delete(id);
		return delNum>0?"success":"false";
	}
	
	/**
	 * 删除规格
	 * @param request
	 * @param id  规格的id
	 * @return
	 */
	@RequestMapping("delSpecBatch")
	@ResponseBody
	public String delSpecBatch(HttpServletRequest request,@RequestParam(name="ids[]") int[] ids) {
		//调用服务
		int delNum = specService.deleteBatch(ids);
		return delNum>0?"success":"false";
	}

}

