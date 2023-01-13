package villagewars.game.building;

import TCP.Select;

public class Farm {

	public int villageID;
	public WareHouse wareHouse;
	public Farm(WareHouse wareHouse, int villageID) {
		this.villageID = villageID;
		this.wareHouse = wareHouse;
	}

public void increaseProduct(){
wareHouse.increaseFood(getGrowth());
}

public int getGrowth(){
	return Select.farmLevel(villageID)*10;
}

	public int getLevel(){
		return Select.farmLevel(villageID);
	}
};
