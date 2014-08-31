package org.isen.jee.tennis;

public class TennisGameImpl implements TennisGame {


    private String player1Name;

    private String player2Name;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    /**
     * Retourne le score du match sous forme de chaine de caractère,
     * les type de valeur possibles sont :
     *  * 15-30 : nombre de points différent
     *  * 15 partout : nombre de points égaux,
     *  * Egalité : les deux joueurs ont 40 au moins et on le même nombre de point
     *  * Avantage Joueur
     *
     */
    @Override
    public String getScore() {
        throw new UnsupportedOperationException();
    }

    /**
     * Méthode à appeler lorsque le premier joueur marque un point
     *
     */
    @Override
    public void player1Scores() {
        throw new UnsupportedOperationException();
    }

    /**
     * Méthode à appeler lorsque le deuxième joueur marque un point
     *
     */
    @Override
    public void player2Scores() {
        throw new UnsupportedOperationException();

    }


    /**
     * Retourne vrai si le jeu est terminé, faux sinon
     *
     */
    @Override
    public boolean isEnded() {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getPlayer1Name() {
        return player1Name;
    }

    @Override
    public String getPlayer2Name() {
        return player2Name;
    }


}
