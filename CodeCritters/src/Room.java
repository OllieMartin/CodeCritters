import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {

	private int id;
	private String name;
	private String desc;
	private Map<Direction, Room> connections;
	public List<Person> people;
	private List<Item> items;
	private Permission permission;
	
	public Room(String name, String desc) {
		this(name,desc,null);
	}
	
	public Room(String name, String desc, Permission permission) {
		this.name = name;
		this.desc = desc;
		this.id = Game.getNextRoomId();
		this.connections = new HashMap<Direction,Room>();
		this.people = new ArrayList<Person>();
		this.items = new ArrayList<Item>();
		this.permission = permission;
	}
	
	public void addConnection(Direction direction, Room room) {
		connections.put(direction,room);
		room.addOneWayConnection(Room.getOppositeDirection(direction), this);
	}
	
	public void addOneWayConnection(Direction direction, Room room) {
		connections.put(direction,room);
	}
	
	public static Direction getOppositeDirection(Direction direction) {
		switch (direction) {
		case Down:
			return Direction.Up;
		case East:
			return Direction.West;
		case North:
			return Direction.South;
		case South:
			return Direction.North;
		case Up:
			return Direction.Down;
		case West:
			return Direction.East;
		default:
			return null;
		}
	}
	
	public Room getConnection(Direction direction) {
		if (direction != null) {
			return connections.get(direction);
		}
		return null;
	}
	
	public String getName() {
		return this.name;
	}
	
	public String getDesc() {
		return this.desc;
	}
	
}
