package task_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CarRentalSystem implements PrintVehicles {
	
	private List<Vehicle> vehicleList;	//车辆信息清单
	
	private int[] customerRentalList;	//客户租车清单
	
	private int totalCost;	//总金额
	
	private int totalVolumeOfCargo;	//总载货量
	
	private int totalNumOfPassenger;	//总载客量
	
	private static Scanner sc;
	
	public List<Vehicle> getVehicleList() {
		return vehicleList;
	}

	public void setVehicleList(List<Vehicle> vehicleList) {
		this.vehicleList = vehicleList;
	}

	public int[] getCustomerRentalList() {
		return customerRentalList;
	}

	public void setCustomerRentalList(int[] customerRentalList) {
		this.customerRentalList = customerRentalList;
	}

	public int getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(int totalCost) {
		this.totalCost = totalCost;
	}

	public int getTotalVolumeOfCargo() {
		return totalVolumeOfCargo;
	}

	public void setTotalVolumeOfCargo(int totalVolumeOfCargo) {
		this.totalVolumeOfCargo = totalVolumeOfCargo;
	}

	public int getTotalNumOfPassenger() {
		return totalNumOfPassenger;
	}

	public void setTotalNumOfPassenger(int totalNumOfPassenger) {
		this.totalNumOfPassenger = totalNumOfPassenger;
	}

	//main()方法
	public static void main (String[] args) {
		
		CarRentalSystem carRenSys = new CarRentalSystem();
		sc = new Scanner(System.in);
		//判断是否需要租车
		if (carRenSys.isNeeded()) {
			//初始化租车列表
			carRenSys.initialize();
			//打印租车列表信息
			carRenSys.printVehicles();
			//创建客户租车清单
			carRenSys.createCarRentalList();
			//生成客户租车账单
			carRenSys.calculateTotal();
			carRenSys.generateBill();
			
		}
		sc.close();
		
	}
	
	//方法：是否需要租车
	public boolean isNeeded() {
		System.out.println("欢迎使用租车系统：");
		System.out.println("您是否需要租车：1是 2否");

		int flag = sc.nextInt();
		
		if (flag == 1) {
			return true;
		}
		return false;
	}
	
	//方法：初始化租车列表
	public void initialize() {
		
		List<Vehicle> vehicleList = new ArrayList<>();
		vehicleList.add(new Truck("松花江", 400, 4));
		vehicleList.add(new Truck("依维柯", 1000, 20));
		vehicleList.add(new Passengercar("奥迪A4", 500, 4));
		vehicleList.add(new Passengercar("马自达6", 400, 4));
		vehicleList.add(new Passengercar("金龙", 800, 20));
		vehicleList.add(new Pickup("皮卡雪6", 450, 2, 4));
		
		setVehicleList(vehicleList);
	}

	@Override	//方法：打印租车列表信息
	public void printVehicles() {
		
		System.out.println("您可租车的类型及其价目表：");
		System.out.println("序号\t汽车名称\t租金\t容量\t");

		int flag = 0;
		for (Vehicle car : getVehicleList()) {
			flag++;
			if (car instanceof Truck) {
				System.out.println(flag + "\t" + car.getCarModel() + "\t" + car.getPrice() + "\t" + ("载货:" + ((Truck) car).getVolumeOfCargo()) + "吨" + "\t");
			}
			if (car instanceof Passengercar) {
				System.out.println(flag + "\t" + car.getCarModel() + "\t" + car.getPrice() + "\t" + ("载人:" + ((Passengercar) car).getNumOfPassenger()) + "人" + "\t");
			}
			if (car instanceof Pickup) {
				System.out.println(flag + "\t" + car.getCarModel() + "\t" + car.getPrice() + "\t" + ("载货:" + ((Pickup) car).getVolumeOfCargo() + "吨 " + "载人:" + ((Pickup) car).getNumOfPassenger()) + "人" + "\t");
			}
		}
	}
	
	//方法：创建租车清单
	public void createCarRentalList () {
		
		System.out.println("请输入您要租车的数量：");
		
		//租车数量
		int vehicleNum = sc.nextInt();

		//创建客户租车清单
		int[] customerRentalList = new int[vehicleNum + 1];
		//车辆序号
		for (int i = 0; i < vehicleNum; i++) {
			System.out.println("请输入第" + (i + 1) + "辆车的序号：");
			customerRentalList[i] = sc.nextInt();
		}
		//租车天数
		System.out.println("请输入租车天数：");
		customerRentalList[vehicleNum] = sc.nextInt();
		
		setCustomerRentalList(customerRentalList);
	}
	
	//方法：打印客户租车账单
	public void generateBill () {
		
		List<Vehicle> vList = getVehicleList();
		int[] cRenList = getCustomerRentalList();
		int vehicleNum = cRenList.length-1;
		
		System.out.println("您的账单：");
		
		System.out.println("***可载人的车有：");
		for (int i = 0; i < vehicleNum; i++) {
			Vehicle vehicle = vList.get(cRenList[i] - 1);
			if (vehicle instanceof Passengercar || vehicle instanceof Pickup) {
				System.out.print("  " + vehicle.getCarModel());
			}
		}
		System.out.println("  共载人：" + getTotalNumOfPassenger() + "人");
		
		System.out.println("***可载货的车有：");
		for (int i = 0; i < vehicleNum; i++) {
			Vehicle vehicle = vList.get(cRenList[i] - 1);
			if (vehicle instanceof Truck || vehicle instanceof Pickup) {
				System.out.print("  " + vehicle.getCarModel());
			}
		}
		System.out.println("  共载货：" + getTotalVolumeOfCargo() + "吨");

		
		System.out.println("***租车总价格：" + getTotalCost() + "元");
	}
	
	//方法：计算总金额/总载货量/总载客量
	public void calculateTotal () {
		
		int totalC = 0;	//总金额
		int totalV = 0;	//总载货量
		int totalN = 0;	//总载客量
		int totalDays = 0;	//总天数
		
		List<Vehicle> vList = getVehicleList();
		int[] cRenList = getCustomerRentalList();
		int vehicleNum = cRenList.length-1;
		
		for (int i = 0; i < vehicleNum; i++) {
			
			Vehicle vehicle = vList.get(cRenList[i] - 1);
			totalC += vehicle.getPrice();
			if (vehicle instanceof Truck) {
				totalV += ((Truck) vehicle).getVolumeOfCargo();
			}
			if (vehicle instanceof Passengercar) {
				totalN += ((Passengercar) vehicle).getNumOfPassenger();
			}
			if (vehicle instanceof Pickup) {
				totalV += ((Pickup) vehicle).getVolumeOfCargo();
				totalN += ((Pickup) vehicle).getNumOfPassenger();
			}
			
		}
		
		totalDays = cRenList[vehicleNum];
		totalC = totalC * totalDays;
		
		setTotalCost(totalC);
		setTotalVolumeOfCargo(totalV);
		setTotalNumOfPassenger(totalN);
	}
}
