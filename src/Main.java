import java.util.Scanner;
public class Main {
	
	static Player a = new Player("MyNickname", "MyPassword");
	
	public static void main(String[] args) {
		a.village.startResourcesProduction();
		printVillage(a);
		a.village.stopResourcesProduction();
	}
	
	static public void printVillage(Player player){
		int choose;
		Scanner sc = new Scanner(System.in);
	
		while(true){
		
			System.out.println(player.getNickname() + "'s Village ");
			
			System.out.println();
			System.out.println("Type:");
			System.out.print("1) - show resources\t");
			System.out.print("2) - show building levels\t");
			System.out.print("3) - show army\t");
			System.out.println("4) - recruit pikeman");
			System.out.print("5) - recruit swordseman\t");
			System.out.print("6) - recruit axeman\t");
			System.out.print("7) - upgrade rathaus\t");
		
			choose = sc.nextInt();
			if(choose == 1){
				player.village.rathaus.wareHouse.printResources(); 
			}
			if(choose == 2){
				player.village.printBuildings();
			}
			if(choose == 3){
			player.village.rathaus.barracks.printArmy();
			}
			if(choose == 4){
				player.village.rathaus.barracks.recruitPikeman();
			}
			if(choose == 5){
				player.village.rathaus.barracks.recruitSwordsman();
			}
			if(choose == 6){
				player.village.rathaus.barracks.recruitAxeman();
			}
			if(choose == 7){
				player.village.rathaus.levelUp(player.village.rathaus);
			}

			System.out.println();
		}
	}
}