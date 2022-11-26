package villagewars.game.village;

import villagewars.game.building.Rathaus;

public class Village{
	private Rathaus rathaus;

	public Village() {
		rathaus = new Rathaus();
	}

	public void printBuildings(){
		System.out.println("ratusz - "+rathaus.getLevel());
		System.out.println("magazyn - "+rathaus.getWareHouse().getLevel());
		System.out.println("koszary - "+rathaus.getBarracks().getLevel());
		System.out.println("farma - "+rathaus.getFarm().getLevel());
		}
		
	public void startResourcesProduction(){
	rathaus.getFarm().startProduction();
	rathaus.getMine().startProduction();
	rathaus.getTimberCamp().startProduction();
	}
	
	public void stopResourcesProduction(){
	rathaus.getFarm().stopProduction();
	rathaus.getMine().stopProduction();
	rathaus.getTimberCamp().stopProduction();
	}
	
	public void attackVillage(Village attacker, Village defender){
	if(attacker.rathaus.getBarracks().calculateAttackPower() > defender.rathaus.getBarracks().calculateDefencePower()){
		defender.rathaus.getBarracks().killAllSoliders();
		} else{
				attacker.rathaus.getBarracks().killAllSoliders();
			} 

	}

	public Rathaus getRathaus() {
		return rathaus;
	}
}