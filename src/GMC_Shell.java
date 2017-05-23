/*
 * The GMC (Game Model Controller) Shell is a faux class that only
 * techically implements the methods required of it by other modules,
 * so they can test integration and their own modules without needing 
 * to worry about the real GMC being the source of the bugs.
 * 
 * Written on 5/15/2017 by Alex Dibb. 
 * Updated on 5/22/2017 by Alex Dibb.
 */

import com.google.gson.Gson;

public class GMC_Shell {
    private Gson gson;
    
    public void initGame(String pkg){
        try {
            gson.fromJson(pkg, SetupPackage.class);
        } catch (Exception e) {
            System.err.println("ERR: Bad fromJson() result for : " + pkg);
            System.err.println("     Threw exception: " + e);
        }
    }
    
    public GameState update(String pkg){
        try {
            GameState result = gson.fromJson(pkg, GameState.class);
            System.out.println("OUT: Got GameState " + result);
            return result;
        } catch (Exception e) {
            System.err.println("ERR: Bad fromJson() result for : " + pkg);
            System.err.println("     Threw exception: " + e);
            System.out.println("OUT: Bad JSON, returning new GameState.");
            return new GameState();
        }
    }
}
