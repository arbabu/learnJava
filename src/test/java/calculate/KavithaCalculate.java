package calculate;

public class KavithaCalculate extends ArunCalculate {
	
	String a="I";
	String b="N";
	String c="D";
	String d="I";
	String e="A";

	public void extendTest()
	{
		int newResult=this.add(8, 20);
		System.out.println("factor before --> "+factor);
		this.factor=100;
		System.out.println("factor after--> "+factor);
		//super.factor=50;
		System.out.println("factor  super--> "+super.factor);//????????
		System.out.println("factor  this--> "+this.factor);

		System.out.println("New Result --> "+newResult*factor);
		
	}

}
