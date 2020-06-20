package Com.Resto.RestaurantMngSys.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Resto.RestaurantMngSys.Entity.Category;



public interface CategoryDao extends JpaRepository<Category, Integer>{

}
