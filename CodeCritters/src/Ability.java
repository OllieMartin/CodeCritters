
public class Ability {

	public String name;
	public int power;
	public int number;
	public String sound;
	public int numberLeft;
	
	public Ability(String name, String sound, int power, int number) {
		this.name = name;
		this.power = power;
		this.sound = sound;
		this.number = number;
		this.numberLeft = number;
	}
	
	public int use() {
		if (numberLeft > 0) {
			numberLeft--;
			return power;
		} else {
			return -1;
		}
	}
	
}
