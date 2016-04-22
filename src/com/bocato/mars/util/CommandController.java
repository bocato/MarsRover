package com.bocato.mars.util;

import java.util.HashMap;

import com.bocato.mars.commands.Move;
import com.bocato.mars.commands.RotateLeft;
import com.bocato.mars.commands.RotateRight;
import com.bocato.mars.model.Command;
import com.bocato.mars.model.Rover;
import com.bocato.mars.model.Command.*;

public class CommandController {

	private static CommandController instance =  null;
	private static  HashMap<String, Command> possibleCommands;
	
	private CommandController(){}
	
	private static void generatePossibleCommands(){
		possibleCommands = new HashMap<String, Command>();
		possibleCommands.put("L", new RotateLeft());
		possibleCommands.put("R", new RotateRight());
		possibleCommands.put("M", new Move());
	}
	
	public static CommandController getInstance(){
		if(instance ==  null){
			generatePossibleCommands();
			instance = new CommandController();
		}
		return instance;
	}
	
	public void executeCommand(char c, Rover rover){
		String command = ""+c;
		possibleCommands.get(command).execute(rover);
	}
	
}
