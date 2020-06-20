package Com.Resto.RestaurantMngSys.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import Com.Resto.RestaurantMngSys.Entity.Fooditem;
import Com.Resto.RestaurantMngSys.Service.MenuService;




@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/items")
public class MenuRestController {
	
	private MenuService menuService;
	
	// INJECTING MENU DAO(using constructor injection)
	@Autowired
	public MenuRestController(MenuService theMenuService) {
		menuService=theMenuService;
	}

	//expose "/menu" and return list of menu
	@GetMapping("/allmenu")
	public List<Fooditem> findAll()
	{
		return menuService.findAll();
	}
	
	//add mapping for GET /menu/{menuId}
	
	@GetMapping("/menu/{itemid}")
	public Fooditem getMenu(@PathVariable int itemid) {
		Fooditem theMenu=menuService.findById(itemid);
		
		if(theMenu==null) {
			throw new RuntimeException("Item id not found " + itemid);
		}
	  return theMenu;
	}
	
	//add mapping for post /menu - add new menu
	
	@PostMapping("/menu")
	public Fooditem addMenu(@RequestBody Fooditem fooditem) {
		
		//fooditem.setItemid(0);//just in case we pass id to json set id to 0 this
		                 //will force a save of new menuitem instead of update.
		
		menuService.save(fooditem);
		return fooditem;
		
	}	
		
		// add mapping for put /menu - update exisiting menu
	
	
		@PutMapping("/menu/{itemid}")
		public Fooditem updateMenu(@PathVariable int itemid, @RequestBody Fooditem fooditem) {
			menuService.updateFooditem(itemid, fooditem);
			return fooditem;
		}
		
		
		//add mapping for delete /menu/{menuId} - delete menu
		
		@DeleteMapping("/menu/{itemid}")
		public String deleteMenu(@PathVariable int itemid)
		{
			Fooditem tempMenu=menuService.findById(itemid);
			
			//throw excepyion if null
			
			if(tempMenu==null) {
				throw new RuntimeException("Item id not found " + itemid);
			}
			menuService.deleteById(itemid);
			return "deleted item id " + itemid;
		}
			
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

