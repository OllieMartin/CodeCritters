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
		
		BattlingCPU cpu = new BattlingCPU("John", currentRoom, new Critter(CritterSpecies.OutOfBounds, 50), 100, "I CHALLENGE YOU MORTAL!", "Oh dear...", "MWHAHAHA I WIN AGAIN");
		currentRoom.people.add(cpu);
		
		Player user = new Player("user");
		user.addCritter(new Critter(CritterSpecies.OutOfBounds, 50));
		
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
	
	public static void startBattle(Player player, BattlingCPU cpu) {
		
		Scanner scan = new Scanner(System.in);
		List<Critter> aliveCritters = new ArrayList<Critter>();
		int index = -1;
		int input;
		Critter battler;
		
		System.out.println("You were challenged by " + cpu.getIdentifier());
		System.out.println(cpu.getIdentifier() + ": " + cpu.getChallengeMessage());
		System.out.println(cpu.getIdentifier() + " sent out " + cpu.getCritter().getName() + "!");
		
		System.out.println("What critter will you use?");
		
		for (Critter c : player.getCritters()) {
			if (c.getHealth() > 0) {
				index++;
				aliveCritters.add(c);
				System.out.println(index + ". " + c.getName());
			}
		}
		
		input = scan.nextInt();
		//TODO add validation
		
		battler = aliveCritters.get(input);
		Ability chosen;
		
		//TODO fix encapsulation
		while (battler.health > 0 && cpu.getCritter().health > 0) {
			
			System.out.println("Your critter's health: " + battler.health);
			System.out.println("Opponent critter's health: " + cpu.getCritter().health);
			System.out.println();
			
			System.out.println("What ability will you use?");
			index = -1;
			for (Ability a : battler.abilities) {
				index++;
				System.out.println(index + ". " + a.name + "(" + a.power + ")");
			}
			
			input = scan.nextInt();
			//TODO add validation
			chosen = battler.abilities.get(input);
			
			cpu.getCritter().damage(chosen.power);
			if (cpu.getCritter().health <= 0) {
				System.out.println("YOU WON");
				System.out.println(cpu.getIdentifier() + ": " + cpu.getDefeatMessage());
				player.reward(cpu.getReward());
				System.out.println("You were rewarded with coins: " + cpu.getReward());
			} else {
				
				battler.damage(cpu.critter.getAbility(0).power);
				if (battler.health <= 0) {
					System.out.println("YOU LOST");
					System.out.println(cpu.getIdentifier() + ": " + cpu.getVictoryMessage());
				}
				
			}
			
		}
		
	}
	
}