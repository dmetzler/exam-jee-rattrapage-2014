package org.isen.jee.tennis;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class TennisCounterTest {

    private TennisGame game;

    @Before
    public void doBefore() {
        game = new TennisGameImpl("Nadal", "Djokovic");
    }

    /**
     * On vérifiera ici qu'au démarrage du jeu, le score est de "0 partout".
     *
     * @throws Exception
     */
    @Test
    public void itCanInitiateAGame() throws Exception {
        assertEquals("0 partout", game.getScore());

    }

    /**
     * On vérifiera ici que lorsqu'un joueur marque, son score s'incrémente. On
     * le vérifie pour plusieurs valeurs.
     *
     * @throws Exception
     */
    @Test
    public void aPlayerMayScore() throws Exception {
        play(1, 0);
        assertEquals("15-0", game.getScore());
    }

    /**
     * On vérifiera ici que les deux joueurs peuvent marquer des points et que
     * leurs scores respectifs s'incrémentent correctement.
     *
     * @throws Exception
     */
    @Test
    public void bothPlayerMayScore() throws Exception {
        play(1, 2);
        assertEquals("15-30", game.getScore());
    }

    /**
     * On vérifiera ici qu'un joueur peut gagner.
     *
     * @throws Exception
     */
    @Test
    public void aPlayerMayWinTheGame() throws Exception {
        play(4, 0);
        assertEquals("Nadal gagne le jeu", game.getScore());
    }

    /**
     * On vérifiera ici que si les deux joueurs ont le même nombre de points
     * alors le score affiché est "X partout".
     *
     * @throws Exception
     */
    @Test
    public void playerMayBeAtEquality() throws Exception {
        play(1, 1);
        assertEquals("15 partout", game.getScore());
    }

    /**
     * On vérifiera ici que si les deux joueurs sont à 40 partout alors le score
     * affiché est "Egalité".
     *
     * @throws Exception
     */
    @Test
    public void testDeuceScore() throws Exception {
        play(3, 3);

        assertEquals("Egalité", game.getScore());
    }

    /**
     * On vérifiera ici que le joueur 1 peut prendre l'avantage.
     *
     * @throws Exception
     */
    @Test
    public void player1MayHaveAdvantage() throws Exception {
        play(4, 3);
        assertEquals("Avantage Nadal", game.getScore());
    }

    /**
     * On vérifiera ici que le joueur 2 peut prendre l'avantage.
     *
     * @throws Exception
     */
    @Test
    public void player2MayHaveAdvantage() throws Exception {
        play(3, 4);
        assertEquals("Avantage Djokovic", game.getScore());
    }

    /**
     * On vérifiera que le joueur 1 peut gagner après avoir pris l'avantage.
     *
     * @throws Exception
     */
    @Test
    public void player1WinsAfterAdvantage() throws Exception {
        play(5, 3);
        assertEquals("Nadal gagne le jeu", game.getScore());
    }

    /**
     * On vérifiera que le joueur 2 peut gagner après avoir pris l'avantage.
     *
     * @throws Exception
     */
    @Test
    public void player2WinsAfterAdvantage() throws Exception {
        play(3, 5);
        assertEquals("Djokovic gagne le jeu", game.getScore());
    }

    private void play(int player1Wins, int player2Wins) {
        for (int i = 0; i < Math.max(player1Wins, player2Wins); i++) {

            if (i < player1Wins) {
                game.player1Scores();
            }
            if (i < player2Wins) {
                game.player2Scores();
            }
        }
    }

}
