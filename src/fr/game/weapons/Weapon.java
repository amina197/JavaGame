package fr.game.weapons;

public abstract class Weapon {
	private int damage;
	private int actionsBack;
	
	public Weapon(int damage, int actions) {
		this.damage = damage;
		this.actionsBack = actions;
	}

	public int getDamage() {
		return damage;
	}

	public void setDamage(int damage) {
		this.damage = damage;
	}

	public int getActionsBack() {
		return actionsBack;
	}
}
