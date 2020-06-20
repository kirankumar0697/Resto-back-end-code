package Com.Resto.RestaurantMngSys.Controller;

import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Com.Resto.RestaurantMngSys.Entity.Sales;
import Com.Resto.RestaurantMngSys.Service.SalesService;


@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class SalesController {

	
	SalesService salesservice;
	
	@Autowired
	public SalesController(SalesService thesalesService) {
		salesservice=thesalesService;
	}

	
	@RequestMapping(value="/getsales/{fromdate}/{todate}", method = RequestMethod.GET)
	public List<Sales> getSalesDetails(@PathVariable Date fromdate, @PathVariable Date todate) {
		
		List<Sales> sales = null;
		
		sales = salesservice.getSaleDetails(fromdate, todate);
		
		return sales;
	}
}
