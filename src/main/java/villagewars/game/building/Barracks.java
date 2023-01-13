package villagewars.game.building;

import TCP.Select;
import TCP.Update;
import villagewars.game.units.Soldiers;
import villagewars.game.village.Village;

public class Barracks{
	WareHouse wareHouse;
	public int villageID;

	public Barracks(WareHouse wareHouse, int villageID) {
		this.wareHouse = wareHouse;
		this.villageID = villageID;
	}

	static final int MIN_RATIO = 2;
	
	int PIKEMAN_ATTACK_POWER = 50;
	int PIKEMAN_DEFENCE_POWER = 150;
	int PIKEMAN_LOOT_CAPACITY = 10;

	int SWORDSMAN_ATTACK_POWER = 100;
	int SWORDSMAN_DEFENCE_POWER = 100;
	int SWORDSMAN_LOOT_CAPACITY = 50;

	int AXEMAN_ATTACK_POWER = 200;
	int AXEMAN_DEFENCE_POWER = 20;
	int AXEMAN_LOOT_CAPACITY = 25;
			
	Soldiers pikemans = new Soldiers(PIKEMAN_ATTACK_POWER, PIKEMAN_DEFENCE_POWER, PIKEMAN_LOOT_CAPACITY, "pikeman", villageID);
	Soldiers swordsmans = new Soldiers(SWORDSMAN_ATTACK_POWER, SWORDSMAN_DEFENCE_POWER,SWORDSMAN_LOOT_CAPACITY,"swordsman",  villageID);
	Soldiers axemans = new Soldiers(AXEMAN_ATTACK_POWER, AXEMAN_DEFENCE_POWER, AXEMAN_LOOT_CAPACITY, "axeman", villageID);

	public void recruitPikeman(int quantity){
		if(wareHouse.verifyResourcesAmount(20,50,10)){
			Update.incrementSoldiers(quantity, 0, 0, villageID);
			wareHouse.decreaseResources(20,50,10);
			}
		}
	
	public void recruitSwordsman(int quantity){
		if(wareHouse.verifyResourcesAmount(50,40,20)){
			Update.incrementSoldiers( 0, quantity,0, villageID);
			wareHouse.decreaseResources(50,40,20);
			}
	}
	
	public void recruitAxeman(int quantity){
		if(wareHouse.verifyResourcesAmount(50,50,50)){
			Update.incrementSoldiers( 0,0, quantity, villageID);
			wareHouse.decreaseResources(50,50,50);
			}
		}
	
	public void printArmy(){
		System.out.println("Your army:");
		System.out.println("Pikemans: " + pikemans.getQuantity());
		System.out.println("Swordsmans: " + swordsmans.getQuantity());
		System.out.println("Axemans: " + axemans.getQuantity());
		System.out.println("Defence power: " + calculateDefencePower());
		System.out.println("Attack power: " + calculateAttackPower());
	}
	
	public int calculateDefencePower(){
		int power = swordsmans.getDefencePower() + pikemans.getDefencePower() + axemans.getDefencePower();
		return power;
	}
	
	public int calculateAttackPower(){
		int power = swordsmans.getAttackPower() + pikemans.getAttackPower() + axemans.getAttackPower();
		return power;
	}

	public int calculateLootCapacity(){
		int loot = swordsmans.getLootCapacity() + pikemans.getLootCapacity() + axemans.getLootCapacity();
		return loot;
	}
	
	public void killAllSoliders(){
		pikemans.killAll();	
		swordsmans.killAll();
		axemans.killAll();
	}

	public int calculatePercent(Village defender){
		int attackerPower = this.calculateAttackPower();
		int defenderPower = (defender.getBarracks().calculateDefencePower())*MIN_RATIO;
		int result = 0;
		if(attackerPower > defenderPower) {
			result = defenderPower / attackerPower;
		}else{
			result = attackerPower / defenderPower;
		}
		return result;
	}

	public void killPercentSoldiers(int percentPoints){
		pikemans.killPercent(percentPoints);
		swordsmans.killPercent(percentPoints);
		axemans.killPercent(percentPoints);
	}

	public boolean atackSuccessed(Village defender){
		if(this.calculateAttackPower() > (defender.getBarracks().calculateDefencePower())*MIN_RATIO){
			return true;
		} else{
			return false;
		}
	}

	public Soldiers getPikemans() {
		return pikemans;
	}

	public Soldiers getSwordsmans() {
		return swordsmans;
	}

	public Soldiers getAxemans() {
		return axemans;
	}

	public int getLevel(){
		return Select.barracksLevel(villageID);
	}

}
