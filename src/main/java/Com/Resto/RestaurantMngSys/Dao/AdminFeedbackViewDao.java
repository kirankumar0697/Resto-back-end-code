package Com.Resto.RestaurantMngSys.Dao;

import org.springframework.data.repository.CrudRepository;

import Com.Resto.RestaurantMngSys.Entity.CustomerFeedback;


public interface AdminFeedbackViewDao extends CrudRepository<CustomerFeedback, Integer>{

}
