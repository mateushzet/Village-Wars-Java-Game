abstract public class ProductionBuilding extends Building{
	protected int growth = 10;
	protected int productionDelay = 100;
	protected WareHouse wareHouse;
	
	
	Runnable productIncreasing = () -> {
		while(true){		
			try{
				Thread.sleep(productionDelay);
			}catch(Exception e){
				System.out.println(e);
				}
		increaseProduct();			
		}
	};	
	
	Thread thread = new Thread(productIncreasing);
	public void startProduction(){
	thread.start();
	}

	public void stopProduction(){
	thread.interrupt();
	}
	
	abstract void increaseProduct();
};
