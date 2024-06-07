package in.codetech.angulareducloud.portal.serviceImpl;

import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.codetech.angulareducloud.portal.module.exam.Category;
import in.codetech.angulareducloud.portal.repository.CategoryRepository;
import in.codetech.angulareducloud.portal.service.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public Category addCategory(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category) {
        Optional<Category> optionalCat = categoryRepository.findById(category.getCid());
        if (optionalCat.isPresent()) {
            Category updateCategory = optionalCat.get();
            updateCategory.setDescription(category.getDescription());
            updateCategory.setTitle(category.getTitle());
            return categoryRepository.save(updateCategory);
        }
        return null;
    }

    @Override
    public Set<Category> getCategories() {
        return new LinkedHashSet<>(categoryRepository.findAll());
    }

    @Override
    public Category getCategory(Long categoryId) {
        return categoryRepository.findById(categoryId).orElseThrow();
    }

    @Override
    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }
}
