package Com.Resto.RestaurantMngSys.Service;

import java.util.List;

import Com.Resto.RestaurantMngSys.Entity.Fooditem;

public interface FoodSearchService {

	List<Fooditem> searchFood(String category_type);

}
