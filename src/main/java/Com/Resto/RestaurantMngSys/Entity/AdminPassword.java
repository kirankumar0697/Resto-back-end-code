package Com.Resto.RestaurantMngSys.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class AdminPassword {
	
	@Id
	private String adusrname;
	private String currentpassword;
	private String newpassword;
	private String confirmpassword;
	public String getAdusrname() {
		return adusrname;
	}
	public void setAdusrname(String adusrname) {
		this.adusrname = adusrname;
	}
	public String getCurrentpassword() {
		return currentpassword;
	}
	public void setCurrentpassword(String currentpassword) {
		this.currentpassword = currentpassword;
	}
	public String getNewpassword() {
		return newpassword;
	}
	public void setNewpassword(String newpassword) {
		this.newpassword = newpassword;
	}
	public String getConfirmpassword() {
		return confirmpassword;
	}
	public void setConfirmpassword(String confirmpassword) {
		this.confirmpassword = confirmpassword;
	}
	@Override
	public String toString() {
		return "AdminPassword [adusrname=" + adusrname + ", currentpassword=" + currentpassword + ", newpassword="
				+ newpassword + ", confirmpassword=" + confirmpassword + "]";
	}
	
	

}
