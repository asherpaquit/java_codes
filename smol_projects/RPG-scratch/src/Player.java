class Player {
	private String name;
	private int hp = 100;
	private String weapons;
	private String armor;
	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getHp() {
		return hp;
	}
	
	public void setWeapons(String weapons) {
		this.weapons = weapons;
	}
	
	public String getWeapons() {
		return weapons;
	}
	
	public void setArmor(String armor) {
		this.armor = armor;
	}
	
	public String getArmor() {
		return armor;
	}
}
