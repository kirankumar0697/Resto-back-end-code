package Com.Resto.RestaurantMngSys.Entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "categorytbl")
public class Category {

	@Id
	@Column(name = "categoryid")
	private int categoryid;
	
	@Column(name = "categorytype")
	private String categorytype;
	
	public Category() {
		
	}
	
	public Category(int categoryid, String categorytype) {
		super();
		this.categoryid = categoryid;
		this.categorytype = categorytype;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public String getCategorytype() {
		return categorytype;
	}

	public void setCategorytype(String categorytype) {
		this.categorytype = categorytype;
	}

	@Override
	public String toString() {
		return "Category [categoryid=" + categoryid + ", categorytype=" + categorytype + "]";
	}

	
}
