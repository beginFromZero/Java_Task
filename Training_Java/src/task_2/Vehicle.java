package task_2;

public class Vehicle {

	private String carModel;	//车型
	private int price;			//价格
	
	public String getCarModel() {
		return carModel;
	}
	public void setCarModel(String carModel) {
		this.carModel = carModel;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * @param carModel
	 * @param price
	 */
	public Vehicle(String carModel, int price) {
		this.carModel = carModel;
		this.price = price;
	}
	
}
