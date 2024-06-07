package in.codetech.angulareducloud.portal.service;

import java.util.Set;

import in.codetech.angulareducloud.portal.module.exam.Category;

public interface CategoryService {
	
	 public Category addCategory(Category category);

	    public Category updateCategory(Category category);

	    public Set<Category> getCategories();

	    public Category getCategory(Long categoryId);

	    public void deleteCategory(Long categoryId);

}
