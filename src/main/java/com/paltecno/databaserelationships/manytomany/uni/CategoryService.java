package com.paltecno.databaserelationships.manytomany.uni;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

	@Autowired
	CategoryRepository repoCategory;

	public List<Category> allCategories() {
		return repoCategory.findAll();
	}

	public Category getCategory(int id) {
		return repoCategory.findById(id).get();
	}

	public Category addCategory(Category category) {
		category.setId(0);
		return repoCategory.save(category);
	}

	public void deleteCategory(int id) {
		repoCategory.deleteById(id);
	}

}
