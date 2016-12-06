
public class InventoryCommand extends Command {

	Player player;
	
	public InventoryCommand(Player player) {
		super("inventory");
		this.player = player;
	}

	@Override
	public void execute() {
		System.out.println("Your Critters:");
		for (Critter c : player.getCritters()) {
			System.out.println(c.getName() + " Health: " + c.getHealth());
			System.out.println("	Abilities:");
			for (Ability a : c.abilities) {
				System.out.println("	" + a.name + " Power: " + a.power + " Number Left: " + a.numberLeft);
			}
		}
		System.out.println("Your Items:");
		for (Item i : player.getItems()) {
			System.out.println("No items!");
		}
		System.out.println("Your money: " + player.getMoney());
	}
	
}
