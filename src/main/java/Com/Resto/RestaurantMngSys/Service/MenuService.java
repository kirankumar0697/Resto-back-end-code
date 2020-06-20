package Com.Resto.RestaurantMngSys.Service;

import java.util.List;

import Com.Resto.RestaurantMngSys.Entity.Fooditem;


public interface MenuService {
	public List<Fooditem> findAll();
	public Fooditem findById(int itemid);
	public void save(Fooditem fooditem);
	public void deleteById(int itemid);
	public void updateFooditem(int itemid, Fooditem fooditem);
}
