package Com.Resto.RestaurantMngSys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Resto.RestaurantMngSys.Dao.CustRegistrationDao;
import Com.Resto.RestaurantMngSys.Entity.Customer;



@Service
public class CustRegistrationServiceImpl implements CustRegistrationService{
	
	@Autowired
	CustRegistrationDao custDao;

	@Override
	public String registerCustomer(Customer customer) {
		
		custDao.save(customer);
		System.out.println("customer saved!");
		return "Thank you for Registration";
	}

}
