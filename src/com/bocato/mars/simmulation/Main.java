
package com.bocato.mars.simmulation;

import java.util.Scanner;

import com.bocato.mars.model.Plateau;
import com.bocato.mars.model.Rover;

public class Main {

	public Main() {
	}

	public static void main(String args[]) {
		Scanner scanner = new Scanner(System.in);
		
		System.out.println("Digite as coordenadas iniciais no formato 'coordenada_x coordenada_y':\nExemplo: 5 5");
		String upperRightBounds = scanner.nextLine();
		Plateau.getInstance(upperRightBounds);
		
		for(;;){
		
			System.out.println("Digite as posicao atual da sonda no formato 'coordenada_x coordenada_y direcao':\nExemplo: 1 2 N");
			String roverInputs = scanner.nextLine();
			Rover rover = new Rover(roverInputs.toUpperCase());
			
			System.out.println("Digite a string de comandos:\nExemplo: LMLMLMLMM");
			String currentPosition = rover.executeCommand(scanner.nextLine().toUpperCase());
			System.out.println(currentPosition);
			
			System.out.println("\nDeseja enviar uma nova posicao e novos comandos para a sonda? (S/N)");
			
			if(!scanner.nextLine().equalsIgnoreCase("S")){
				break;
			}
		}
	}
}