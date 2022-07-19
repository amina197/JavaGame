/*
 *JEU
 *
 * Personnages: Guerriers / Sorciers / Healers
 * 
 * Commun: nom, prénom, pdv, pt d'action, attaquer()
 * Guerrier -> has A weapon (qui donne un bonus sur attaquer)
 * Sorcier -> has a pouvoir (qui donne une bonus sur l'attaque)
 * Healer -> retrouve x points de vie à chaque attaque
 * Les attaques sont aléatoires (l'un ou l'autre)
 * 
 * Faire un jeu ou deux personnages se rencontrent et se battent
 * Affiche le gagnant et le perdant
 * Afficher à chaque tour les points de vie restant et pt d'action 
 * A chaque attaque on perd des points d'actions / à chaque tour on en récupère en fonction de son arme ou de son pouvoir
 * Le healer ne perd pas de points d'action
 * 
 */

package fr.game;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Fight newGame = new Fight((byte) 2);
		newGame.launchGame();
	}

}
