package Com.Resto.RestaurantMngSys.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customertbl")
public class Customer {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(nullable = false)
	private Long custid;
	private String custname;
	private String custmail;
	private String custpass;
	private long custmobileno;
	private String custaddress;
	public Long getCustid() {
		return custid;
	}
	public void setCustid(Long custid) {
		this.custid = custid;
	}
	public String getCustname() {
		return custname;
	}
	public void setCustname(String custname) {
		this.custname = custname;
	}
	public String getCustmail() {
		return custmail;
	}
	public void setCustmail(String custmail) {
		this.custmail = custmail;
	}
	public String getCustpass() {
		return custpass;
	}
	public void setCustpass(String custpass) {
		this.custpass = custpass;
	}
	public long getCustmobileno() {
		return custmobileno;
	}
	public void setCustmobileno(long custmobileno) {
		this.custmobileno = custmobileno;
	}
	public String getCustaddress() {
		return custaddress;
	}
	public void setCustaddress(String custaddress) {
		this.custaddress = custaddress;
	}
	
	@Override
	public String toString() {
		return "Customer [custid=" + custid + ", custname=" + custname + ", custmail=" + custmail + ", custpass="
				+ custpass + ", custmobileno=" + custmobileno + ", custaddress=" + custaddress + "]";
	}
	
	
}
