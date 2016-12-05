import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

	private static List<Room> rooms;
	private static Room startLocation;
	
	private static int lastRoomId = 0;
	private static int lastCritterId = 0;
	
	public static void main(String args[]) {
		
		Room lastRoom;
		Room currentRoom;
		
		rooms = new ArrayList<Room>();
		startLocation = new Room("Home", "Your house");
		rooms.add(startLocation);
		
		currentRoom = new Room("Garden", "The garden is very overgrown and you are surrounded by plants and long grass");
		currentRoom.addConnection(Direction.South, startLocation);
		rooms.add(currentRoom);
		
		lastRoom = currentRoom;
		
		currentRoom = new Room("Village", "The village is bustling with people and you are surrounded by shops");
		currentRoom.addConnection(Direction.North, startLocation);
		rooms.add(currentRoom);
		
		lastRoom = currentRoom;
		
		currentRoom = new CritterRoom("Forest", "The mysterious forest is dark and dew glistens on the leaves", CritterSpecies.IOException);
		currentRoom.addConnection(Direction.East, lastRoom);
		rooms.add(currentRoom);
		
		lastRoom = currentRoom;
		
		Player user = new Player("user");
		
		Scanner scan = new Scanner(System.in);
		Parser p = new Parser();
		Command currentCommand;
		
		while (true) {
			System.out.println(user.getCurrentLocation().getName());
			System.out.println(user.getCurrentLocation().getDesc());
			System.out.println("Enter command:");
			currentCommand = p.generateCommand(scan.nextLine(),user);
			if (currentCommand != null) {
				currentCommand.execute();
			} else {
				System.err.println("Invalid command!");
			}
		}
		
		//scan.close();
		
	}
	
	public static Room getStartLocation() {
		return startLocation;
	}
	
	public static int getNextRoomId() {
		lastRoomId++;
		return lastRoomId;
	}
	
	public static int getNextCritterId() {
		lastCritterId++;
		return lastCritterId;
	}
	
}