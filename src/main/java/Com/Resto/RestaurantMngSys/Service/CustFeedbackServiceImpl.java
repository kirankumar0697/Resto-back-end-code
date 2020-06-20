package Com.Resto.RestaurantMngSys.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Com.Resto.RestaurantMngSys.Dao.CustFeedbackDao;
import Com.Resto.RestaurantMngSys.Entity.CustomerFeedback;


@Service
public class CustFeedbackServiceImpl implements CustFeedbackService {

	@Autowired
	CustFeedbackDao feedbackdao;
	
	@Override
	public String postFeedback(CustomerFeedback feedback) {
		feedbackdao.save(feedback);
		return "Thank You For Your Precious Feedback";
	}

}
