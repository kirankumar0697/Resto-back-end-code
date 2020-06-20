package Com.Resto.RestaurantMngSys.Controller;

import java.awt.PageAttributes.MediaType;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Com.Resto.RestaurantMngSys.Entity.Admin;
import Com.Resto.RestaurantMngSys.Service.AdminLoginServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminLoginController {
	
	@Autowired
	AdminLoginServiceImpl adservice;

		
	@GetMapping("/Admin/login/{adusrname}/{adpassword}")
	public Admin checkLogin(@PathVariable String adusrname,@PathVariable String adpassword) {
		
		Admin searchAdmin=null;
		try {
			
			searchAdmin=adservice.checkLogin(adusrname, adpassword);
			
		return searchAdmin;
		}
		catch(NullPointerException exception) {
			System.out.println(exception.getMessage());
		}
		
		return searchAdmin;
		
	}
	

	
	/*
	 * @RequestMapping(value="/login", method = RequestMethod.POST) public
	 * ModelAndView validateLogin(Admin admin) throws SQLException{ ModelAndView
	 * model = new ModelAndView();
	 * 
	 * Admin adm = adservice.isValid(admin);
	 * 
	 * if(adm == null) { System.out.println("loginpage");
	 * model.setViewName("login");
	 * 
	 * } else { System.out.println("home page"); model.setViewName("home"); }
	 * 
	 * return model; }
	 */	
}
