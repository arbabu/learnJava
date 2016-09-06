package calculate;

public class ArunCalculate {
    int factor=10;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArunCalculate ac= new ArunCalculate();  //instantiate ArunCalculate
		System.out.println("Before calling the add");
		int value=ac.add(8, 10) + ac.factor + ac.add3(5, 7);
		System.out.println("After returning from Add : the value is -- > "+value);
		/*ArunCalculate ac=null;
		ac=new ArunCalculate(); Line #6 is same as #7 and #8 put together*/

	}
	 public int add(int a, int b) {
			System.out.println("In mehtod Add");
			int result=0;
			
			result = a+b;
			System.out.println("Returning Result to the Called method");
			//return add3(result, factor);
			return result;
	}
	public int add3(int d, int x) {
			int result2;
			result2 = d+x;
			//int result2=d + x; - same as above 2 lines
			int subResult=subtract(result2,5);
			return result2;
	}
	private int subtract(int v, int w) {
			int subValue=v-w;
			return subValue;
	}
}
