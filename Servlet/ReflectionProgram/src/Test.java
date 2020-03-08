 class ParentTest{
	
	public void m3(){
		System.out.println("m3 value");
	}
}
public class Test extends ParentTest{
	int a=10;
	static int b=20;
	private int c=30;
	static {
		System.out.println("static block");
	}
	{
		System.out.println("non static block");
	}
	public Test(){
		System.out.println("test constructor");
	}
	public Test(String name){
		System.out.println(name);
	}
	public void m1(){
		System.out.println("m1 called");
	}
	public void m1(int a) {
		System.out.println("parameter:"+a);
	}
	
}
