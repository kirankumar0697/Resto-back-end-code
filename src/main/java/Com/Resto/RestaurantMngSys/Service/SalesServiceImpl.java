package Com.Resto.RestaurantMngSys.Service;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import Com.Resto.RestaurantMngSys.Dao.SalesDao;
import Com.Resto.RestaurantMngSys.Entity.Sales;


@Service
public class SalesServiceImpl implements SalesService{

	
	SalesDao salesdao;
	
	@Autowired
	public SalesServiceImpl(SalesDao thesalesDAO) {
		salesdao=thesalesDAO;
	}

	
	@Transactional
	public List<Sales> getSaleDetails(Date fromdate, Date todate) {
		
		List<Sales> sales = salesdao.getSales(fromdate, todate);
		return sales;
	}


	@Transactional
	public void saveSales(int orderid, int customerid, double totalcost, Date salesdate) {
		Sales sales = new Sales();
		sales.setOrderid(orderid);
		sales.setCustid(customerid);
		sales.setTotalcost(totalcost);
		sales.setOrderdate(salesdate);
		salesdao.save(sales);
		
	}

}
