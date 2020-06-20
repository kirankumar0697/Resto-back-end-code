//package com.javatechie.spring.paytm.api;
package Com.Resto.RestaurantMngSys.Controller;

import java.sql.Date;

import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;



import com.paytm.pg.merchant.CheckSumServiceHelper;

import Com.Resto.RestaurantMngSys.Service.SalesService;

@Controller
@CrossOrigin(origins = "http://localhost:4200")
public class PaymentController {
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	SalesService salesservice;
	
	private int orderid;
	private int customerid;
	private double totalcost;
	private Date salesdate;
	
	
	
	@GetMapping("/")
	public String home() {
		return "home";
	}

	 @PostMapping(value = "/pgredirect")
	    public ModelAndView getRedirect(@RequestParam(name = "CUST_ID") String customerId,
	                                    @RequestParam(name = "TXN_AMOUNT") String transactionAmount,
	                                    @RequestParam(name = "ORDER_ID") String orderId) throws Exception {
		 customerid = Integer.parseInt(customerId); 
		 orderid = Integer.parseInt(orderId); 
		 totalcost = Double.parseDouble(transactionAmount);
		 long millis=System.currentTimeMillis();  
	     java.sql.Date date=new java.sql.Date(millis);
	     salesdate = date;
	     
	     System.out.println(customerid+ " "+ orderid +" "+ totalcost + " "+ salesdate);
	        ModelAndView modelAndView = new ModelAndView("redirect:" + "https://securegw-stage.paytm.in/order/process");
	        TreeMap<String, String> parameters = new TreeMap<>();
	        //paytmDetails.getDetails().forEach((k, v) -> parameters.put(k, v));
	        parameters.put("MID", "avTRNm15861443970448");
	        parameters.put("MOBILE_NO", env.getProperty("paytm.mobile"));
	        parameters.put("CHANNEL_ID", "WEB");
	        
	        parameters.put("INDUSTRY_TYPE_ID", "Retail");
	        parameters.put("EMAIL", env.getProperty("paytm.email"));
	        parameters.put("ORDER_ID", orderId);
	        parameters.put("TXN_AMOUNT", transactionAmount);
	        parameters.put("CUST_ID", customerId);
	        parameters.put("WEBSITE", "WEBSTAGING");
	        parameters.put("CALLBACK_URL", "http://localhost:8080/pgresponse");
	        String checkSum = getCheckSum(parameters);
	        parameters.put("CHECKSUMHASH", checkSum);
	        modelAndView.addAllObjects(parameters);
	        return modelAndView;
	    }
	 
	 
	 @PostMapping(value = "/pgresponse")
	    public String getResponseRedirect(HttpServletRequest request, Model model) {

		 
	        Map<String, String[]> mapData = request.getParameterMap();
	        TreeMap<String, String> parameters = new TreeMap<String, String>();
	        mapData.forEach((key, val) -> parameters.put(key, val[0]));
	        String paytmChecksum = "";
	        if (mapData.containsKey("CHECKSUMHASH")) {
	            paytmChecksum = mapData.get("CHECKSUMHASH")[0];
	        }
	        String result;

	        boolean isValideChecksum = false;
	        System.out.println("RESULT : "+parameters.toString());
	        
	       // System.out.println("TXNDATE: " + TXNDATE);
	        try {
	            isValideChecksum = validateCheckSum(parameters, paytmChecksum);
	            if (isValideChecksum && parameters.containsKey("RESPCODE")) {
	                if (parameters.get("RESPCODE").equals("01")) {
	                    result = "Payment Successful";
	                    salesservice.saveSales(orderid, customerid, totalcost, salesdate);
	                    
	                } else {
	                    result = "Payment Failed";
	                }
	            } else {
	                result = "Checksum mismatched";
	            }
	        } catch (Exception e) {
	            result = e.toString();
	        }
	        model.addAttribute("result",result);
	        parameters.remove("CHECKSUMHASH");
	        model.addAttribute("parameters",parameters);
	        return "report";
	    }

	    private boolean validateCheckSum(TreeMap<String, String> parameters, String paytmChecksum) throws Exception {
	        return CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum("0AXuBpLWnuI#dUct",
	                parameters, paytmChecksum);
	    }


	private String getCheckSum(TreeMap<String, String> parameters) throws Exception {
		return CheckSumServiceHelper.getCheckSumServiceHelper().genrateCheckSum("0AXuBpLWnuI#dUct", parameters);
	}
	
	
	
}
