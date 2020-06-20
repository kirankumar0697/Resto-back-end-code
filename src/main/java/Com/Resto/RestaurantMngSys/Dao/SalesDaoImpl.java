package Com.Resto.RestaurantMngSys.Dao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.query.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Com.Resto.RestaurantMngSys.Entity.Sales;



@Repository
public class SalesDaoImpl implements SalesDao {

private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public void EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}

	@Override
	public List<Sales> getSales(Date fromdate, Date todate) {
		
		Session currentSession= entityManager.unwrap(Session.class);
		
		
		System.out.println(fromdate +"  " + todate);
		
		    
		
		String hql = "select salesid, orderid, custid, totalcost, orderdate from Sales where orderdate between :fromdate and :todate";
		List result = currentSession.createQuery(hql)
		.setParameter("fromdate", fromdate).setParameter("todate", todate)
		.list();

		
	   
		Sales sale;
		List<Sales> salesList= new ArrayList<Sales>();
		Iterator iterator= result.iterator();
		while(iterator.hasNext()){
			Object[] tuple=(Object[]) iterator.next();
		        sale = new Sales();
		        sale.setSalesid((Integer)tuple[0]);
		        sale.setOrderid((Integer)tuple[1]);
		        sale.setCustid((Integer)tuple[2]);
		        sale.setTotalcost((Double)tuple[3]);
		        sale.setOrderdate((Date)tuple[4]);
		        salesList.add(sale);}
		System.out.println(salesList);
		
		return salesList;

		
	}

	@Override
	public void save(Sales sales) {
Session currentSession = entityManager.unwrap(Session.class);
		
		
		currentSession.save(sales);
		
	}

}
