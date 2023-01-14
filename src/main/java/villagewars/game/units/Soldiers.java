package villagewars.game.units;

import TCP.Select;
import TCP.Update;

public class Soldiers {
	private int attackPower;
	private int defencePower;
	private int lootCapacity;
	private String soldier;
	public int villageID;

	public Soldiers(int attackPower, int defencePower, int lootCapacity, String soldierName, int villageID){
		this.attackPower = attackPower;
		this.defencePower = defencePower;
		this.lootCapacity = lootCapacity;
		this.soldier = soldierName;
		this.villageID = villageID;
	}

	public int getDefencePower(){
		int quantity = getQuantity();
		int power = quantity * defencePower;
		return power;
	}
	
	public int getAttackPower(){
		int quantity = getQuantity();
		int power = quantity * attackPower;
		return power;
	}

	public int getLootCapacity(){
		int quantity = getQuantity();
		int loot = quantity * lootCapacity;
		return loot;
	}

	public void killPercent(int percentPoints){
		int quantity = getQuantity();
		int number = Math.round(((float)percentPoints/100) * quantity);
		switch (soldier) {
			case "pikeman":
				Update.decrementSoldiers(number,0,0,villageID);
				break;

			case "swordsman":
				Update.decrementSoldiers(0,number,0,villageID);
				break;

			case "axeman":
				Update.decrementSoldiers(0,0,number,villageID);
				break;
		}
	}

	public void killAll(){
		Update.setSoldiers(0,0,0,villageID);
	}

	public int getQuantity(){

		switch (soldier) {
			case "pikeman":
				return Select.quantityPikeman(villageID);

			case "swordsman":
				return Select.quantitySwordsman(villageID);

			case "axeman":
				return Select.quantityAxeman(villageID);

			default:
				return 0;
		}
}
}