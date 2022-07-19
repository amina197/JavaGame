package fr.game.chars;
import fr.game.weapons.Spell;

public class Witcher extends Character {
	
	public Witcher(String user, String first) {
		super(user, first, 70, 15);
	}
	
	public int attack() {
		Spell bonusSpell = new Spell();
		System.out.println("You inflicted 30 damages, plus a bonus of " + bonusSpell.getDamage() + " damages from your spell");
		return 30 + bonusSpell.getDamage();
	}
	
	public void retrieveActions() {
		Spell bonusSpell = new Spell();
		super.set_action(get_action() + bonusSpell.getActionsBack());
		System.out.println("Your spell helped you retrieve " + bonusSpell.getActionsBack() + " actions back.");
	}
}
