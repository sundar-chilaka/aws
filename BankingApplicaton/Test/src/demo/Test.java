package demo;

public class Test {
	
	// which is store the value 
	int id = 10;
	
	static int age = 22;
	
	
	public void a() {
		System.out.println("this is A");
		product();
		}
	
	public void b() {
		System.out.println("this is B");
		
		//a();
	}
	
	public Test(int id) {
		super();
		this.id = id;
	}

	public void product() {
		System.out.println("Uniliver");
	}
public static void main(String[] args) {
	
	int id = 22;
	// creating a object 
	Test test =new  Test(1000);
	System.out.println(test.id);
//	Test test2 = new Test(100);
//	// calling to referring object id 
//	System.out.println(test.id);
//	System.out.println(Test.age);
	
	System.out.println(id);
	System.out.println(test.id);

	
	test.a();
	

}
}
