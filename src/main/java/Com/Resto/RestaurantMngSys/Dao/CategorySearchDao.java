package Com.Resto.RestaurantMngSys.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Resto.RestaurantMngSys.Entity.Category;

public interface CategorySearchDao extends JpaRepository<Category, Integer>{

	Category findByCategorytype(String categorytype);

}
