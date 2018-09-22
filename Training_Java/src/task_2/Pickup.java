package task_2;

public class Pickup extends Vehicle {
	
	private int volumeOfCargo;	//载货量
	
	private int numOfPassenger;	//载客量

	public int getVolumeOfCargo() {
		return volumeOfCargo;
	}

	public void setVolumeOfCargo(int volumeOfCargo) {
		this.volumeOfCargo = volumeOfCargo;
	}

	public int getNumOfPassenger() {
		return numOfPassenger;
	}

	public void setNumOfPassenger(int numOfPassenger) {
		this.numOfPassenger = numOfPassenger;
	}

	/**
	 * @param carModel
	 * @param price
	 * @param volumeOfCargo
	 * @param numOfPassenger
	 */
	public Pickup(String carModel, int price, int volumeOfCargo, int numOfPassenger) {
		super(carModel, price);
		this.volumeOfCargo = volumeOfCargo;
		this.numOfPassenger = numOfPassenger;
	}

}
