package org.isen.jee.tennis;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.isen.jee.tennis.harness.JettyHarness;
import org.isen.jee.tennis.harness.WebRuntimeException;
import org.junit.Test;

public class TennisServletTest extends JettyHarness {

    /**
     * En implémentant la méthode `doGet()` faire en sorte que la servlet
     * affiche le score de jeu courant pour la requête suivante :
     *
     * GET http://localhost:9090/score
     *
     * @throws Exception
     */
    @Test
    public void initialScoreIsLoveAll() throws Exception {
        assertEquals("0 partout", get(getServletUri()));
    }

    /**
     * En implémentant la méthode `doPost()` faire en sorte que la servlet
     * incrémente le score du joueur paramétré pour la requête suivante :
     *
     * POST http://localhost:9090/score player: 1
     *
     * @throws Exception
     */
    @Test
    public void canScorePlayer1() throws Exception {
        scorePlayer1();
        assertEquals("15-0", get(getServletUri()));
    }

    /**
     * En implémentant la méthode `doPost()` faire en sorte que la servlet
     * incrémente le score du joueur paramétré pour la requête suivante :
     *
     * POST http://localhost:9090/score player: 2
     *
     * @throws Exception
     */
    @Test
    public void canScorePlayer2() throws Exception {
        scorePlayer2();
        assertEquals("0-15", get(getServletUri()));
    }

    /**
     * En implémentant la méthode doDelete() faire en sorte que la servlet
     * remette les scores à 0 pour la requête suivante :
     *
     * DELETE http://localhost:9090/score
     *
     * @throws Exception
     */
    @Test
    public void gameCanBeResetted() throws Exception {
        scorePlayer1();
        assertEquals("15-0", get(getServletUri()));
        resetScore();
        assertEquals("0 partout", get(getServletUri()));
    }

    @Test
    /**
     * Modifier la méthode de score pour faire en sorte de renvoyer
     * une erreur 400 dans le cas où l'on essaye de marquer alors
     * que le jeu est terminé.
     * @throws Exception
     */
    public void aPlayerCantScoreIfGameIsEnded() throws Exception {
        try {
            for (int i = 0; i < 5; i++) {
                scorePlayer1();
            }
            fail("On ne devrait pas pouvoir marquer quand le jeu est terminé");
        } catch (WebRuntimeException e) {
            assertEquals(400, e.getCode());
        }
    }

    /**
     * Envoie la méthode DELETE sur le endpoint de la servlet.
     *
     * @return
     * @throws IOException
     */
    private String resetScore() throws IOException {
        return delete(getServletUri());

    }

    private String getServletUri() {
        return getBaseUri() + "/score";
    }

    /**
     * Envoie la méthode POST sur le endpoint de la servlet pour le joueur 1
     *
     * @return
     * @throws IOException
     */
    private String scorePlayer1() throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("player", "1");
        return post(getServletUri(), params);
    }

    /**
     * Envoie la méthode POST sur le endpoint de la servlet pour le joueur 2
     *
     * @return
     * @throws IOException
     */
    private String scorePlayer2() throws IOException {
        Map<String, String> params = new HashMap<>();
        params.put("player", "2");
        return post(getServletUri(), params);
    }

}
