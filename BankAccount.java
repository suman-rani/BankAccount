package com.BankAccount;
import java.util.*;
interface ITransaction {
	 final int InitialBalance=10000;
	   int minbal=5000;
	   double withdraw(double withdralAmount,double balance);
	    double deposit(double amount);
	    double balance();
	  //void customerDetails();
	}
class SavingsAccount implements ITransaction{

	@Override
	public double withdraw(double withdralAmount,double balance) {
	if(withdralAmount>minbal)
	{
		System.out.println("Withdraw Attempt Failed");
		return balance;
		}
	else if(balance<0) {
		System.out.println("Insufficient Balance");
	    return balance;}
	else
		{
		
		 balance=balance-withdralAmount;
		System.out.println("Available Balance: "+balance);
		 return balance;
		}
	
		
	}
	@Override
	public double deposit(double amount) {
	double balance=amount+InitialBalance;
	System.out.println( "Balance: "+balance);	
	return balance;
	}
	@Override
	public double balance() {
		Scanner sc=new Scanner(System.in);
		double bal=sc.nextDouble();
		deposit(bal);
	    return bal;
	}
	


}
class CurrentAccount implements ITransaction{

	@Override
	public double withdraw(double currentamount,double balance) {
		if(balance<minbal)
			{
			System.out.println("Insufficient Balance");
			return balance;
			}
		else
			{
			 balance=balance-currentamount;
			System.out.println("Available Balance: "+ balance);
			return balance;
			}
	}

	@Override
	public double deposit(double amount) {
		double balance=amount+InitialBalance;
		System.out.println("Available Balaance: "+balance);
		return balance;
	}

	@Override
	public double balance() {	
		Scanner sc=new Scanner(System.in);
		double bal=sc.nextDouble();
		deposit(bal);
	    return bal;
	}


}

public class BankAccount {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Select the Account type: "+"\n"+"1.SavingsAccount"+"\n"+"2.CurrentAccount");
		System.out.println("Enter your choice: ");
		//char ch=sc.next().charAt(0);
		int ch;
		ch=sc.nextInt();
		int op;
		double balance=10000;
		char choice;
		if(ch==1)
		{
		do
		{
		  SavingsAccount s=new SavingsAccount();
		  System.out.println("Choose your option"+"\n"+"1.Deposit"+"\n"+"2.Withdraw"+"\n"+"3.Balance");
		  op=sc.nextInt();
		switch(op)
		{
		case 1:
		       System.out.println("Enter the Amount to deposit: ");
		       double amount=sc.nextDouble();
		       balance=s.deposit(amount);
		       break;
		case 2:
			   System.out.println("Enter the Amount to withdraw: ");
		       double withdralAmount=sc.nextDouble();
		       balance=s.withdraw(withdralAmount,balance);
		       break;
		case 3:
			   System.out.println("Available Balance is "+balance);
		       break;
		default:System.out.println("Please enter 1/2/3 only...");
		}
		System.out.println("Do u want to continue ?");
		choice=sc.next().charAt(0);
		 }while(choice=='y');	
		}else
		{
			do
			{
			CurrentAccount c=new CurrentAccount();
			System.out.println("Choose your option"+"\n"+"1.Deposit"+"\n"+"2.Withdraw"+"\n"+"3.Balance");
			op=sc.nextInt();
			switch(op)
			{
			case 1:
			      System.out.println("Enter the Amount to deposit: ");
			      double amount=sc.nextDouble();
			      balance=c.deposit(amount);
			break;
			case 2:System.out.println("Enter the Amount to withdraw: ");
			double currentamount=sc.nextDouble();
			balance=c.withdraw(currentamount,balance);
			break;
			case 3:System.out.println("Available Balance is "+balance);
			break;
			default:System.out.println("Please enter correct choice");		
		    }System.out.println("Do u want to continue ?");
			 choice=sc.next().charAt(0);
			 }while(choice=='y');		
	    }sc.close();

	}
	}