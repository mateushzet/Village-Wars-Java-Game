package villagewars.game.building;

import TCP.Select;
import TCP.Update;

public class Rathaus{
	public Select select = new Select();
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
		int res;
		switch (buildingName){

			case "rathaus":
				res = neededResourcesToBuild(getLevel());
				if(wareHouse.verifyResourcesAmount(res,res,res)){
				Update.incrementBuildings(1, 0, 0, 0, 0, 0, villageID);
				Update.decrementResources(res,res,res,villageID);
			}
				break;

			case "barracks":
				res = neededResourcesToBuild(barracks.getLevel());
				if(wareHouse.verifyResourcesAmount(res,res,res)){
					Update.incrementBuildings(0, 0, 1, 0, 0, 0, villageID);
					Update.decrementResources(res,res,res,villageID);
				}
				break;

			case "farm":
				res = neededResourcesToBuild(farm.getLevel());
				if(wareHouse.verifyResourcesAmount(res,res,res)){
					Update.incrementBuildings(0, 0, 0, 1, 0, 0, villageID);
					Update.decrementResources(res,res,res,villageID);
				}
				break;

			case "mine":
				res = neededResourcesToBuild(mine.getLevel());
				if(wareHouse.verifyResourcesAmount(res,res,res)){
					Update.incrementBuildings(0, 0, 0, 0, 1, 0, villageID);
					Update.decrementResources(res,res,res,villageID);
				}
				break;

			case "timbercamp":
				res = neededResourcesToBuild(timberCamp.getLevel());
				if(wareHouse.verifyResourcesAmount(res,res,res)){
					Update.incrementBuildings(0, 0, 0, 0, 0, 1, villageID);
					Update.decrementResources(res,res,res,villageID);
				}
				break;

			case "warehouse":
				res = neededResourcesToBuild(wareHouse.getLevel());
				if(wareHouse.verifyResourcesAmount(res,res,res)){
					Update.incrementBuildings(0, 1, 0, 0, 0, 0, villageID);
					Update.decrementResources(res,res,res,villageID);
				}
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

	public int neededResourcesToBuild(int level){
	return level*level*100;
	}
};