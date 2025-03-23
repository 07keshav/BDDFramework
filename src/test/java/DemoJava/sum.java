package DemoJava;

import java.util.*;

public class sum {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int sum;
		try {

			System.out.println("Hello firast time using comand lne");
			System.out.print("enetr first element :: ");
			int i1 = sc.nextInt();
			System.out.print("enetr second element :: ");
			int i2 = sc.nextInt();
			sum = i1 + i2;
		} finally {
			sc.close();// need to close scanner sc connection object.
		}

		System.out.println("sum::" + sum);
	}
}
