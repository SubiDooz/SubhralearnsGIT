package examples;

abstract class AbstractClass{
	
	public AbstractClass() {
		System.out.println("Inside Constructor");
	}
	
	
	
	public abstract void abstractMethod1();
	public abstract void abstractMethod2();
	
	public void concreteMethod() {
		System.out.println("Concrete method inside Abstract Class");
	}
	
}

abstract class ExtendingClass extends AbstractClass{

	@Override
	public void abstractMethod1() {
		System.out.println("Overriding abstract method inside Extending Class");
		
	}
	
}

class NewExtendingClass extends ExtendingClass{

	@Override
	public void abstractMethod2() {
		System.out.println("Overriding abstract method inside New Extending Class");
		
	}
	
	public void concreteMethodNewExtendingClass(){
		System.out.println("Concrete method inside New Extending Class");
	}
	
}


public class AbstractClassExample {

	public static void main(String[] args) {
		NewExtendingClass e = new NewExtendingClass();
		e.abstractMethod1();
		e.concreteMethod();
		e.abstractMethod2();
		e.concreteMethodNewExtendingClass();
		
		ExtendingClass e1 = new NewExtendingClass();
		e1.abstractMethod1();
		e1.concreteMethod();
		e1.abstractMethod2();
		
	}

}
