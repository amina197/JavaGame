package fr.game.chars;
import fr.game.weapons.Sword;

public class Warrior extends Character {
	
	public Warrior(String user, String first) {
		super(user, first, 50, 20);
	}
	
	public int attack() {
		Sword bonusSword = new Sword();
		System.out.println("You inflicted 35 damages, plus a bonus of " + bonusSword.getDamage() + " damages from your sword");
		return 35 + bonusSword.getDamage();
	}
	
	public void retrieveActions() {
		Sword bonusSword = new Sword();
		super.set_action(get_action() + bonusSword.getActionsBack());
		System.out.println("Your sword helped you retrieve " + bonusSword.getActionsBack() + " actions back.");
	}
}
