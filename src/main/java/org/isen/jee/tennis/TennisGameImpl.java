package org.isen.jee.tennis;

public class TennisGameImpl implements TennisGame {

    private String player1Name;

    private int player1Score = 0, player2Score = 0;

    private String player2Name;

    public TennisGameImpl(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    /**
     * Retourne le score du match sous forme de chaine de caractère, les type de
     * valeur possibles sont : * 15-30 : nombre de points différent * 15 partout
     * : nombre de points égaux, * Egalité : les deux joueurs ont 40 au moins et
     * on le même nombre de point * Avantage Joueur
     *
     */
    @Override
    public String getScore() {
        if (isEnded()) {
            return String
                    .format("%s gagne le jeu", getPlayerWithHighestScore());
        }

        if (hasAdvantage()) {
            return String.format("Avantage %s", getPlayerWithHighestScore());
        }

        if (isDeuce()) {
            return "Egalité";
        }
        if (isEquality()) {
            return String.format("%s partout", translateScore(player1Score));
        }
        return String.format("%s-%s", translateScore(player1Score),
                translateScore(player2Score));

    }

    private boolean hasAdvantage() {
        return (player1Score >= 4 && player1Score == player2Score + 1)
                || (player2Score >= 4 && player2Score == player1Score + 1);
    }

    private boolean isDeuce() {
        return player1Score == 3 && player2Score == 3;
    }

    private String getPlayerWithHighestScore() {
        return player1Score > player2Score ? getPlayer1Name()
                : getPlayer2Name();
    }

    private boolean isEquality() {
        return player1Score == player2Score;
    }

    private String translateScore(int score) {
        switch (score) {
        case 1:
            return "15";
        case 2:
            return "30";
        case 3:
            return "40";

        default:
            return "0";
        }
    }

    /**
     * Méthode à appeler lorsque le premier joueur marque un point
     *
     */
    @Override
    public void player1Scores() {
        player1Score++;
    }

    /**
     * Méthode à appeler lorsque le deuxième joueur marque un point
     *
     */
    @Override
    public void player2Scores() {
        player2Score++;

    }

    /**
     * Retourne vrai si le jeu est terminé, faux sinon
     *
     */
    @Override
    public boolean isEnded() {
        return (player1Score >= 4 && player1Score > player2Score + 1)
                || (player2Score >= 4 && player2Score > player1Score + 1);
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
