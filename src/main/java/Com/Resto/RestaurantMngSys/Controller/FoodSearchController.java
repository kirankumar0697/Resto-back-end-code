package Com.Resto.RestaurantMngSys.Controller;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Com.Resto.RestaurantMngSys.Entity.Fooditem;
import Com.Resto.RestaurantMngSys.Service.FoodSearchService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class FoodSearchController {

	@Autowired
	FoodSearchService foodSearchService;
	
	@GetMapping("/searchfood/{categorytype}")
	public List<Fooditem> checkLogin(@PathVariable String categorytype) {
		
		List<Fooditem> searchedfood=null;
		try {
			System.out.println("In controller: " + categorytype);
			searchedfood=foodSearchService.searchFood(categorytype);
		return searchedfood;
		}
		catch(NullPointerException exception) {
			System.out.println(exception.getMessage());
		}
		return searchedfood;
		
	}

}
