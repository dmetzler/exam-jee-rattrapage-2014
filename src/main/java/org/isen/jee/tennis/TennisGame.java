package org.isen.jee.tennis;

public interface TennisGame {

    /**
     * Retourne le score du match sous forme de chaine de caractère,
     * les type de valeur possibles sont :
     *  * 15-30 : nombre de points différent
     *  * 15 partout : nombre de points égaux,
     *  * Egalité : les deux joueurs ont 40 au moins et on le même nombre de point
     *  * Avantage Joueur
     *
     */
    String getScore();

    /**
     * Méthode à appeler lorsque le premier joueur marque un point
     *
     */
    void player1Scores();

    /**
     * Méthode à appeler lorsque le deuxième joueur marque un point
     *
     */
    void player2Scores();

    /**
     * Retourne vrai si le jeu est terminé, faux sinon
     *
     */
    boolean isEnded();

    /**
     * Retourne le nom du premier joueur
     *
     */
    String getPlayer1Name();

    /**
     * Retourne le nom du deuxième joueur
     *
     */
    String getPlayer2Name();

}
