package task_1;

import java.util.Arrays;
import java.util.Scanner;

public class IntegerArrays {
	
	//main()方法
	public static void main (String[] args) {
		
		IntegerArrays intArr = new IntegerArrays();
		
		//获取数组长度
		Scanner sc = new Scanner(System.in);
		System.out.print("Please enter an array length: ");
		int len = sc.nextInt();

		int[] intArray = intArr.getRandomNums(len);
		
		//1、打印出数组内容
		intArr.printArray(intArray);
		//2、显示前三名
		intArr.intArraySort(intArray);
		//3、打印出最小值，和，平均值
		intArr.calculation(intArray);
		
		sc.close();
	}
	
	//方法：创建整形数组，元素值为[1,120]间随机数
	public int[] getRandomNums(int len) {
		
	    int[] intArrays = new int[len];
		for (int i = 0; i < len; i++) {
			intArrays[i] = (int)(Math.random()*120);
		}
		return intArrays;
		
	}
	
	//方法：对随机数组进行升序排列，并输出最大值的前三名（如果 max<60 或 max>100 则忽略）
	public void intArraySort (int[] intArray) {
		
		Arrays.sort(intArray);
		
		int flag = 0;
		
		System.out.print("Top three: ");
		for (int i = intArray.length - 1; i >= 0; i--) {
			if(intArray[i] < 60 || intArray[i] > 100) {
				continue;
			}
			System.out.print(intArray[i] + " ");
			flag++;
			if (flag == 3) {
				break;
			}
		}
		System.out.println();
	}
	
	//方法：打印数组所有元素
	public void printArray(int[] intArray) {
		System.out.print("Output intArray: ");
		for (int i = 0; i < intArray.length; i++) {
			System.out.print(intArray[i] + " ");
		}
		System.out.println();
	}
	
	//方法：计算数组最小值、和、平均值，并打印输出
	public void calculation (int[] intArray) {
		
		int min = 0;	//最小值
		int sum = 0;	//和
		int avg = 0;	//平均值
		for (int i = 0; i < intArray.length; i++) {
			sum += intArray[i];
		}
		min = intArray[0];
		avg = sum / intArray.length;
		System.out.println("Min = " + min);
		System.out.println("Sum = " + sum);
		System.out.println("Avg = " + avg);

	}

}
