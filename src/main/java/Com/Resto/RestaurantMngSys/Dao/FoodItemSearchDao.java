package Com.Resto.RestaurantMngSys.Dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Resto.RestaurantMngSys.Entity.Fooditem;


public interface FoodItemSearchDao extends JpaRepository<Fooditem, Integer>{


	//List<Fooditem> findByCategorytype(String categorytype);

	List<Fooditem> findByCategoryid(int categoryid);

}
