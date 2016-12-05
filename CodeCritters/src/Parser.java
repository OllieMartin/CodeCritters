
public class Parser {

	public Command generateCommand(String command, Player player) {
		Command returnCommand = null;
		String[] commandParts = command.split(" ");
		
		switch (commandParts.length) {
		case 1:
			if (command.equalsIgnoreCase("north")) {
				returnCommand = new MoveCommand(Direction.North, player);
			} else if (command.equalsIgnoreCase("south")) {
				returnCommand = new MoveCommand(Direction.South, player);
			} else if (command.equalsIgnoreCase("east")) {
				returnCommand = new MoveCommand(Direction.East, player);
			} else if (command.equalsIgnoreCase("west")) {
				returnCommand = new MoveCommand(Direction.West, player);
			} else if (command.equalsIgnoreCase("explore")){
				returnCommand = new ExploreCommand(player);
			}
		}
		return returnCommand;
	}
	
}
