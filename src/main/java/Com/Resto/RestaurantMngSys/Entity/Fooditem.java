package Com.Resto.RestaurantMngSys.Entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "fooditemtbl")
public class Fooditem {

	@Id
	private int itemid;
	private String itemname;
	private int categoryid;
	private double price;
	private String food_description;
	
	public Fooditem() {
		
	}

	public int getItemid() {
		return itemid;
	}

	public void setItemid(int itemid) {
		this.itemid = itemid;
	}

	public String getItemname() {
		return itemname;
	}

	public void setItemname(String itemname) {
		this.itemname = itemname;
	}

	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getFood_description() {
		return food_description;
	}

	public void setFood_description(String food_description) {
		this.food_description = food_description;
	}

	@Override
	public String toString() {
		return "Fooditem [itemid=" + itemid + ", itemname=" + itemname + ", categoryid=" + categoryid + ", price="
				+ price + ", food_description=" + food_description + "]";
	}
	
	
	
}
