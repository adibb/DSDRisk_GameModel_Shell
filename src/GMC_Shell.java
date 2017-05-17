/*
 * The GMC (Game Model Controller) Shell is a faux class that only
 * techically implements the methods required of it by other modules,
 * so they can test integration and their own modules without needing 
 * to worry about the real GMC being the source of the bugs.
 * 
 * Written on 5/15/2017 by Alex Dibb. 
 */

// You will need Google's Json package (Gson) to make this work.
import com.google.gson.Gson;

public class GMC_Shell {
    private Gson gson;
    
    // (Board)
    // (GameMap, Rule[], Player[])
    // (GameMap, Player[])
    // (JSON String)
    public void initGame(Object... args){
        if (args.length == 0) {
            System.out.println("ERROR: initGame() needs arguments.");
            return;
        }
        
        if (args[0] instanceof Board) {
            System.out.println("SUCCESS: initGame() initializing GMC with Board object.");
        } else if (args[0] instanceof GameMap) {
            if (args.length == 2 && args[1] instanceof Player[]) {
                System.out.println("SUCCESS: initGame() initializing GMC with GameMap and Rule[].");
            } else if (args.length == 3 && args[1] instanceof Rule[] && args[2] instanceof Player[]) {
                System.out.println("SUCCESS: initGame() initializing GMC with GameMap, Rule[], and Player[].");
            }
        } else if (args[0] instanceof String) {
            try {
                gson.fromJson((String) args[0], SetupPackage.class);
            } catch (Exception e) {
                System.out.println("ERROR: Bad fromJson() result: " + e);
            }
        } else {
            System.out.println("ERROR: initGame() did not receive valid initialization values.");
        }
    }
    
    public GameState update(GameState gs){
        System.out.println("SUCCESS: update() called with GameState " + gs.toString());
        return gs;
    }
}
