
public class CPU extends Person implements Interactable {

	String interactMessage;
	
	public CPU(String identifier, Room currentLocation, String interactMessage) {
		super(identifier, currentLocation);
		this.interactMessage = interactMessage;
	}

	@Override
	public void interact(Player p) {
		System.out.println(interactMessage.replace("%PLAYER%", p.getIdentifier()));
	}

}