/*
 * The GMC (Game Model Controller) Shell is a faux class that only
 * techically implements the methods required of it by other modules,
 * so they can test integration and their own modules without needing 
 * to worry about the real GMC being the source of the bugs.
 * 
 * Written on 5/15/2017 by Alex Dibb. 
 * Updated on 5/25/2017 by Alex Dibb.
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
    
    public String update(String pkg){
        try {
            gson.fromJson(pkg, GameState.class);
            System.out.println("OUT: Got GameState " + pkg);
        } catch (Exception e) {
            System.err.println("ERR: Bad fromJson() result for : " + pkg);
            System.err.println("     Threw exception: " + e);
        }
        return pkg;
    }
}
