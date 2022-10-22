import java.sql.*;
import java.util.Scanner;

public  class Atm {
	

	public static void main(String[] args) {
		connection c=new connection();
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
				
		System.out.println("welcome to atm  ");
		System.out.println("plese enter 1 to enter in your account or press 2 to create a new account");
		int a=sc.nextInt();
		if(a==1) {
			c.enteraccount();
			
		}
		else if(a==2) {
			c.createuser();
		}
		else {
			System.out.println("plese enter valid opetion");
		}
//		
	}

}
