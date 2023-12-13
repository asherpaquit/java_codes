package practice_1;


abstract class Dog{
	
	public void bark() {
		System.out.print("Bark!");
	}
	
	public abstract void poop();
	
}

class Chihuahua extends Dog{
	public void poop() {
		System.out.print("Hala naka igit!");
	}
}

public class Main {
	public static void main(String[] args) {
		Chihuahua c = new Chihuahua();
		
		c.bark();
		c.poop();
	}
}
