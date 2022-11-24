public class TimberCamp extends ProductionBuilding{
	TimberCamp(WareHouse wareHouse){
		super.wareHouse = wareHouse;
	}

public void increaseProduct(){
	super.wareHouse.increaseWood(super.growth);	
}
};