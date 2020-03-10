package com.zyp.mapper;

import java.util.List;

import com.zyp.bean.Category;



public interface CategoryMapper {

	 List<Category> tree();
	 
	 int add(Category category);

		/**
		 * 
		 * @param id
		 * @return
		 */
		int delete(Integer id);

		/**
		 * 修改
		 * @param category
		 * @return
		 */
		int update(Category category);
}
