
public class InteractCommand extends Command {

	CPU cpu;
	Player p;
	
	public InteractCommand(CPU cpu, Player p) {
		super("interact");
		this.cpu = cpu;
		this.p = p;
	}

	@Override
	public void execute() {
		cpu.interact(p);
	}

}
