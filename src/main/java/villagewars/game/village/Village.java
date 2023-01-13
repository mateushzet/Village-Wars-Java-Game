package villagewars.game.village;

import villagewars.game.building.*;

public class Village{
	private Rathaus rathaus;
	public int villageID;

	public Village(int villageID) {
		rathaus = new Rathaus(villageID);
		this.villageID = villageID;
	}

	public void printBuildings(){
		System.out.println("ratusz - "+rathaus.getLevel());
		System.out.println("magazyn - "+getWareHouse().getLevel());
		System.out.println("koszary - "+getBarracks().getLevel());
		System.out.println("farma - "+getFarm().getLevel());
		}


		//----------TODO
	public void startResourcesProduction(){
	}
	public void stopResourcesProduction(){
	}
	
	public void attackVillage(Village defender){

		if(this.getBarracks().atackSuccessed(defender) == true){
			//zabijanie
			int percentToKill = getBarracks().calculatePercent(defender);
			this.getBarracks().killPercentSoldiers(percentToKill);
			defender.getBarracks().killAllSoliders();
			// lootowanie
			int loot = this.getBarracks().calculateLootCapacity();
			this.getWareHouse().transferResources(defender, loot, loot, loot);
		}else {
			// zabijanie
			int percentToKill = getBarracks().calculatePercent(defender);
			defender.getBarracks().killPercentSoldiers(percentToKill);
			this.getBarracks().killAllSoliders();
		}
	}


	public Barracks getBarracks() {
		return this.getRathaus().getBarracks();
	}

	public WareHouse getWareHouse() {
		return this.getRathaus().getWareHouse();
	}


	public Farm getFarm() {
		return this.getRathaus().getFarm();
	}

	public Mine getMine() {
		return this.getRathaus().getMine();
	}

	public TimberCamp getTimberCamp() {
		return this.getRathaus().getTimberCamp();
	}


	public Rathaus getRathaus() {
		return rathaus;
	}
}