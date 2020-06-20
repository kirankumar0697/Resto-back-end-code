package Com.Resto.RestaurantMngSys.Dao;

import java.util.List;
import javax.persistence.EntityManager;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import Com.Resto.RestaurantMngSys.Entity.Fooditem;

@Repository
public class MenuDAOHibernateImpl implements MenuDAO {

	//define fields for entityManager
	private EntityManager entityManager;
	
	//set up constructor injection
	@Autowired
	public void EmployeeDAOHibernateImpl(EntityManager theEntityManager) {
		entityManager=theEntityManager;
	}
	
	
	public List<Fooditem> findAll() {
		// get the current hibernate session
		Session currentSession= entityManager.unwrap(Session.class);
		
		//create the query
		Query<Fooditem> theQuery= currentSession.createQuery("from Fooditem", Fooditem.class);
		
		//execute query and get result list
		List<Fooditem> menu=theQuery.getResultList();
		
		//return the results
		return menu;
		
	}


	@Override
	public Fooditem findByItemid(int itemid) {
		// get the current hibernate session 
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		// get the menu
		Fooditem fooditem=currentSession.get(Fooditem.class, itemid);
		
		//return the menu
		return fooditem;
	}


	@Override
	public void save(Fooditem fooditem) {
		Session currentSession = entityManager.unwrap(Session.class);
		
		//save menu
		currentSession.save(fooditem);
		
	}


	@Override
	public void deleteByItemid(int itemid) {
		
		Session currentSession = entityManager.unwrap(Session.class);
		
		//delete obj with primary key
  Query theQuery=currentSession.createQuery("delete from Fooditem where itemid=:itemid");
		theQuery.setParameter("itemid",itemid);
		
		
		theQuery.executeUpdate();
		
		
		
		
		
	}

}
