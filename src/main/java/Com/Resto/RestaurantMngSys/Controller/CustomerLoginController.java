package Com.Resto.RestaurantMngSys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import Com.Resto.RestaurantMngSys.Entity.Customer;
import Com.Resto.RestaurantMngSys.Service.CustomerLoginServiceImpl;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustomerLoginController {
	
	@Autowired
	CustomerLoginServiceImpl loginservice;

	@GetMapping("/customer/login/{custmail}/{custpass}")
	public Customer checkLogin(@PathVariable String custmail,@PathVariable String custpass) {
		
		Customer searchcustomer=null;
		try {
			searchcustomer=loginservice.checkLogin(custmail, custpass);
		return searchcustomer;
		}
		catch(NullPointerException exception) {
			System.out.println(exception.getMessage());
		}
		return searchcustomer;
		
	}

}
