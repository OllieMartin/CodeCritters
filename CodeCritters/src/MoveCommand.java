
public class MoveCommand extends Command {

	Direction moveDirection;
	Player player;
	
	public MoveCommand(Direction direction, Player player) {
		super("MOVE");
		moveDirection = direction;
		this.player = player;
	}

	@Override
	public void execute() {
		player.move(moveDirection);
		
	}

	
	
	
}
