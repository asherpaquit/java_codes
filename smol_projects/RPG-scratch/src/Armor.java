
public class Armor extends Weapons{
	private String[] armor = {"Magic", "Resistance"};
	private int MgcBlk = 0;
	private int PhyBlk = 0;
	
	
	public void chooseArmor() {
		System.out.println("----- Pick a Armor -----");
		System.out.println("[1] Magic Armor   |  [2] Resistance Armor");
		System.out.println("10% MagicalBlk    | 10% PhysicalBlk");
		
		int op = scan.nextInt();
		
		switch(op) {
		case 1:
			System.out.println("----- Congrats You Choose a Magic Armor ------");
			setArmor("Magic Armor");
			PhyBlk = 10;
			MgcBlk = 20;
			break;
		case 2:
			System.out.println("----- Congrats You Choose a Resistance Armor -------");
			setArmor("Resistance Armor");
			PhyBlk = 20;
			MgcBlk = 10;
			break;
		default:
			System.out.print("Going on in a hard mode huh...");
			PhyBlk = 5;
			MgcBlk = 5;
			
		}
	}
	
	public void setMgcBlk(int MgcBlk) {
		this.MgcBlk = MgcBlk;
	}
	
	public int getMgcBlk() {
		return MgcBlk;
	}
	
	public void setPhyBlk(int PhyBlk) {
		this.PhyBlk = PhyBlk;
	}
	
	public int getPhyBlk() {
		return PhyBlk;
	}
}
