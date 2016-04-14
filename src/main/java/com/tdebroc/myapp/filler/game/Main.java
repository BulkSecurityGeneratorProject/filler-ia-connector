package com.tdebroc.myapp.filler.game;


import com.tdebroc.myapp.filler.connector.PlayerConnector;
import com.tdebroc.myapp.filler.game.ia.IA;
import com.tdebroc.myapp.filler.game.ia.ManualIA;
import com.tdebroc.myapp.filler.game.ia.SimpleIA;

public class Main {

    static String baseUrl = "http://62.210.105.118:8081";

    public static void main(String[] args) {

        // ManualIAVsOther();
        onlyIA(44);
    }

    public static void onlyIA(int gameId) {
        System.out.println("Open a new game is " + gameId);
        PlayerConnector playerConnector1 = new PlayerConnector(gameId, baseUrl);
        playerConnector1.registerPlayer("Carl");
        Game game = playerConnector1.getGame();
        IA simpleIA = new SimpleIA();

        do {
            game = playerConnector1.getOpponentMoves();
            char c = simpleIA.getNextMove(game);
            playerConnector1.sendMove(c);

        } while (!game.isFinished());

    }

    public static void ManualIAVsOther() {

        int gameId = PlayerConnector.addGame(baseUrl, 5);
        System.out.println("Open a new game is " + gameId);

        PlayerConnector playerConnector1 = new PlayerConnector(gameId, baseUrl);
        playerConnector1.registerPlayer("Carl");
        Game game;

        ManualIA manualIA = new ManualIA();

        do {
            game = playerConnector1.getOpponentMoves();
            char c = manualIA.getNextMove(game);
            playerConnector1.sendMove(c);

        } while (!game.isFinished());

    }



}