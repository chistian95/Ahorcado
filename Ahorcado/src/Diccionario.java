
public class Diccionario {
	private static String[] palabras = 
		{
				"casa",
				"perro",
				"rojo",
				"gato",
				"astronauta"
		};
	
	public static String palabraRandom() {
		int rnd = (int) (Math.random()*palabras.length);
		return palabras[rnd];
	}
}
