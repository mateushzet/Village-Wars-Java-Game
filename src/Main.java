import java.util.Scanner;
public class Main {
	
	static Player a = new Player("MyNickname", "MyPassword");
	
	public static void main(String[] args) {
		a.village.startResourcesProduction();
		printVillage(a);
	//	a.village.stopResourcesProduction();
	}
	
	static public void printVillage(Player player){
		int choose;
		Scanner sc = new Scanner(System.in);
	
		while(true){
			System.out.println(player.getNickname() + "'s Village ");
			player.village.printBuildings();
			System.out.println();
			System.out.println("Type:");
			System.out.println("1) - show resources");
			choose = sc.nextInt();
			if(choose == 1){
				player.village.rathaus.wareHouse.printResources(); 
			}
			System.out.println();
		}
	}
}