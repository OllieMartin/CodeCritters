
public class ExploreCommand extends Command {

	Player player;
	
	public ExploreCommand(Player player) {
		super("explore");
		this.player = player;
	}

	@Override
	public void execute() {
		if (player.getCurrentLocation() instanceof Explorable) {
			Critter critter;
			Explorable room = (Explorable) player.getCurrentLocation();
			critter = room.explore();
			if (critter != null) {
				System.out.println("YOU FOUND A " + critter.getSpecies().toString());
				player.addCritter(critter);
				System.out.println("The critter has been added to your inventory!");
			} else {
				System.out.println("Nothing was found...");
			}
		} else {
			System.err.println("You cant explore this room!");
		}
	}

}
