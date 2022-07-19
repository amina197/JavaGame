package fr.game;

import java.util.Scanner;

import fr.game.chars.Character;
import fr.game.chars.Warrior;
import fr.game.chars.Witcher;
import fr.game.chars.Healer;


public class Fight {
	private Character[] fighters = new Character[2];
	private byte nbFighters;
	private Scanner scanner;
	private Character activeFighter;
	private Character attackedFighter;
	private boolean isPlaying;
	
	public Fight(byte nbPlayers) {
		this.scanner = new Scanner(System.in);
		setNbFighters(nbPlayers);
		this.isPlaying = true;
	}
	
	private void initializeChars() {
		
		for (byte i = 0; i < getNbFighters(); i++) {
			System.out.print("\nFighter " + (i + 1) + ":\n1. Warrior \n2. Witcher \n3. Healer \n\nYour choice: ");
			byte choice = this.scanner.nextByte();
			
			System.out.print("Username: ");
			String user = this.scanner.next();
			
			System.out.print("First name: ");
			String firstName = this.scanner.next();
			
			switch(choice) {
			case 1:
				fighters[i] = new Warrior(user, firstName);
				break;
			case 2:
				fighters[i] = new Witcher(user, firstName);
				break;
			case 3:
				fighters[i] = new Healer(user, firstName);
				break;
			default:
				System.out.print("Invalid choice. Please try again");
			}
			
		}
	}
	
	public void launchGame() {
		System.out.print("Welcome to FIGHTERS 1vs1!\n");
		
		while(isPlaying) {
			initializeChars();
			System.out.print("\n\n\n-------------\n" + fighters[0].get_username() + " vs " + fighters[1].get_username() + "\n-------------\n");
			launchRound();
			endGame();
		}
	}
	
	private void launchRound() {
		int countRounds = 1;
		while(fighters[0].get_health() > 0 && fighters[1].get_health() > 0) {
			long randomIndex = Math.round(Math.random());
			
			if (randomIndex == 1) {
				setAttackedFighter(fighters[0]);
			} else {
				setAttackedFighter(fighters[1]);
			}

			setActiveFighter(fighters[(int) randomIndex]);
			System.out.print("\n\n\nROUND " + countRounds + " --> " + (getActiveFighter().get_username() + " you fight\n").toUpperCase());
			countDamages();
			countActions();
			sumUpHealth();
			++countRounds;
		}
	}
	
	private void countDamages() {
		int healthAfterDamages = getAttackedFighter().get_health() - getActiveFighter().attack();
		getAttackedFighter().set_health(healthAfterDamages);
	}
	
	private void countActions() {
		if(getActiveFighter().get_action() > 0) {
			if (!(getActiveFighter() instanceof Healer)) {
				long lostActions = Math.round(Math.random() * 8);
				int actionPts = getActiveFighter().get_action();
				int actionsDiff = actionPts - (int) lostActions;
				
				getActiveFighter().set_action(actionsDiff);
				
				System.out.println("You lost " + lostActions + " actions");
				
				if (actionPts < 0) {
					getActiveFighter().set_action(0);
				}
			}
		} else {
			System.out.print("You don't have any remaining action. You can't attack during this round.");
		}
		
		if (getActiveFighter() instanceof Warrior) {
			((Warrior)getActiveFighter()).retrieveActions();
		} 
		
		if (getActiveFighter() instanceof Witcher) {
			((Witcher)getActiveFighter()).retrieveActions();
		}
	}
	
	private void sumUpHealth() {
		int healthActive = getActiveFighter().get_health();
		int healthAttacked = getAttackedFighter().get_health();
		
		int actionsActive = getActiveFighter().get_action();
		int actionsAttacked = getAttackedFighter().get_action();
		
		System.out.println("\n---------" + getActiveFighter().get_username() + "---------\n- Remaining Health: " + healthActive + "\n- Remaining Actions: " + actionsActive);
		System.out.println("\n---------" + getAttackedFighter().get_username() + "---------\n- Remaining Health: " + healthAttacked + "\n- Remaining Actions: " + actionsAttacked);
	}
	
	private void endGame() {
		System.out.println("\n" +getActiveFighter().get_username() + " you won the game! Congrats!".toUpperCase());
		System.out.println("\n\nPlay again? (Y/N)");
		
		String wantToPlay = this.scanner.next();
		
		if ((wantToPlay.toLowerCase()).equals("n")) {
			setIsPlaying(false);
			this.scanner.close();
			System.out.print("See you soon :)");
		}
	}
	
	public Character getActiveFighter() {
		return this.activeFighter;
	}
	public void setActiveFighter(Character fighter) {
		this.activeFighter = fighter;
	}
	
	public Character getAttackedFighter() {
		return this.attackedFighter;
	}
	public void setAttackedFighter(Character fighter) {
		this.attackedFighter = fighter;
	}

	public byte getNbFighters() {
		return nbFighters;
	}

	public void setNbFighters(byte nbFighters) {
		this.nbFighters = nbFighters;
	}
	
	public boolean getIsPlaying() {
		return isPlaying;
	}

	public void setIsPlaying(boolean wantToPlay) {
		this.isPlaying = wantToPlay;
	}
	

}
