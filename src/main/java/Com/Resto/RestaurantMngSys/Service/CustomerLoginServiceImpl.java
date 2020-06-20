package Com.Resto.RestaurantMngSys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Resto.RestaurantMngSys.Dao.CustomerLoginDao;
import Com.Resto.RestaurantMngSys.Entity.Customer;

@Service
public class CustomerLoginServiceImpl implements CustomerLoginService {

	@Autowired
	CustomerLoginDao custdao;
	
	@Override
	public Customer checkLogin(String custmail, String custpass) throws NullPointerException {
		
		return custdao.findByCustmailAndCustpass(custmail, custpass);
	}

	

}
