package calculate;


import java.util.Scanner;

public class CalcTempArun {


public static void main(String[] args) {

// TODO Auto-generated method stub

CalcTempArun tc = new CalcTempArun();

Scanner input = new Scanner(System.in);

int choice;

System.out.println("Enter the choice 1 if the temperature needs to be converted from Celsius to Fahrenheit \n and 2 for Fahrenheit to Celsius:");

choice = input.nextInt();

if (choice ==1) {

celsiusToFahrenheit();

}

else {

fahrenheitToCelsius();

}



}

private static double celsiusToFahrenheit() {

double cTemp, fTemp;

Scanner input = new Scanner(System.in);

System.out.println("Enter the temperature in Celsius:");

cTemp = input.nextDouble();

input.close();

fTemp = cTemp*(double)9/(double)5 + (double)32;

System.out.println(cTemp+"degree Celsius is "+fTemp+"degree Fahrenheit");

return fTemp;
}

private static double fahrenheitToCelsius() {

double cTemp, fTemp;

Scanner input = new Scanner(System.in);

System.out.println("Enter the temperature in Fahrenheit:");

fTemp = input.nextDouble();

input.close();

cTemp = (fTemp-32)*(double)5/(double)9;

System.out.println(fTemp+" degree Fahrenheit is "+cTemp+" degree Celsius");

return cTemp;

}
}



