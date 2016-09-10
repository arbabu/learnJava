package com.kavi.learnJava;

import java.util.Scanner;


public class ConvertTemp{
	//Prompt the user for the conversion type.
//Execute the appropriate method to convert the temperature.
//to write a method access-level return type name parameters followed by statements
	public static void farenheitToCelsius(){
		double fTemp,cTemp;
		 Scanner input = new Scanner(System.in); 
		 System.out.println("Enter a farenheit Temperature:");
		 fTemp=input.nextDouble();
		 input.close();
		 cTemp=(double)5/(double)9* (fTemp-32);
		 System.out.println("Temperature in Celsius" +cTemp);
	}
	public static void celsiusToFarenheit(){
		double fTemp, cTemp;
		 Scanner input = new Scanner(System.in); 
		 System.out.println("Enter a Celsius Temperature:");
		 cTemp=input.nextDouble();
		 input.close();
		 fTemp = (double)5/(double) 9* (cTemp-32);
		 System.out.println("Temperature in Farenheit " +fTemp);
	}
		 
		 

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConvertTemp tempresult = new ConvertTemp();
		int choice;
		Scanner input = new Scanner(System.in);	
		//Prompt user for type conversion
		System.out.println("Enter your Choice");
		System.out.println("1: Farenheit to celsius Conversion:"); 
		System.out.println("2. Celsius to Farenheit:");
		choice = input.nextInt();
		if (choice==1){
			farenheitToCelsius();
		} else {
			if (choice==2){
				celsiusToFarenheit();
			} else {
				System.out.println("Not in the cHoice range");
			}
		input.close();
		}
					
			}
	
			

	

}
