package Com.Resto.RestaurantMngSys.Dao;

import java.sql.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import Com.Resto.RestaurantMngSys.Entity.Sales;



public interface SalesDao{

	List<Sales> getSales(Date fromdate, Date todate);

	void save(Sales sales);

}
