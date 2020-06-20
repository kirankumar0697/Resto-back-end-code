package Com.Resto.RestaurantMngSys.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Com.Resto.RestaurantMngSys.Dao.MenuDAO;
import Com.Resto.RestaurantMngSys.Entity.Fooditem;

@Service
public class MenuServiceImpl implements MenuService {

	private MenuDAO menuDAO;
	
	@Autowired
	public MenuServiceImpl(MenuDAO theMenuDAO) {
		menuDAO=theMenuDAO;
	}
	
	
	@Transactional
	public List<Fooditem> findAll() {
		// TODO Auto-generated method stub
		return menuDAO.findAll();
	}

	@Transactional
	public Fooditem findById(int itemid) {
		// TODO Auto-generated method stub
		return menuDAO.findByItemid(itemid);
		
	}

	@Transactional
	public void save(Fooditem fooditem) {
		menuDAO.save(fooditem);
	}

	@Transactional
	public void deleteById(int itemid) {
		menuDAO.deleteByItemid(itemid);

	}


	@Transactional
	public void updateFooditem(int itemid, Fooditem fooditem) {
		// TODO Auto-generated method stub
		if(menuDAO.findByItemid(itemid) == null) {
			throw new NullPointerException("Item Not found");
		} else {
			System.out.println("first : " + fooditem);
			Fooditem item = menuDAO.findByItemid(itemid);
			item.setItemname(fooditem.getItemname());
			item.setCategoryid(fooditem.getCategoryid());
			item.setPrice(fooditem.getPrice());
			item.setFood_description(fooditem.getFood_description());
			System.out.println("updated: " + item);
			menuDAO.save(item);
		}
	}

}
