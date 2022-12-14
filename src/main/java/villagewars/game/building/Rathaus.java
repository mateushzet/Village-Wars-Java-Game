package villagewars.game.building;

public class Rathaus extends Building {
//	WareHouse wareHouse = new WareHouse();
//	Barracks barracks = new Barracks(wareHouse);
//
//	Farm farm = new Farm(wareHouse);
//	Mine mine = new Mine(wareHouse);
//	TimberCamp timberCamp = new TimberCamp(wareHouse);
//
//	public void levelUp(Building building){
//		if(wareHouse.verifyResourcesAmount(10,10,10))
//		building.increaseLevel();
//	}

	private  WareHouse wareHouse;

	private  Barracks barracks;

	private Farm farm;
	private Mine mine;
	private TimberCamp timberCamp;
	public Rathaus() {
		wareHouse = new WareHouse();
		barracks = new Barracks(wareHouse);
		farm = new Farm(wareHouse);
		mine = new Mine(wareHouse);
		timberCamp = new TimberCamp(wareHouse);
	}
		public void levelUp(Building building){
		if(wareHouse.verifyResourcesAmount(100*getLevel(),100*getLevel(),100*getLevel())) {
			building.increaseLevel();
			wareHouse.decreaseResources(100*getLevel(), 100*getLevel(), 100*getLevel());
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
};