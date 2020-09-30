/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tests;

import com.tictactoe_server.AccessController;
import com.tictactoe_server.DBController;

/**
 *
 * @author bapco
 */
public class DBControllerTest {

    public static void main(String[] args) {
    
        DBController db = new AccessController();
        
        db.init();
        
    }
    
}
