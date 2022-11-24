public class Mine extends ProductionBuilding{
	Mine(WareHouse wareHouse){
		super.wareHouse = wareHouse;
	}

public void increaseProduct(){
super.wareHouse.increaseStone(super.growth);	
}
};