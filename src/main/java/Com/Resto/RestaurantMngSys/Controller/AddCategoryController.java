package Com.Resto.RestaurantMngSys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Com.Resto.RestaurantMngSys.Entity.Category;
import Com.Resto.RestaurantMngSys.Service.AddCategoryService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AddCategoryController {
	
	@Autowired
	AddCategoryService addservice;
	
	@RequestMapping(value="/category/add", method = RequestMethod.POST)
	public String addNewCategory(@RequestBody Category category) {
		try {
			String result = addservice.saveCategory(category);
			return result;
		} catch (NullPointerException e) {
			System.out.println(e);
		}
		return "Success";
	}
}
