import java.util.List;
import java.util.ArrayList;

public class Person {

	private String identifier;
	private Room currentLocation;
	private List<Item> items;
	private List<Critter> critters;
	private List<Permission> permissions;
	
	public Person(String identifier, Room currentLocation) {
		this.identifier = identifier;
		this.currentLocation = currentLocation;
		this.items = new ArrayList<Item>();
		this.critters = new ArrayList<Critter>();
		this.permissions = new ArrayList<Permission>();
		
	}

	public String getIdentifier() {
		return identifier;
	}

	public Room getCurrentLocation() {
		return currentLocation;
	}

	public List<Item> getItems() {
		return items;
	}

	public List<Critter> getCritters() {
		return critters;
	}

	public List<Permission> getPermissions() {
		return permissions;
	}
	
	public void addItem(Item item) {
		items.add(item);
	}
	
	public void addCritter(Critter critter) {
		critters.add(critter);
		critter.setOwner(this);
	}
	
	public void addPermission(Permission permission) {
		permissions.add(permission);
	}
	
	public void removeItem(Item item) {
		items.remove(item);
	}
	
	public void removeCritter(Critter critter) {
		critters.remove(critter);
	}
	
	public void removePermission(Permission permission) {
		permissions.remove(permission);
	}
	
	public void move(Direction direction) {
		Room room;
		if (direction != null) {
			room = this.currentLocation.getConnection(direction);
			if (room != null) {
				
				this.currentLocation = room;
			}
		}
	}
}
