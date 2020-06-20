package Com.Resto.RestaurantMngSys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Resto.RestaurantMngSys.Dao.AdminChangePasswordDao;
import Com.Resto.RestaurantMngSys.Entity.Admin;
import Com.Resto.RestaurantMngSys.Entity.AdminPassword;



@Service
public class AdminChangePassServiceImpl implements AdminChangePasswordService{

	@Autowired
	AdminChangePasswordDao admindao;
	
	@Override
	public String updatepassword(String adusrname, AdminPassword adpass) {
		if(admindao.findByAdusrname(adusrname) == null) {
			throw new NullPointerException();
		} else {
			Admin  updatedadmin = admindao.findByAdusrname(adusrname);
			
			String upadminpass = updatedadmin.getAdpassword();
			String currpass = adpass.getCurrentpassword();
			String newpass = adpass.getNewpassword();
			String confirmpass = adpass.getConfirmpassword();
		
			if(upadminpass.equals(currpass) && newpass.equals(confirmpass)) {
				
				updatedadmin.setAdpassword(adpass.getConfirmpassword());
				
				admindao.save(updatedadmin);
				return "Successfully changed password";
			} else {
				return "Not Matched";
			}
						
		}
		
	}

}
