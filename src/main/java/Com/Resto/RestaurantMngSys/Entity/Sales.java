package Com.Resto.RestaurantMngSys.Entity;


import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="salestbl")
public class Sales {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private int salesid;
	private int orderid;
	private int custid;
	private double totalcost;
	private Date orderdate;
	
	public Sales() {
		
	}

	public Sales(int salesid, int orderid, int custid, double totalcost, Date orderdate) {
		super();
		this.salesid = salesid;
		this.orderid = orderid;
		this.custid = custid;
		this.totalcost = totalcost;
		this.orderdate = orderdate;
	}

	public int getSalesid() {
		return salesid;
	}

	public void setSalesid(int salesid) {
		this.salesid = salesid;
	}

	public int getOrderid() {
		return orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	public int getCustid() {
		return custid;
	}

	public void setCustid(int custid) {
		this.custid = custid;
	}

	public double getTotalcost() {
		return totalcost;
	}

	public void setTotalcost(double totalcost) {
		this.totalcost = totalcost;
	}

	public Date getOrderdate() {
		return orderdate;
	}

	public void setOrderdate(Date orderdate) {
		this.orderdate = orderdate;
	}

	@Override
	public String toString() {
		return "Sales [salesid=" + salesid + ", orderid=" + orderid + ", custid=" + custid + ", totalcost=" + totalcost
				+ ", orderdate=" + orderdate + "]";
	}
	
	
	
	
}
