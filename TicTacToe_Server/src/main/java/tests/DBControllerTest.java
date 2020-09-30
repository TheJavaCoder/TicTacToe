/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.tictactoe_server.AccessController;
import com.tictactoe_server.DBController;

// Test for generatation of the db file and tables. 
public class DBControllerTest {

    public static void main(String[] args) {

        System.out.println("---------------------- Database Controller Tests ---------------------- \n");

        DBController db = new AccessController();

        db.init();

        db.addPlayer("Test1");

        db.addPlayer("Test2");
        
        db.updateGameStats( db.getPlayer("Test1"), db.getPlayer("Test2"), true);
        
        System.out.println(" Games Found: " + db.getPlayer("Test1").gameHistory.size());
    }

}
