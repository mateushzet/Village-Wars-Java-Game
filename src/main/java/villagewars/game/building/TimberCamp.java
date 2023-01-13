package villagewars.game.building;

import TCP.Select;

public class TimberCamp{
	public int villageID;
	public WareHouse wareHouse;

	TimberCamp(WareHouse wareHouse, int villageID) {
		this.wareHouse = wareHouse;
		this.villageID = villageID;
	}

	public void increaseProduct(){
		wareHouse.increaseStone(getGrowth());
	}
	public int getGrowth(){
		return Select.timberCampLevel(villageID)*10;
	}

	public int getLevel(){
		return Select.timberCampLevel(villageID);
	}
};