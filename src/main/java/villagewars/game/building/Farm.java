package villagewars.game.building;

public class Farm extends ProductionBuilding {
	public Farm(WareHouse wareHouse){
		super.wareHouse = wareHouse;
	}

public void increaseProduct(){
super.wareHouse.increaseFood(super.growth);	
}
};
