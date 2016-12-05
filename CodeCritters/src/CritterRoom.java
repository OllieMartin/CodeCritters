
public class CritterRoom extends Room implements Explorable {

	CritterSpecies species;
	
	public CritterRoom(String name, String desc, CritterSpecies species) {
		super(name, desc);
		this.species = species;
	}
	
	public CritterRoom(String name, String desc, Permission permission, CritterSpecies species) {
		super(name, desc, permission);
		this.species = species;
	}

	@Override
	public Critter explore() {
		Critter critter = null;
		if (Math.random() > 0.5) {
			critter = new Critter(this.species, 100);
		}
		return critter;
	}

}
