package com.nimap.CategorySpringbootwithHibernet;

import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class CategoryService {

		
		    @Autowired
		    private CategoryRepository repo;
		     
		    public List<Category> listAll() {
		        return repo.findAll();
		    }
		     
		    public void save(Category Category) {
		        repo.save(Category);
		    }
		     
		    public Category get(Integer id) {
		        return repo.findById(id).get();
		    }
		     
		    public void delete(Integer id) {
		        repo.deleteById(id);
		    }
}
