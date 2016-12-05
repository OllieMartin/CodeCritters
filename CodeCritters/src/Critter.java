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
		switch (species) {
		case ArrayIndex:
			name = "ArrayIndex";
			break;
		case Exception:
			name = "Exception";
			break;
		case IOException:
			name = "IOException";
			break;
		case NullPointer:
			name = "NullPointer";
			break;
		case OutOfBounds:
			name = "OutOfBounds";
			break;
		default:
			name = "";
			break;
		
		}
		this.maxHealth = maxHealth;
		this.health = maxHealth;
		owner = null;
		// ADD ABILITIES FOR EACH SPECIES
		switch (this.species){
		case ArrayIndex:
			break;
		case Exception:
			break;
		case IOException:
			break;
		case NullPointer:
			break;
		case OutOfBounds:
			break;
		default:
			break;
		
		}
	}
	
	public CritterSpecies getSpecies() {
		return species;
	}
	
	public void setOwner(Person owner) {
		this.owner = owner;
	}
	
}
