package Main;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class Password {
	private String code;
	
	//metodo constructor de la clase
	public Password() {
		XMLreader();
	}
	
	//metodo para leer el xml
	private void XMLreader() {
		try {
			//abrir el xml
			File inputFile = new File("recursos\\Password.xml");
	        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	        Document doc = dBuilder.parse(inputFile);
	         
	        //api de XPath para leerlo
	        XPath xPath = XPathFactory.newInstance().newXPath();
	        Node codigoNode = (Node) xPath.compile("/Password/Codigo").evaluate(doc, XPathConstants.NODE);
	        code = codigoNode.getTextContent();
	        
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	//metodo que retorna la contraseña
	public String getPassword() {
		XMLreader();
		return code;
	}
	
	//metodo que checa si el password ingresado en la clase logIn es correcto
	public boolean passwordCheck(String txtPassword) throws Exception {
		//convertir a int el password del xml
		int realPsswrd = Integer.parseInt(code);
		
		//algoritmo que retorna excepciones y valores booleanos dependiendo de si el password es correcto o no
		try {
			int inputPsswrd = Integer.parseInt(txtPassword);
			if(txtPassword.length() != 6) {
				throw new Exception("El codigo introducido no es de 6 digitos");
			} else if(inputPsswrd == realPsswrd) {
				return true;
			} else {
				return false;
			}
        }
        catch (NumberFormatException e) {
        	throw new Exception("Tienes que introducir un numero de 6 digitos");
        }
	}
	
	//metodo que cambia la contraseña en la clase frame
	public boolean change(String newPassword) throws Exception {
		
		try {
			//esto es solo para probar si el texto es un int (si no se va a la excepcion)
			int inputPsswrd = Integer.parseInt(newPassword);
			
			//if para checar que si se pueda usar el password
			if(newPassword.length() != 6) {
				throw new Exception("El codigo introducido no es de 6 digitos");
			} else {
				//try-catch para cambiar el password
				try {
					//leer el xml
			         File inputFile = new File("recursos\\Password.xml");
			         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			         Document doc = dBuilder.parse(inputFile);
			         
			         //Editarlo
			         XPath xPath = XPathFactory.newInstance().newXPath();
			         Node codigoNode = (Node) xPath.compile("/Password/Codigo").evaluate(doc, XPathConstants.NODE);
			         codigoNode.setTextContent(newPassword);
			         
			         //gaurdar el nuevo documento en el mismo archivo
			         Transformer tf = TransformerFactory.newInstance().newTransformer();

			         DOMSource domSource = new DOMSource(doc);
			         StreamResult sr = new StreamResult(new File("recursos\\Password.xml"));
			         tf.transform(domSource, sr);
			         
			         
			         
			    } catch (Exception e) {
			         e.printStackTrace();
			    }
			}
        }
        catch (NumberFormatException e) {
        	throw new Exception("Tienes que introducir un numero de 6 digitos");
        }
		return true;
		
		
	}
	
}
