package fr.game.chars;

public class Healer extends Character {
	
	public Healer(String user, String first) {
		super(user, first, 100, 10);
	}
	
	public int attack() {
		set_health((get_health() + 10));
		System.out.print("You inflicted 10 damages");
		System.out.print("\nYou healed yourself: +10 in health\n");
		return 10;
	}
}
