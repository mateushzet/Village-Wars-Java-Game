public class WareHouse extends Building{
	private int stone = 0;
	private int wood = 0;
	private int food = 0;

	public Boolean verifyResourcesAmount(int requiredStone, int requiredWood, int requiredFood){
	if(stone >= requiredStone &&
	wood >= requiredWood &&
	food >= requiredFood) return true;
	else return false;
	}

	public void printResources(){
		System.out.println(stone+" "+wood+" "+food);
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
};
