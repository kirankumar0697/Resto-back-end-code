package Com.Resto.RestaurantMngSys.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Resto.RestaurantMngSys.Dao.CategoryDao;
import Com.Resto.RestaurantMngSys.Entity.Category;



@Service
public class GetCategoriesServiceImpl implements GetCategoriesService{

	@Autowired
	CategoryDao categorydao;
	
	@Override
	public List<Category> getAllCategories() {
		
		return categorydao.findAll();
	}

}
