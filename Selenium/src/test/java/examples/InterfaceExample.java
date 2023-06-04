package examples;

interface Iface{
	public abstract void abstractMethod1();
	void abstractMethod2();
	
	default void defaultMethod() {
		System.out.println("Default type method inside Interface");
	}
	
	static void staticMethod() {
		System.out.println("static type method inside Interface");
	}

}

class ImplementingClass implements Iface{

	@Override
	public void abstractMethod1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void abstractMethod2() {
		// TODO Auto-generated method stub
		
	}

	public void classMethod() {
		System.out.println("Instance method of Implementing class");
	}
	
}


public class InterfaceExample {

	public static void main(String[] args) {
		Iface i = new ImplementingClass();
		ImplementingClass ic = new ImplementingClass();
		i.abstractMethod1();
		i.abstractMethod2();
		i.defaultMethod();
		Iface.staticMethod();
		
		ic.classMethod();
	}

}
