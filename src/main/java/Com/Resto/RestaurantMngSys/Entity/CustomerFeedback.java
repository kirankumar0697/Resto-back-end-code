package Com.Resto.RestaurantMngSys.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="custfeedbacktbl")
public class CustomerFeedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int feedbackid;
	
	private String custmail;
	
	private String message;

	public int getFeedbackid() {
		return feedbackid;
	}

	public void setFeedbackid(int feedbackid) {
		this.feedbackid = feedbackid;
	}

	public String getCustmail() {
		return custmail;
	}

	public void setCustmail(String custmail) {
		this.custmail = custmail;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "CustomerFeedback [feedbackid=" + feedbackid + ", custmail=" + custmail + ", message=" + message + "]";
	}
	
	
	
}
