package Com.Resto.RestaurantMngSys.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "admintbl")
public class Admin {
	@Id
	private int adminid;
	private String adusrname;
	private String adpassword;
	public int getAdminid() {
		return adminid;
	}
	public void setAdminid(int adminid) {
		this.adminid = adminid;
	}
	public String getAdusrname() {
		return adusrname;
	}
	public void setAdusrname(String adusrname) {
		this.adusrname = adusrname;
	}
	public String getAdpassword() {
		return adpassword;
	}
	public void setAdpassword(String adpassword) {
		this.adpassword = adpassword;
	}
	@Override
	public String toString() {
		return "Admin [adminid=" + adminid + ", adusrname=" + adusrname + ", adpassword=" + adpassword + "]";
	}
	
	
	
	
}
