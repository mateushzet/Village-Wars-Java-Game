public class Barracks extends Building{
	WareHouse wareHouse;
	
	int PIKEMAN_ATTACK_POWER = 50;
	int PIKEMAN_DEFENCE_POWER = 150;
	int PIKEMAN_LOOT_CAPACITY = 10;

	int SWORDSMAN_ATTACK_POWER = 100;
	int SWORDSMAN_DEFENCE_POWER = 100;
	int SWORDSMAN_LOOT_CAPACITY = 50;

	int AXEMAN_ATTACK_POWER = 200;
	int AXEMAN_DEFENCE_POWER = 20;
	int AXEMAN_LOOT_CAPACITY = 25;
	
	Barracks(WareHouse wareHouse){
		this.wareHouse = wareHouse;
	}
			
	Soldiers pikemans = new Soldiers(PIKEMAN_ATTACK_POWER, PIKEMAN_DEFENCE_POWER, PIKEMAN_LOOT_CAPACITY);
	Soldiers swordsmans = new Soldiers(SWORDSMAN_ATTACK_POWER, SWORDSMAN_DEFENCE_POWER,SWORDSMAN_LOOT_CAPACITY);
	Soldiers axemans = new Soldiers(AXEMAN_ATTACK_POWER, AXEMAN_DEFENCE_POWER, AXEMAN_LOOT_CAPACITY );

	public void recruitPikeman(){
		if(wareHouse.verifyResourcesAmount(20,50,10)){
			pikemans.recruit();	
			wareHouse.decreaseResources(20,50,10);
			}
		}
	
	public void recruitSwordsman(){
		if(wareHouse.verifyResourcesAmount(50,40,20)){
			swordsmans.recruit();	
			wareHouse.decreaseResources(50,40,20);
			}
	}
	
	public void recruitAxeman(){
		if(wareHouse.verifyResourcesAmount(50,50,50)){
			axemans.recruit();	
			wareHouse.decreaseResources(50,50,50);
			}
		}
	
	public void printArmy(){
		System.out.println("Your army:");
		System.out.println("Pikemans: " + pikemans.getQuantity());
		System.out.println("Swordsmans: " + swordsmans.getQuantity());
		System.out.println("Axemans" + axemans.getQuantity());
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
	
	public void killAllSoliders(){
		pikemans.killAll();	
		swordsmans.killAll();
		axemans.killAll();
	}	
};
