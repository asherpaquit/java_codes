
public class Character extends Armor{
	
	public void printWeaponStats() {
		if(getWeapons() == "Sword") {
			System.out.println("You have nice pick, The " + getWeapons());
		}
		else if(getWeapons() == "Dagger") {
			System.out.println("So you like flashy things huh, The " + getWeapons());
		}
		else {
			System.out.print("Whatever... UNARMED!");
		}
		System.out.println("");
		System.out.println("");
	}
	
	public void printArmorStats() {
		if(getArmor() == "Resistance Armor") {
			System.out.println("gotta love the smell of masculinity, am I right?");
		}
		else if(getArmor() == "Magic Armor") {
			System.out.println("wizards, gotta hate em");
		}
		else {
			System.out.print("you ain't him...");
		}
		System.out.println("");
		System.out.println("");
	}
	
	public void printSummarizeStats() {
		System.out.println("");
		if(getAtkDmg() == 20 && getPhyBlk() == 20) {
			System.out.println("===== Knight =====");
		}
		else if(getAtkSpeed() == 20 && getPhyBlk() == 20){
			System.out.println("===== Lancer =====");
		}
		else if(getAtkDmg() == 20 && getMgcBlk() == 20){
			System.out.println("===== Wizard Hunter =====");
		}
		else if(getAtkSpeed() == 20 && getMgcBlk() == 20){
			System.out.println("===== Rogue =====");
		}
		else {
			System.out.println("===== GOD =====");
			setAtkDmg(90);
			setAtkSpeed(90);
			setMgcBlk(90);
			setPhyBlk(90);
		}
		System.out.println("Attack: " + getAtkDmg());
		System.out.println("Attack Speed: " + getAtkSpeed());
		System.out.println("Physical Block: " + getPhyBlk());
		System.out.println("Magical Block: " + getMgcBlk());
	}
}
