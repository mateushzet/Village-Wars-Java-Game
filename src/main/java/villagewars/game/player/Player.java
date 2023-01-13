package villagewars.game.player;

import villagewars.game.village.Village;

public class Player{
	private String nickname, password;
	public Village village;
	public int villageID;

	//---------TODO login system
	public Player(String nickname, String password){
	this.nickname = nickname;
	this.password = password;
	villageID = 2;
	village = new Village(villageID);
	}
	public String getNickname(){
		return nickname;
	}
};