package villagewars.game.building;

abstract public class Building{
	private int buildingLevel = 1;

	public int getLevel(){
		return buildingLevel;
	}
	public void increaseLevel(){
		buildingLevel += 1;
	}
};
