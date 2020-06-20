package Com.Resto.RestaurantMngSys.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Resto.RestaurantMngSys.Dao.CategorySearchDao;
import Com.Resto.RestaurantMngSys.Dao.FoodItemSearchDao;
import Com.Resto.RestaurantMngSys.Entity.Category;
import Com.Resto.RestaurantMngSys.Entity.Fooditem;

@Service
public class FoodSearchServiceImpl implements FoodSearchService{
	
	@Autowired
	CategorySearchDao categorydao;
	
	@Autowired
	FoodItemSearchDao fooddao;

	@Override
	public List<Fooditem> searchFood(String categorytype) throws NullPointerException {
		
		System.out.println("In service: " + categorytype);
		 Category categ = categorydao.findByCategorytype(categorytype);
		 System.out.println("Category Id: "+ categ.getCategoryid());
		 
		 int categoryid = categ.getCategoryid();
		 
		 List<Fooditem> itemlist = fooddao.findByCategoryid(categoryid);
		//List<Fooditem> itemlist = fooddao.findByCategorytype(categorytype);
		
		return itemlist;
	}

}
