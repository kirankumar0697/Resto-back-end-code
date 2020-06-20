package Com.Resto.RestaurantMngSys.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import Com.Resto.RestaurantMngSys.Entity.CustomerFeedback;
import Com.Resto.RestaurantMngSys.Service.AdminFeedbackViewServiceImpl;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class AdminFeedbackViewController {
	
	@Autowired
	AdminFeedbackViewServiceImpl viewservice;

	@RequestMapping(value="/viewfeedback", method=RequestMethod.GET)
	public List<CustomerFeedback> getAllFeedback() {
		List<CustomerFeedback> feedbacklist = viewservice.getAllFeedback();
		return feedbacklist;
	}
}
