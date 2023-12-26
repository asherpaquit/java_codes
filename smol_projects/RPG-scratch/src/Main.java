import java.util.*;

public class Main {
	static Scanner scan = new Scanner(System.in);
	public static void main(String[] args) {
		Character pl = new Character();
		System.out.print("Enter name of Adventurer: ");
		pl.setName(scan.next());
		System.out.println("Hello "+pl.getName());
		pl.chooseWeapon();
		
		pl.printWeaponStats();
		
		pl.chooseArmor();
		
		pl.printArmorStats();
		
		pl.printSummarizeStats();
	}
}
