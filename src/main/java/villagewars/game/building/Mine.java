package villagewars.game.building;

public class Mine extends ProductionBuilding {
	public Mine(WareHouse wareHouse){
		super.wareHouse = wareHouse;
	}

public void increaseProduct(){
super.wareHouse.increaseStone(super.growth);	
}
};