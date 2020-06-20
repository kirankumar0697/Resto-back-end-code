package Com.Resto.RestaurantMngSys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Com.Resto.RestaurantMngSys.Entity.AdminPassword;
import Com.Resto.RestaurantMngSys.Service.AdminChangePasswordService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminPasswordController {

	@Autowired
	AdminChangePasswordService cpservice;
	
	@RequestMapping(value="/changepassword/{adusrname}", method = RequestMethod.PUT)
	public String updatePassword(@PathVariable String adusrname, @RequestBody AdminPassword adpass) {
		String result = cpservice.updatepassword(adusrname, adpass);
		return result;
	}
}
