package Com.Resto.RestaurantMngSys.Service;

import java.util.ArrayList;
import java.util.List;

import org.aspectj.weaver.ast.Var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Resto.RestaurantMngSys.Dao.AdminFeedbackViewDao;
import Com.Resto.RestaurantMngSys.Entity.CustomerFeedback;


@Service
public class AdminFeedbackViewServiceImpl implements AdminFeedbackViewService {

	@Autowired
	AdminFeedbackViewDao viewDao;
	
	@Override
	public List<CustomerFeedback> getAllFeedback() {
		List<CustomerFeedback> allfeeds =new ArrayList<CustomerFeedback>();
		viewDao.findAll().forEach(allfeeds::add);;
		return allfeeds;
	}

}
