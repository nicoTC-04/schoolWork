package window;

public class Jugadores {
	private static String[] nombres = new String[5];
	private static String[] pais = new String[5];
	private static String[] pos = new String[5];
	private static String[] edad = new String[5];
	private static String[] grupo = new String[5];
	private static String[] numero = new String[5];
	
	public Jugadores() {
		xmlReader x = new xmlReader();
		nombres = xmlReader.getName();
		pais = x.getPais();
		pos = x.getPos();
		edad = x.getEdad();
		grupo = x.getGrupo();
		numero = x.getNumero();
	}
	
	public static String[] getNombres() {
		return nombres;
	}
	public static String[] getPais() {
		return pais;
	}
	public static String[] getPos() {
		return pos;
	}
	public static String[] getEdad() {
		return edad;
	}
	public static String[] getGrupo() {
		return grupo;
	}
	public static String[] getNumero() {
		return numero;
	}
	
	public static String imgName(int x) {
		String temp = nombres[x];
		String[] splitStr = temp.split("\\s+");
		return (splitStr[1]+".jpg");
	}
}