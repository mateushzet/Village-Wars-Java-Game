package villagewars.game.building;

import TCP.Select;

public class Mine {
	public int villageID;
	public WareHouse wareHouse;
	public Mine(WareHouse wareHouse, int villageID){
		this.wareHouse = wareHouse;
		this.villageID = villageID;
	}

public void increaseProduct(){
wareHouse.increaseStone(getGrowth());
}

	public int getGrowth(){
		return Select.mineLevel(villageID)*10;
	}

	public int getLevel(){
		return Select.mineLevel(villageID);
	}
};