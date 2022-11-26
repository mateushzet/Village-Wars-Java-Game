package villagewars.game.building;

public class Building{
	private int buildingLevel = 1;

	public int getLevel(){
		return buildingLevel;
	}
	public void increaseLevel(){
		buildingLevel += 1;
	}
};
