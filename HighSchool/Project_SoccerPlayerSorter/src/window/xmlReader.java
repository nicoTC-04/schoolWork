package window;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;

public class xmlReader {

	private static String[] name = new String[5];
	private String[] pais = new String[5];
	private String[] pos = new String[5];
	private String[] edad = new String[5];
	private String[] grupo = new String[5];
	private String[] numero = new String[5];
	
	public static String[] getName() {
		return xmlReader.name;
	}

	public String[] getPais() {
		return this.pais;
	}

	public String[] getPos() {
		return this.pos;
	}

	public String[] getEdad() {
		return this.edad;
	}

	public String[] getGrupo() {
		return this.grupo;
	}

	public String[] getNumero() {
		return this.numero;
	}

	public xmlReader() {

	      try {
	         File inputFile = new File("Jugadores.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         NodeList nList = doc.getElementsByTagName("Jugador");
	         
	         for (int temp = 0; temp < nList.getLength(); temp++) {
	            Node nNode = nList.item(temp);
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               
	               name[temp] = eElement.getElementsByTagName("Nombre").item(0).getTextContent();
	               pais[temp] = eElement.getElementsByTagName("Pais").item(0).getTextContent();
	               pos[temp] = eElement.getElementsByTagName("Pos").item(0).getTextContent();
	               edad[temp] = eElement.getElementsByTagName("Edad").item(0).getTextContent();
	               grupo[temp] = eElement.getElementsByTagName("Grupo").item(0).getTextContent();
	               numero[temp] = eElement.getElementsByTagName("Numero").item(0).getTextContent();
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

}
