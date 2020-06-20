package Com.Resto.RestaurantMngSys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Resto.RestaurantMngSys.Dao.CategoryDao;
import Com.Resto.RestaurantMngSys.Entity.Category;


@Service
public class AddCategoryServiceImpl implements AddCategoryService {

	@Autowired
	CategoryDao addcategorydao;
	
	@Override
	public String saveCategory(Category category) throws NullPointerException {
		addcategorydao.save(category);
		return "Category Successfully added";
	}

}
