package villagewars.game.player;

import villagewars.game.village.Village;

public class Player{
	private String nickname, password;
	public Village village = new Village();
	public Player(String nickname, String password){
	this.nickname = nickname;
	this.password = password;
	}
	public String getNickname(){
		return nickname;
	}
};