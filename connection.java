package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class connection {
	 		void enteraccount() {
	 			Scanner sc=new Scanner(System.in);
	 			System.out.println("enter id and password to login to your account");
	 			int id=sc.nextInt();
	 			int password=sc.nextInt();
	 			try {
					Class.forName("com.mysql.jdbc.Driver");
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
					Statement stmt=con.createStatement();
	//				System.out.println(" connectionsuccessful");
					PreparedStatement s=con.prepareStatement("select * from user where id=? and password=?"); 
					s.setInt(1,id);
					s.setInt(2, password);
					  
					
					
					  ResultSet rs=s.executeQuery();
			            if(rs.next())
			            {
			                System.out.println("Login success");
			                
			               String name=rs.getString("name");
			                System.out.println(name);
			                int balance=rs.getInt("account_balance");
			                System.out.println(balance);
			                
			                
			                System.out.println("enter 1 you want to withdraw or enter 2 if you want to deposit");
			                int a=sc.nextInt();
			                if(a==1) {
			                	System.out.println("enter money you want to withdraw");
			                	int withdraw=sc.nextInt();
			                if(withdraw<=balance) {
			                	balance=balance-withdraw;
			                	
			            
			                	
			                	
			                	String sql = "UPDATE user " +
			                            "SET account_balance = "+balance+" WHERE id ="+id;
			                         stmt.executeUpdate(sql);
			                         
			                         
			                         System.out.println("your current balance is " +balance);
//			                       
//			                	 
//			                	
			                }
			                else
			                	System.out.println("you have less account balance");
			                }
			                if(a==2) {
			                	System.out.println("enter money you want to deposit");
			                	int deposit=sc.nextInt();
			               
			                	balance=balance+deposit;
			                	
			            
			                	
			                	
			                	String sql = "UPDATE user " +
			                            "SET account_balance = "+balance+" WHERE id ="+id;
			                         stmt.executeUpdate(sql);
			                         
			                         
			                         System.out.println("your current balance is " +balance);
//			                       
//			                	 
//			                	
			                }
			                	
			                }
			                
			                
			            
	 		
			            
	 			else{
			                System.out.println("login failed");
			               
			            }
			            }
					
					
				
	 		
			catch(Exception e) {
				System.out.println(e);
			}
				
	 			
	 		}
			
			
			
			void createuser() {
				Scanner sc=new Scanner(System.in);
				System.out.println("enter id, password , name ,amount to start atmtransations");
				int id=sc.nextInt();
				int pass=sc.nextInt();
				String name=sc.next();
				int balance=sc.nextInt();
				try {
					Class.forName("com.mysql.jdbc.Driver");
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/atm","root","root");
					Statement stmt=con.createStatement();
					System.out.println("successful");

					PreparedStatement s=con.prepareStatement("insert into user values(?,?,?,?)"); 
				s.setInt(1, id);
					s.setInt(2,pass);
				s.setString(3, name);
				s.setInt(4, balance);
				int i=s.executeUpdate();  
				System.out.println(i+" records inserted");  
			
			}
			catch(Exception e) {
				System.out.println(e);
			}
				
			}


}