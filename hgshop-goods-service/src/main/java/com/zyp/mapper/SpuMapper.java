package com.zyp.mapper;

import java.util.List;

import com.zyp.bean.Brand;
import com.zyp.bean.Spu;
import com.zyp.bean.SpuVo;

public interface SpuMapper {
	int add(Spu spu);

	int deleteSpuBatch(int[] ids);

	int update(Spu spu);

	List<Spu> list(SpuVo vo);

	int delete(int id);
	
	Spu findById(int id);
}
