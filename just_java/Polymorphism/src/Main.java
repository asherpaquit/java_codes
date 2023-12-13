class Bird{
	public void sing(){
		System.out.print("tweet tweet madafaka");
	}
}


class Gorion extends Bird{
	public void sing() {
		System.out.print("vrooomm vroom *V8 sound engine");
	}
}

public class Main {
	
	public static void main(String[] args) {
		Bird b = new Gorion();
		b.sing();
	}
}
