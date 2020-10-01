/*

Output of the test

---------------------- Database Controller Tests ---------------------- 

Loaded Access Driver!
Access Database connected!
Created Table: [users]
Created Table: [games]
Added user: Test1
Added user: Test2
----------------------- Game History of Test1 ------------------------
Matches Played: 1 


Match #1
Opponent: Test2
Who won?: You
Date of match: Wed Sep 30 00:00:00 EDT 2020

----------------------- Game History of Test2 ------------------------
Matches Played: 1 


Match #1
Opponent: Test1
Who won?: Them
Date of match: Wed Sep 30 00:00:00 EDT 2020


 */
package tests;

import com.tictactoe_server.Database.Providers.AccessController;
import com.tictactoe_server.Database.DBController;
import com.tictactoe_server.Database.GameResult;
import com.tictactoe_server.game.Player;

// Test for generatation of the db file and tables. 
public class DBControllerTest {

    public static void main(String[] args) {

        System.out.println("---------------------- Database Controller Tests ---------------------- \n");

        DBController db = new AccessController();

        db.init();

        db.addPlayer("Test1'");

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
