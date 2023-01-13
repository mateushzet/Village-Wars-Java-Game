package villagewars.game.player;

import TCP.Insert;
import TCP.Select;
import TCP.Update;
import villagewars.game.village.Village;

import java.sql.Connection;

public class Player{
	private String nickname, password;
	public Village village;
	public int villageID;
	public int playerID;

	public Select select;
	public Insert insert;
	public Update update;

	//---------TODO login system
	public Player(String nickname, String password, Connection database){
	this.nickname = nickname;
	this.password = password;
	playerID = select.playerID(nickname);
	villageID = select.villageID(playerID);
	village = new Village(villageID);

		select = new Select(database);
		insert = new Insert(database);
		update = new Update(database);
	}
	public String getNickname(){
		return nickname;
	}
	public int getPlayerID(){
		return playerID;
	}
	public int getVillageID(){
		return villageID;
	}

};