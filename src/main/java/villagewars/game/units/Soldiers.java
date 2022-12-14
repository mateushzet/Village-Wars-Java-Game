package villagewars.game.units;

public class Soldiers {
	private int quantity = 0;
	private int attackPower;
	private int defencePower;
	private int lootCapacity;

	public Soldiers(int attackPower, int defencePower, int lootCapacity){
		this.attackPower = attackPower;
		this.defencePower = defencePower;
		this.lootCapacity = lootCapacity;
		this.lootCapacity = lootCapacity;
	}
	
	public void recruit(int quantity){
		this.quantity += quantity;
	}
	
	public void recruit(){
		quantity++;
	}
	
	public int getQuantity(){
		return quantity;
	}
	
	public int getDefencePower(){
		int power = quantity * defencePower;
		return power;
	}
	
	public int getAttackPower(){
		int power = quantity * attackPower;
		return power;
	}
	
	public void kill(int quantity){
	this.quantity -= quantity;
	}
	
	public void killAll(){
	this.quantity = 0;
	}
}