package task_2;

public class Truck extends Vehicle {

	private int volumeOfCargo;	//载货量

	public int getVolumeOfCargo() {
		return volumeOfCargo;
	}

	public void setVolumeOfCargo(int volumeOfCargo) {
		this.volumeOfCargo = volumeOfCargo;
	}

	/**
	 * @param carModel
	 * @param price
	 * @param volumeOfCargo
	 */
	public Truck(String carModel, int price, int volumeOfCargo) {
		super(carModel, price);
		this.volumeOfCargo = volumeOfCargo;
	}
		
}
