import java.util.Scanner;
public class Weapons extends Player{
	static Scanner scan = new Scanner(System.in);
	private int AtkDmg = 0;
	private int AtkSpeed = 0;
	private String[] weapons = {"Dagger" , "Sword"};

	public void chooseWeapon() {
		System.out.println("----- Pick a Weapon -----");
		System.out.println("[1] Dagger   |  [2] Sword");
		System.out.println("10% AtkSpeed | 10% AtkDmg");
		
		int op = scan.nextInt();
		
		switch(op) {
		case 1:
			System.out.println("----- Congrats You Choose a Dagger ------");
			setWeapons("Dagger");
			AtkDmg = 10;
			AtkSpeed = 20;
			break;
		case 2:
			System.out.println("----- Congrats You Choose a Sword -------");
			setWeapons("Sword");
			AtkDmg = 20;
			AtkSpeed = 10;
			break;
		default:
			System.out.println("Oh boy, you really miss the spot here....");
			AtkDmg = 5;
			AtkSpeed = 5;
		}
		
	}
	
	public void setAtkDmg(int AtkDmg) {
		this.AtkDmg = AtkDmg;
	}
	
	public int getAtkDmg() {
		return AtkDmg;
	}
	
	public void setAtkSpeed(int AtkSpeed) {
		this.AtkSpeed = AtkSpeed;
	}
	
	public int getAtkSpeed() {
		return AtkSpeed;
	}
}
