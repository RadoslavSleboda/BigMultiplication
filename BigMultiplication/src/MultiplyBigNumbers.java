import java.math.BigInteger;
import java.util.Scanner;

public class MultiplyBigNumbers {

	public static void main(String[]args) {
		customAlgorithm("12345678901234567890", "11111111111111111111", false);
		bigIntegerSolution("12345678901234567890", "11111111111111111111", false);
		System.out.println("------------------------------------------------------");
		customAlgorithm("85259525519115998815891599", "2", false);
		bigIntegerSolution("85259525519115998815891599", "2", false);
		System.out.println("------------------------------------------------------");
		customAlgorithm("118918915529689829197919971", "714891981516191114874984", false);
		bigIntegerSolution("118918915529689829197919971", "714891981516191114874984", false);
		System.out.println("------------------------------------------------------");
		
		start();
	}
	
	public static void start() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Choose method of multiplication");
		System.out.println("Enter command biginteger for bigInteger solution or custom for my algorithm");
		String choice = sc.nextLine();
		
		if(choice.equals("biginteger")) {
			System.out.println("Big integer solution");
			System.out.println("");
			System.out.println("Enter first number: ");
			String a = sc.nextLine();
			System.out.println(a);
			System.out.println("Enter second number: ");
			String b = sc.nextLine();
			bigIntegerSolution(a, b, true);
			} else if(choice.equals("custom")) {
				System.out.println("Custom solution");
				System.out.println("");
				System.out.println("Enter first number: ");
				String a = sc.nextLine();
				System.out.println(a);
				System.out.println("Enter second number: ");
				String b = sc.nextLine();
				customAlgorithm(a, b, true);
			} else {
				System.out.println("Invalid command try again!");
				start();
		}
	}
	
	public static void bigIntegerSolution(String a, String b, boolean manual) {
		BigInteger first = new BigInteger(a);
		BigInteger second = new BigInteger(b);
		BigInteger result = first.multiply(second);
		System.out.println("Big integer result:  " + result);
		System.out.println(" ");
		
		if(manual) {
		start();
		}
	}
	

	
	public static void customAlgorithm(String a, String b, boolean manual) {
		
		String[] aArray = a.split("");
		String[] bArray = b.split("");
		int[] resultArray = new int[aArray.length + bArray.length];
		solution(0, 0, aArray, bArray, resultArray, manual);
	}
	public static void solution(int i, int j, String[] aArray, String[] bArray, int[] resultArray, boolean manual) {
	
		int aInt = Integer.parseInt(aArray[i]);
		int bInt = Integer.parseInt(bArray[j]);
		resultArray[i+j+1] += aInt * bInt;
		
		for(int x = 1;resultArray[i+j+x] >= 10; x--) {
			while(resultArray[i+j+x] >= 10) {
				resultArray[i+j+x] -= 10;
				resultArray[i+j+x-1] += 1;
			}
		}
		
		if(j < bArray.length-1) {
		solution(i, j+1, aArray, bArray, resultArray, manual);
		} else if(i < aArray.length-1) {
			solution(i+1, 0, aArray, bArray, resultArray, manual);
		} else {
			System.out.print("My algorithm result: ");
			
			for(int x = 0; x < resultArray.length; x++) {
				if(resultArray[0] != 0 || x != 0) {
				System.out.print(resultArray[x]);
				}
			}		
			System.out.println(" ");
			
			if(manual) {
				start();
			}
		}	
	}	
}

