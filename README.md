# DSDRisk_GameModel_Shell #
This code provides a shell class for the DSDRisk program. Written for CIS 423. Serves as a faux interface with 
the GameModel module, so that others can test their integrations without needing or dealing with potential bugs 
in other modules.

### Usage ###
The code provides a zero-functionality copy of the Game Model Controller (henceforth referred to as the GMC) 
that can be used to test for compatibility issues with client modules. Methods intended to be called by other 
modules return technically valid but useless results. These methods are:

* _initGame(String pkg)_, which accepts a JSON SetupPackage as described by the documentation on Assembla to 
set up the game's starting conditions and persistent values. The shell will only check to see if it can parse 
the provided package correctly. We expect GameSetup to call this before passing the GMC off to the GameManager.
* _update(String pkg)_, which accepts a JSON GameState as described by the documentation on Assembla. The real 
GMC will use this to start the player's turn or update the map to account for another's. The shell will simply 
pass the given GameState back. We expect GameManager to call this whenever it needs to pass off new information 
about the game to the client or trigger a turn.

The shell relies on Google's JSON package (Gson), which is included in the library folder /lib/. The source 
folder /src/ contains further dummy classes that mimic how the GameModel breaks down the incoming JSON and what 
it expects of a GameState. **Replace them as necessary to prevent naming clashes, but be careful not to modify 
their variable signature.** If there is a disconnect between the interface documentation and the provided 
classes, please inform us on Slack so it can be corrected. 