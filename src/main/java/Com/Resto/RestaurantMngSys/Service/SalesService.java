package Com.Resto.RestaurantMngSys.Service;

import java.sql.Date;
import java.util.List;

import Com.Resto.RestaurantMngSys.Entity.Sales;


public interface SalesService {

	List<Sales> getSaleDetails(Date fromdate, Date todate);

	void saveSales(int orderid, int customerid, double totalcost, Date salesdate);

}
