package com.zyp.service.imp;

import java.util.List;

import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zyp.bean.Brand;
import com.zyp.bean.Category;
import com.zyp.bean.Sku;
import com.zyp.bean.SpecOption;
import com.zyp.bean.Spu;
import com.zyp.bean.SpuVo;
import com.zyp.mapper.BrandMapper;
import com.zyp.mapper.CategoryMapper;
import com.zyp.mapper.SkuMapper;
import com.zyp.mapper.SpuMapper;
import com.zyp.service.GoodsService;


@Service(interfaceClass=GoodsService.class)
public class GoodsServiceImp  implements GoodsService{
	
	@Autowired
	CategoryMapper catmapper;
	@Autowired
	SpuMapper spuMapper;
	@Autowired
	BrandMapper brandMapper;
	@Autowired
	SkuMapper skuMapper;
	@Override
	public int addBrand(Brand brand) {
		// TODO Auto-generated method stub
		
		return 0;
	}

	@Override
	public int updateBrand(Brand brand) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteBrand(Integer id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public PageInfo<Brand> listBrand(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int addCategory(Category category) {
		// TODO Auto-generated method stub
		return catmapper.add(category);
	}
 
	@Override
	public int updateCategory(Category category) {
		// TODO Auto-generated method stub
		return catmapper.update(category);
	}

	@Override
	public int deleteCategory(Integer id) {
		// TODO Auto-generated method stub
		return catmapper.delete(id);
	}

	/**
	 * 
	 */
	@Override
	public PageInfo<Category> listCategory(String firstChar, int page) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Category> treeCategory() {
		// TODO Auto-generated method stub
		return catmapper.tree();
	}

	// spu的列表
	@Override
	public PageInfo<Spu> listSpu(int page, SpuVo vo) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		
		return new PageInfo<Spu>(spuMapper.list(vo));
	}

	@Override
	public int addSpu(Spu spu) {
		// TODO Auto-generated method stub
		return spuMapper.add(spu);
	}

	@Override
	public int updateSpu(Spu spu) {
		// TODO Auto-generated method stub
		return spuMapper.update(spu);
	}

	@Override
	public int deleteSpu(int id) {
		// TODO Auto-generated method stub
		return spuMapper.delete(id);
	}

	@Override
	public int deleteSpuBatch(int[] ids) {
		// TODO Auto-generated method stub
		return spuMapper.deleteSpuBatch(ids);
	}

	@Override
	public List<Brand> getAllBrands() {
		// TODO Auto-generated method stub
		return brandMapper.getAllBrands();
	}
	@Override
	public PageInfo<Sku> listSku(int page, Sku sku) {
		// TODO Auto-generated method stub
		PageHelper.startPage(page, 5);
		return new PageInfo<Sku>(skuMapper.list(sku));
	}

	@Override
	public int addSku(Sku sku) {
		// TODO Auto-generated method stub
		//先加主表
		int cnt = skuMapper.addSku(sku);
		List<SpecOption> specs = sku.getSpecs();
		for (SpecOption specOption : specs) {
			cnt += skuMapper.addSkuSpec(sku.getId(),specOption);
		}
		
		return cnt;
	}

	@Override
	public Sku getSku(int id) {
		// TODO Auto-generated method stub
		return skuMapper.get(id);
	}

	@Override
	public int updateSku(Sku sku) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSku(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int deleteSkuBatch(int[] id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Spu getSpu(int id) {
		// TODO Auto-generated method stub
		return spuMapper.findById(id);
	}
}
