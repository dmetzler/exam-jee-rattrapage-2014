package org.isen.jee.tennis;

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

    }

    /**
     * On vérifiera ici que lorsqu'un joueur marque, son score s'incrémente. On
     * le vérifie pour plusieurs valeurs.
     *
     * @throws Exception
     */
    @Test
    public void aPlayerMayScore() throws Exception {

    }

    /**
     * On vérifiera ici que les deux joueurs peuvent marquer des points et que
     * leurs scores respectifs s'incrémentent correctement.
     *
     * @throws Exception
     */
    @Test
    public void bothPlayerMayScore() throws Exception {

    }

    /**
     * On vérifiera ici qu'un joueur peut gagner.
     *
     * @throws Exception
     */
    @Test
    public void aPlayerMayWinTheGame() throws Exception {

    }

    /**
     * On vérifiera ici que si les deux joueurs ont le même nombre de points
     * alors le score affiché est "X partout".
     *
     * @throws Exception
     */
    @Test
    public void playerMayBeAtEquality() throws Exception {

    }

    /**
     * On vérifiera ici que si les deux joueurs sont à 40 partout alors le score
     * affiché est "Egalité".
     *
     * @throws Exception
     */
    @Test
    public void testDeuceScore() throws Exception {
    }

    /**
     * On vérifiera ici que le joueur 1 peut prendre l'avantage.
     *
     * @throws Exception
     */
    @Test
    public void player1MayHaveAdvantage() throws Exception {
    }

    /**
     * On vérifiera ici que le joueur 2 peut prendre l'avantage.
     *
     * @throws Exception
     */
    @Test
    public void player2MayHaveAdvantage() throws Exception {
    }

    /**
     * On vérifiera que le joueur 1 peut gagner après avoir pris l'avantage.
     *
     * @throws Exception
     */
    @Test
    public void player1WinsAfterAdvantage() throws Exception {

    }

    /**
     * On vérifiera que le joueur 2 peut gagner après avoir pris l'avantage.
     *
     * @throws Exception
     */
    @Test
    public void player2WinsAfterAdvantage() throws Exception {
    }

}
