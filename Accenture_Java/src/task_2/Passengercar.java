package task_2;

public class Passengercar extends Vehicle {

	private int numOfPassenger;	//载客量

	public int getNumOfPassenger() {
		return numOfPassenger;
	}

	public void setNumOfPassenger(int numOfPassenger) {
		this.numOfPassenger = numOfPassenger;
	}

	/**
	 * @param carModel
	 * @param price
	 * @param numOfPassenger
	 */
	public Passengercar(String carModel, int price, int numOfPassenger) {
		super(carModel, price);
		this.numOfPassenger = numOfPassenger;
	}
	
	
	
}
