package villagewars.game.building;

import TCP.Select;
import villagewars.game.village.Village;

public class WareHouse{
	private int stone = 0;
	private int wood = 0;
	private int food = 0;
	public int villageID;

	public WareHouse(int villageID) {
		this.villageID = villageID;
	}

	public Boolean verifyResourcesAmount(int requiredStone, int requiredWood, int requiredFood){
	if(stone >= requiredStone &&
	wood >= requiredWood &&
	food >= requiredFood) return true;
	else return false;
	}

	public void printResources(){
		System.out.println("Stone: "+stone+" Wood: "+wood+"  Food: "+food);
		}

	public void increaseStone(int quantity){
		stone += quantity;	
	}

	public void increaseWood(int quantity){
		wood += quantity;	
	}

	public void increaseFood(int quantity){
		food += quantity;	
	}

	public void decreaseResources(int stone, int wood, int food){
		this.stone -= stone;
		this. wood -= wood;
		this.food -= food;
	}

	public void increaseResources(int stone, int wood, int food){
		this.stone += stone;
		this. wood += wood;
		this.food += food;
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
		return stone;
	}

	public int getWood() {
		return wood;
	}

	public int getFood() {
		return food;
	}

	public int getLevel(){
		return Select.wareHouseLevel(villageID);
	}
};
