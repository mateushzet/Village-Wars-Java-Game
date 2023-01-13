package villagewars.game.building;

import TCP.Select;
import TCP.Update;

public class Rathaus{

	private  WareHouse wareHouse;
	private  Barracks barracks;
	private Farm farm;
	private Mine mine;
	private TimberCamp timberCamp;

	public int villageID;

	public Rathaus(int villageID) {
		wareHouse = new WareHouse(villageID);
		barracks = new Barracks(wareHouse,villageID);
		farm = new Farm(wareHouse,villageID);
		mine = new Mine(wareHouse,villageID);
		timberCamp = new TimberCamp(wareHouse,villageID);
		this.villageID = villageID;
	}



		public void levelUp(String buildingName){
		switch (buildingName){
			case "rathaus":
				Update.incrementBuildings(1,0,0,0,0,0,villageID);
				break;

			case "barracks":
				Update.incrementBuildings(0,0,1,0,0,0,villageID);
				break;

			case "farm":
				Update.incrementBuildings(0,0,0,1,0,0,villageID);
				break;

			case "mine":
				Update.incrementBuildings(0,0,0,0,1,0,villageID);
				break;

			case "timbercamp":
				Update.incrementBuildings(0,0,0,0,0,1,villageID);
				break;

			case "warehouse":
				Update.incrementBuildings(0,1,0,0,0,0,villageID);
				break;
		}
	}

	public WareHouse getWareHouse() {
		return wareHouse;
	}

	public Barracks getBarracks() {
		return barracks;
	}

	public Farm getFarm() {
		return farm;
	}

	public Mine getMine() {
		return mine;
	}

	public TimberCamp getTimberCamp() {
		return timberCamp;
	}

	public int getLevel(){
		return Select.rathausLevel(villageID);
	}
};