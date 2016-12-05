
public class Player extends Person {

	int money;
	
	public Player(String userName) {
		super(userName, Game.getStartLocation());
	}
	
	public void reward(int amount) {
		money = money + amount;
	}
	
	public int getMoney() {
		return money;
	}

}
