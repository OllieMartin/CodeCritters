
public class BattlingCPU extends CPU implements Battling {

	Critter critter;
	int reward;
	String challengeMessage;
	String defeatMessage;
	String victoryMessage;
	
	public BattlingCPU(String identifier, Room currentLocation, Critter critter, int reward, String challengeMessage, String defeatMessage, String victoryMessage) {
		super(identifier, currentLocation, null);
		this.critter = critter;
		this.reward = reward;
		this.challengeMessage = challengeMessage;
		this.defeatMessage = defeatMessage;
		this.victoryMessage = victoryMessage;
	}

	@Override
	public Critter getCritter() {
		return this.critter;
	}

	@Override
	public int getReward() {
		return this.reward;
	}

	@Override
	public String getChallengeMessage() {
		return this.challengeMessage;
	}

	@Override
	public String getDefeatMessage() {
		return this.defeatMessage;
	}

	@Override
	public String getVictoryMessage() {
		return this.victoryMessage;
	}
	
	@Override
	public void interact(Player p) {
		if (this.critter.getHealth() > 0) {
			Game.startBattle(p, this);
		} else {
			System.out.println("My critter is too injured to battle...");
		}
	}

}
