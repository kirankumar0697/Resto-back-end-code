package Com.Resto.RestaurantMngSys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Resto.RestaurantMngSys.Entity.Admin;


@Service
public class AdminLoginServiceImpl implements AdminLoginService{
	
	@Autowired
	AdminLoginDao addao;

	@Override
	public Admin checkLogin(String adusrname, String adpassword) throws NullPointerException {
		
		return addao.findByAdusrnameAndAdpassword(adusrname, adpassword);
	}
	
	
	

}
