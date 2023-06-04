package examples;

class GrandParent{
	
	public GrandParent() {
		System.out.println("I am constructor of Grand Parent Class");
	}
	
	public void grandFather() {
		System.out.println("I am from Grand Parent Class");
	}
}


class Parent extends GrandParent{
	
	public Parent() {
		System.out.println("I am constructor of Parent Class");
	}
	
	public Parent(String name) {
		System.out.println("I am argumented constructor of Parent Class" + name);
	}
	
	public void father() {
		System.out.println("I am from Parent Class");
	}
}

class Child extends Parent{
	
	public Child() {
		super("Soumi");
		System.out.println("I am constructor of Child Class");
	}
	
	public void son() {
		super.grandFather();
		super.father();
		System.out.println("I am from Child Class");
	}
	
	public void father() {
		System.out.println("I am from Child Class");
	}
}

public class InherienceExample {

	public static void main(String[] args) {
		//Parent p = new Parent();
		Child c = new Child();


		
	}

}

