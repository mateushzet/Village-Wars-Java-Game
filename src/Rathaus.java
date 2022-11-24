public class Rathaus extends Building {
	WareHouse wareHouse = new WareHouse();
	Barracks barracks = new Barracks();
	
	Farm farm = new Farm(wareHouse);
	Mine mine = new Mine(wareHouse);
	TimberCamp timberCamp = new TimberCamp(wareHouse);
	
	public void levelUp(Building building){
		if(wareHouse.verifyResourcesAmount(10,10,10))
		building.increaseLevel();
	}
};