package Com.Resto.RestaurantMngSys.Service;

import Com.Resto.RestaurantMngSys.Entity.Customer;

public interface CustomerLoginService {

	
	public Customer checkLogin(String custmail,String custpass);
}
