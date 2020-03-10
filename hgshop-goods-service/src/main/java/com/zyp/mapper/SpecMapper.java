package com.zyp.mapper;

import java.util.List;

import com.zyp.bean.Spec;
import com.zyp.bean.SpecOption;


public interface SpecMapper {

	List<Spec> list(String name);

	int addSpec(Spec spec);

	int addOption(SpecOption specOption);

	int updateSpec(Spec spec);

	int deleteSpecOtions(int id);

	int deleteSpec(int id);

	Spec get(int id);

	int deleteSpecOtionsBatch(int[] ids);

	int deleteSpecBatch(int[] ids);

	List<Spec> listAll();

}
