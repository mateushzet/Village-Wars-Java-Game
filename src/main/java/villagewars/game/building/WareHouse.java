package villagewars.game.building;

public class WareHouse extends Building {
	private int stone = 10000;
	private int wood = 10000;
	private int food = 10000;

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

	public int getStone() {
		return stone;
	}

	public int getWood() {
		return wood;
	}

	public int getFood() {
		return food;
	}
};
