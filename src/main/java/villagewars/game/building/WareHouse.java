package villagewars.game.building;

import TCP.Select;
import TCP.Update;
import villagewars.game.village.Village;

public class WareHouse{
	public int villageID;
	public Select select = new Select();

	public WareHouse(int villageID) {
		this.villageID = villageID;
	}

	public Boolean verifyResourcesAmount(int requiredStone, int requiredWood, int requiredFood){
		int stone = getStone();
		int wood = getWood();
		int food = getFood();
		if(stone >= requiredStone &&
		wood >= requiredWood &&
		food >= requiredFood) return true;
		else return false;
	}

	public void printResources(){
		int stone = getStone();
		int wood = getWood();
		int food = getFood();
		System.out.println("Stone: "+stone+" Wood: "+wood+"  Food: "+food);
		}

	public void increaseStone(int quantity){
		Update.incrementResources(0,0,quantity,villageID);
	}

	public void increaseWood(int quantity){
		Update.incrementResources(0,quantity,0,villageID);
	}

	public void increaseFood(int quantity){
		Update.incrementResources(quantity,0,0,villageID);
	}

	public void decreaseResources(int stone, int wood, int food){
		Update.decrementResources(food, wood, stone, villageID);
	}

	public void increaseResources(int stone, int wood, int food){
		Update.incrementResources(food, wood, stone, villageID);
	}

	public void transferResources(Village sender, int stone, int wood, int food){
		if(sender.getWareHouse().verifyResourcesAmount(stone, wood, food) == true) {
			this.increaseResources(stone, wood, food);
			sender.getWareHouse().decreaseResources(stone, wood, food);
		}else {
			stone = sender.getWareHouse().getStone();
			wood = sender.getWareHouse().getWood();
			food = sender.getWareHouse().getFood();
			this.increaseResources(stone, wood, food);
			sender.getWareHouse().decreaseResources(stone, wood, food);
		}
	};


	public int getStone() {
		return select.stoneQuantity(villageID);
	}

	public int getWood() {
		return select.woodQuantity(villageID);
	}

	public int getFood() {
		return select.foodQuantity(villageID);
	}

	public int getLevel(){
		return select.wareHouseLevel(villageID);
	}
};
