package fr.game.chars;

public abstract class Character {
	private String _username;
	private String _firstName;
	private int _health;
	private int _action;
	
	public Character(String user, String first, int health, int action) {
		this._username = user;
		this._firstName = first;
		this._action = action;
		this._health = health;
	}
	
	public abstract int attack();
	
	
	public String get_username() {
		return _username;
	}
	public void set_username(String _username) {
		this._username = _username;
	}
	
	
	public String get_firstName() {
		return _firstName;
	}
	public void set_firstName(String _firstName) {
		this._firstName = _firstName;
	}
	
	
	public int get_health() {
		return _health;
	}
	public void set_health(int _health) {
		this._health = _health;
	}
	
	
	public int get_action() {
		return _action;
	}
	public void set_action(int _action) {
		this._action = _action;
	}
	

}
