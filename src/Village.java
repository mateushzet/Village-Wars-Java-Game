public class Village{
	Rathaus rathaus = new Rathaus();
	
	public void printBuildings(){
		System.out.println("ratusz - "+rathaus.getLevel());
		System.out.println("magazyn - "+rathaus.wareHouse.getLevel());
		System.out.println("koszary - "+rathaus.barracks.getLevel());
		System.out.println("farma - "+rathaus.farm.getLevel());
		}
		
	public void startResourcesProduction(){
	rathaus.farm.startProduction();
	rathaus.mine.startProduction();
	rathaus.timberCamp.startProduction();
	}
	
	public void stopResourcesProduction(){
	rathaus.farm.stopProduction();
	rathaus.mine.stopProduction();
	rathaus.timberCamp.stopProduction();
	}
}