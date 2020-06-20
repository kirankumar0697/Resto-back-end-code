package Com.Resto.RestaurantMngSys.Dao;

import org.springframework.data.repository.CrudRepository;

import Com.Resto.RestaurantMngSys.Entity.Customer;


public interface CustRegistrationDao extends CrudRepository<Customer, Long> {

}
