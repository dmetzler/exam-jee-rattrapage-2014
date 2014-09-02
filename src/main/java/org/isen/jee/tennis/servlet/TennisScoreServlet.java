package org.isen.jee.tennis.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.isen.jee.tennis.TennisGame;
import org.isen.jee.tennis.TennisGameImpl;

@WebServlet("/score")
public class TennisScoreServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        TennisGame game = getTennisGame(req);
        resp.getWriter().write(game.getScore());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String player = req.getParameter("player");

        TennisGame tennisGame = getTennisGame(req);

        if (tennisGame.isEnded()) {
            resp.sendError(400, "Le jeu est terminé");
        } else {
            if ("1".equals(player)) {
                tennisGame.player1Scores();
            } else if ("2".equals(player)) {
                tennisGame.player2Scores();
            }
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        req.getSession().removeAttribute("game");
    }

    private TennisGame getTennisGame(HttpServletRequest req) {
        TennisGame game = (TennisGame) req.getSession().getAttribute("game");
        if (game == null) {
            game = new TennisGameImpl("Nadal", "Djokovic");
            req.getSession().setAttribute("game", game);
        }
        return game;
    }
}
