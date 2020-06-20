package Com.Resto.RestaurantMngSys.Dao;

import java.util.List;

import Com.Resto.RestaurantMngSys.Entity.Fooditem;




public interface MenuDAO {

	public List<Fooditem> findAll();
	public Fooditem findByItemid(int itemid);
	public void save(Fooditem fooditem);
	public void deleteByItemid(int itemid);
	
	
}
