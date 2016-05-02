import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Ahorcado {
	private static Scanner t = new Scanner(System.in);
	
	private String palabra;
	private char[] palabra_oculta;
	private List<Character> letras_usadas;
	private int fallos = 0;
	
	Ahorcado(int jugadores) {
		if(jugadores == 1) {
			palabra = Diccionario.palabraRandom();
		} else {
			palabra = pedirPalabra();
		}
		palabra_oculta = new char[palabra.length()];
		for(int i=0; i<palabra.length(); i++) {
			palabra_oculta[i] = '-';
		}
		letras_usadas = new ArrayList<Character>();
		while(fallos < 7 && !haGanado()) {
			pintarAhorcado();
			char letra = pedirLetra();
			if(acertarLetra(letra)) {
				System.out.println("Has acertado!");
				meterLetra(letra);
			} else {
				System.out.println("Has fallado!");
				fallos++;
			}
			letras_usadas.add(letra);
		}
		pintarAhorcado();
		if(fallos >= 7) {
			System.out.println("Has perdido");
		} else {
			System.out.println("Has ganado!");
		}
	}
	
	private void pintarAhorcado() {
		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		System.out.println("\n=================");
		for(int i=0; i<palabra.length(); i++) {
			System.out.print(palabra_oculta[i]);
		}
		System.out.println("\n=================");
		System.out.println("Letras usadas: ");
		for(char letra : letras_usadas) {
			System.out.print(letra+" ");
		}
		System.out.println("\n=================");
		System.out.println("Fallos: "+fallos+"/7 \n");
		System.out.println(getMonigote());
		System.out.println("=================");
	}
	
	private boolean acertarLetra(char c) {
		for(int i=0; i<palabra.length(); i++) {
			if(palabra.charAt(i) == c) {
				return true;
			}
		}
		return false;
	}
	
	private void meterLetra(char c) {
		for(int i=0; i<palabra.length(); i++) {
			if(palabra.charAt(i) == c) {
				palabra_oculta[i] = c;
			}
		}
	}
	
	private char pedirLetra() {
		char c = 0;
		while(!charValido(c)) {
			System.out.println("Introduce una letra: \n");
			c = t.next().charAt(0);
			if(Character.isUpperCase(c)) {
				c = Character.toLowerCase(c);
			}
		}
		return c;
	}
	
	private boolean charValido(char c) {
		if(c == 0) { return false; }
		for(char letra : letras_usadas) {
			if(c == letra) {
				return false;
			}
		}
		return true;
	}
	
	private boolean haGanado() {
		for(int i=0; i<palabra.length(); i++) {
			if(palabra_oculta[i] != palabra.charAt(i)) {
				return false;
			}
		}
		return true;
	}
	
	private String getMonigote() {
		String[] msgArray = new String[5];
		switch(fallos) {
		case 1:
			msgArray[0] = "\n";
			msgArray[1] = "\n";
			msgArray[2] = "\n";
			msgArray[3] = "\n";
			msgArray[4] = "--------\n";
			break;
		case 2:
			msgArray[0] = "|\n";
			msgArray[1] = "|\n";
			msgArray[2] = "|\n";
			msgArray[3] = "|\n";
			msgArray[4] = "--------\n";
			break;
		case 3:
			msgArray[0] = "|----\n";
			msgArray[1] = "|\n";
			msgArray[2] = "|\n";
			msgArray[3] = "|\n";
			msgArray[4] = "--------\n";
			break;
		case 4:
			msgArray[0] = "|----\n";
			msgArray[1] = "|   O\n";
			msgArray[2] = "|\n";
			msgArray[3] = "|\n";
			msgArray[4] = "--------\n";
			break;
		case 5:
			msgArray[0] = "|----\n";
			msgArray[1] = "|   O\n";
			msgArray[2] = "|   |\n";
			msgArray[3] = "|\n";
			msgArray[4] = "--------\n";
			break;
		case 6:
			msgArray[0] = "|----\n";
			msgArray[1] = "|   O\n";
			msgArray[2] = "|   T\n";
			msgArray[3] = "|\n";
			msgArray[4] = "--------\n";
			break;
		case 7:
			msgArray[0] = "|----\n";
			msgArray[1] = "|   O\n";
			msgArray[2] = "|   T\n";
			msgArray[3] = "|   ^\n";
			msgArray[4] = "--------\n";
			break;
		default:
			return "";
		}
		String msg = "";
		for(int i=0; i<5; i++) {
			msg += msgArray[i];
		}
		return msg;
	}
	
	private static String pedirPalabra() {
		System.out.println("Jugador 1, introduce una palabra: \n");
		return t.nextLine();
	}
}
