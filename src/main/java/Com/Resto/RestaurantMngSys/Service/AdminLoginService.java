package Com.Resto.RestaurantMngSys.Service;

import Com.Resto.RestaurantMngSys.Entity.Admin;

public interface AdminLoginService {

	public Admin checkLogin(String adusrname, String adpassword);
}
