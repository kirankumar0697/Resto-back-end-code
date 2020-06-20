package Com.Resto.RestaurantMngSys.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import Com.Resto.RestaurantMngSys.Entity.CustomerFeedback;
import Com.Resto.RestaurantMngSys.Service.CustFeedbackServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CustFeedbackController {
	
	@Autowired
	CustFeedbackServiceImpl feedbackservice;
	
	

	@RequestMapping(value="/feedback", method=RequestMethod.POST)
	public String getFeedback(@RequestBody CustomerFeedback feedback) {
		//System.out.println("feedback : "+feedback.getCustmail() +" " + feedback.getMessage());
		String result = feedbackservice.postFeedback(feedback);
//		ModelAndView mv = new ModelAndView();
//		if(result == "success")
//			mv.setViewName("feedbacksuccesspage");
//		else
//			mv.setViewName("feedback");
//		return mv;
		return result;
	}
}
