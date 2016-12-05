
public class MoneyCommand extends Command {

	Player player;
	
	public MoneyCommand(Player player) {
		super("money");
		this.player = player;
	}

	@Override
	public void execute() {
		System.out.println("Your coins: " + player.getMoney());
		
	}

}
