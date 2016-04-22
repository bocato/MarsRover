package com.bocato.mars.util;

import java.util.HashMap;

import com.bocato.mars.commands.Move;
import com.bocato.mars.commands.RotateLeft;
import com.bocato.mars.commands.RotateRight;
import com.bocato.mars.model.Command;
import com.bocato.mars.model.Rover;
import com.bocato.mars.model.Command.*;

public class CommandParser {

	private static CommandParser instance =  null;
	private static  HashMap<String, Command> possibleCommands;
	
	private CommandParser(){}
	
	private static void generatePossibleCommands(){
		possibleCommands = new HashMap<String, Command>();
		possibleCommands.put("L", new RotateLeft());
		possibleCommands.put("R", new RotateRight());
		possibleCommands.put("M", new Move());
	}
	
	public static CommandParser getInstance(){
		if(instance ==  null){
			generatePossibleCommands();
			instance = new CommandParser();
		}
		return instance;
	}
	
	public void executeCommand(char c, Rover rover){
		String command = ""+c;
		possibleCommands.get(command).execute(rover);
	}
	
}
