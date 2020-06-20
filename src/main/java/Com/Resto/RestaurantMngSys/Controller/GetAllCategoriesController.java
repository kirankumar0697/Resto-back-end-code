package Com.Resto.RestaurantMngSys.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Com.Resto.RestaurantMngSys.Entity.Category;
import Com.Resto.RestaurantMngSys.Service.GetCategoriesService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class GetAllCategoriesController {

	@Autowired
	GetCategoriesService getcategories;
	
	@RequestMapping(value="/getallcategories", method=RequestMethod.GET)
	public List<Category> getAllCategories() {
		List<Category> categories = null;
		try {
		categories = getcategories.getAllCategories();
		return categories;
		
		} catch(NullPointerException e) {
			System.out.println(e);
		}
		return categories;
	}
}
