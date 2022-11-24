public class Farm extends ProductionBuilding{
	Farm(WareHouse wareHouse){
		super.wareHouse = wareHouse;
	}

public void increaseProduct(){
super.wareHouse.increaseFood(super.growth);	
}
};
