import java.util.ArrayList;
import java.util.List;

public class Critter {

	Person owner;
	int id;
	CritterSpecies species;
	String name;
	int health;
	int maxHealth;
	List<Ability> abilities;
	
	public Critter(CritterSpecies species, int maxHealth) {
		id = Game.getNextCritterId();
		this.species = species;
		abilities = new ArrayList<Ability>();
		switch (species) {
		case ArrayIndex:
			name = "ArrayIndex";
			abilities.add(new Ability("ARRAYINDEXOUTOFBOUNDS EXCEPTION OCCURED", "**CRASH**", 10,5));
			break;
		case Exception:
			name = "Exception";
			break;
		case IOException:
			name = "IOException";
			abilities.add(new Ability("IOEXCEPTION OCCURED", "**CRASH**", 10,5));
			break;
		case NullPointer:
			name = "NullPointer";
			abilities.add(new Ability("NULL POINTER EXCEPTION OCCURED", "**Silence as it was a null value**", 5,10));
			break;
		case OutOfBounds:
			name = "OutOfBounds";
			abilities.add(new Ability("A RANDOM OUTOFBOUNDS EXCEPTION OCCURED", "**???**", 10,5));
			break;
		default:
			name = "";
			break;
		}
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		owner = null;

	}
	
	public CritterSpecies getSpecies() {
		return species;
	}
	
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
	public Ability getAbility(int index) {
		return abilities.get(index);
	}
	
	public String getName() {
		return name;
	}
	
	public int getHealth() {
		return health;
	}
	
	public void damage(int amount) {
		health = health - amount;
	}
	
}
