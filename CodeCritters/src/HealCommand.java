
public class HealCommand extends Command {

	Player player;
	
	public HealCommand(Player player) {
		super("heal");
		this.player = player;
	}

	@Override
	public void execute() {
		if (! (player.getCurrentLocation() instanceof Hospital)) {
			System.out.println("You can't heal in this location, find a hospital!");
			return;
		}
		for (Critter c : player.getCritters()) {
			c.health = c.maxHealth;
			for (Ability a : c.abilities) {
				a.numberLeft = a.number;
			}
		}
		System.out.println("All your critters have been healed!");
		
	}

}
