package com.zyp.service.imp;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyp.bean.Spec;
import com.zyp.bean.SpecOption;
import com.zyp.mapper.SpecMapper;
import com.zyp.service.SpecService;

/**
 * 规格的管理
 *
 */
@Service(interfaceClass=SpecService.class)
public class SpecServiceImpl implements SpecService{
	
	@Autowired
	SpecMapper specmapper;

	@Override
	public PageInfo<Spec> list(String name, int page) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 3);
		return new PageInfo<Spec>(specmapper.list(name));
		
	}

	@Override
	public int add(Spec spec) {
		// TODO Auto-generated method stub
		//添加主表
		specmapper.addSpec(spec);
		// 这里才能获取到主键ID
		//添加子表
		List<SpecOption> options = spec.getOptions();
		//
		int n=1;
		for (SpecOption specOption : options) {
			// 设置主表的id
			specOption.setSpecId(spec.getId());
			specmapper.addOption(specOption);
			n++;
		}
		
		// 返回的是影响数据的条数
		return n;
	}

	
	@Override
	public int update(Spec spec) {
		// TODO Auto-generated method stub
		// 去子表中删除
		specmapper.deleteSpecOtions(spec.getId());
		// 修改主表
		specmapper.updateSpec(spec);	 
		// 插入子表
		List<SpecOption> options = spec.getOptions();
		for (SpecOption specOption : options) {
			// 设置主表的id
			specOption.setSpecId(spec.getId());
			specmapper.addOption(specOption);
		}
		
		return 1;
	}
	

	@Override
	public int delete(int id) {
		// TODO Auto-generated method stub
		//删除子表
		specmapper.deleteSpecOtions(id);
		//删除主表
		specmapper.deleteSpec(id);
		return 1;
	}

	@Override
	public Spec findById(int id) {
		// TODO Auto-generated method stub
		
		return specmapper.get(id);
	}

	@Override
	public int deleteBatch(int[] ids) {
		// TODO Auto-generated method stub
		//删除子表
		specmapper.deleteSpecOtionsBatch(ids);
		//删除主表
		specmapper.deleteSpecBatch(ids);
		return 1;
	}
	@Override
	public List<Spec> listAll() {
		// TODO Auto-generated method stub
		return specmapper.listAll();
	}
	

}
