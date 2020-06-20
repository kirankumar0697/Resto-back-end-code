package Com.Resto.RestaurantMngSys.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Resto.RestaurantMngSys.Entity.Customer;

public interface CustomerLoginDao extends JpaRepository<Customer, Integer>{

	Customer findByCustmailAndCustpass(String custmail, String custpass);

}
