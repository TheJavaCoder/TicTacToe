/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.tictactoe_server.AccessController;
import com.tictactoe_server.DBController;
import com.tictactoe_server.GameResult;
import com.tictactoe_server.Player;

// Test for generatation of the db file and tables. 
public class DBControllerTest {

    public static void main(String[] args) {

        System.out.println("---------------------- Database Controller Tests ---------------------- \n");

        DBController db = new AccessController();

        db.init();

        db.addPlayer("Test1");

        db.addPlayer("Test2");

        db.updateGameStats(db.getPlayer("Test1"), db.getPlayer("Test2"), true);
        db.updateGameStats(db.getPlayer("Test2"), db.getPlayer("Test1"), false);

        printGameHistory(db.getPlayer("Test1"));
        printGameHistory(db.getPlayer("Test2"));
    }

    public static void printGameHistory(Player p) {

        System.out.println("----------------------- Game History of " + p.name + " ------------------------");

        System.out.println("Matches Played: " + p.gameHistory.size() + " \n\n");

        for (int i = 0; i < p.gameHistory.size(); i++) {

            System.out.println("Match #" + (i + 1));

            GameResult g = p.gameHistory.get(i);

            System.out.println("Opponent: " + g.opponent);
            System.out.print("Who won?: ");
            System.out.println((g.won) ? "You" : "Them");
            System.out.println("Date of match: " + g.date + "\n");
        }

    }
}
