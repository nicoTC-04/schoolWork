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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class listaPedidos {
	private String[] Tipo;
	private int[] Codigo;
	private String[] De;
	private String[] Para;
	private int[] Fecha;
	private int xmlCount;
	private int added = 1;
	
	
	//Constructor que llama metodo para leer el xml con los pedidos
	public listaPedidos() {
		xmlReader();
	}
	
	//Leer xml que tiene todos los pedidos
	private void xmlReader() {
		try {
	         File inputFile = new File("recursos\\Pedidos.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         doc.getDocumentElement().normalize();
	         NodeList nList = doc.getElementsByTagName("Pedido");
	         this.xmlCount = nList.getLength();
	         this.Tipo = new String[xmlCount];
	         this.Codigo = new int[xmlCount];
	         this.De = new String[xmlCount];
	         this.Para = new String[xmlCount];
	         this.Fecha = new int[xmlCount];
	         
	         for (int i = 0; i < nList.getLength(); i++) {
	            Node nNode = nList.item(i);
	            
	            if (nNode.getNodeType() == Node.ELEMENT_NODE) {
	               Element eElement = (Element) nNode;
	               
	               Tipo[i] = eElement.getElementsByTagName("Tipo").item(0).getTextContent();
	               Codigo[i] = Integer.parseInt(eElement.getElementsByTagName("Codigo").item(0).getTextContent());
	               De[i] = eElement.getElementsByTagName("De").item(0).getTextContent();
	               Para[i] = eElement.getElementsByTagName("Para").item(0).getTextContent();
	               Fecha[i] = Integer.parseInt(eElement.getElementsByTagName("Fecha").item(0).getTextContent());
	            }
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	}
	
	public boolean delete(int lugar) {
		try {
			//leer el xml
	         File inputFile = new File("recursos\\Pedidos.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         NodeList nList = doc.getElementsByTagName("Pedido");
	         Node nNode = nList.item(lugar);
	         
	         //eliminar el codigo
	         XPath xPath = XPathFactory.newInstance().newXPath();
	         Node codigoNode = (Node) xPath.compile("/config").evaluate(doc, XPathConstants.NODE);
	         codigoNode.removeChild(nNode);
	         
	         //gaurdar el nuevo documento en el mismo archivo
	         Transformer tf = TransformerFactory.newInstance().newTransformer();

	         DOMSource domSource = new DOMSource(doc);
	         StreamResult sr = new StreamResult(new File("recursos\\Pedidos.xml"));
	         tf.transform(domSource, sr);
	         
	         return true;
	         
	    } catch (Exception e) {
	         e.printStackTrace();
	         return false;
	    }
	}
	
	//metodo para añadir pedido al xml
	public boolean add(String newTipo, String newCodigo, String newDe, String newPara, String newFecha) {
		try {
			xmlReader();
			boolean fechaRepeat = true;
			int fechaTemp = Integer.parseInt(newFecha);
			
			//leer el xml
	         File inputFile = new File("recursos\\Pedidos.xml");
	         DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
	         DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
	         Document doc = dBuilder.parse(inputFile);
	         Element root = doc.getDocumentElement();
	         Element rootElement = doc.getDocumentElement();
	         
	         //esto es para no tener numeros epoch repetidos y que eso no cause problemas en la comparacion despues
	         
	         while(fechaRepeat) {
	        	 for(int i = 0; i<Fecha.length; i++) {
		        	 if(fechaTemp == Fecha[i]) {
		        		 fechaTemp++;
		        		 newFecha = String.valueOf(fechaTemp);
		        		 fechaRepeat = true;
		        		 break;
		        	 } else {
		        		 fechaRepeat = false;
		        	 }
		         }
	         }
	         
	         
	         //añadir las cosas nuevas al documento
	         Element pedido = doc.createElement("Pedido");
	         rootElement.appendChild(pedido);
	         
	         Element tipo = doc.createElement("Tipo");
	         tipo.appendChild(doc.createTextNode(newTipo));
	         pedido.appendChild(tipo);
	         
	         Element codigo = doc.createElement("Codigo");
	         codigo.appendChild(doc.createTextNode(newCodigo));
	         pedido.appendChild(codigo);
	         
	         Element de = doc.createElement("De");
	         de.appendChild(doc.createTextNode(newDe));
	         pedido.appendChild(de);
	         
	         Element para = doc.createElement("Para");
	         para.appendChild(doc.createTextNode(newPara));
	         pedido.appendChild(para);
	         
	         Element fecha = doc.createElement("Fecha");
	         fecha.appendChild(doc.createTextNode(newFecha));
	         pedido.appendChild(fecha);
	         
	         root.appendChild(pedido);
	         
	         //gaurdar el nuevo documento en el mismo archivo
	         Transformer tf = TransformerFactory.newInstance().newTransformer();

	         DOMSource domSource = new DOMSource(doc);
	         StreamResult sr = new StreamResult(new File("recursos\\Pedidos.xml"));
	         tf.transform(domSource, sr);
	         
	         return true;
	         
		} catch (Exception e) {
			//nada
		}
		return false;
	}
	
	//Getters para toda la info de los pedidos
	public String getTipo(int lugar) {
		return Tipo[lugar];
	}
	public int getCodigo(int lugar) {
		return Codigo[lugar];
	}
	public String getDe(int lugar) {
		return De[lugar];
	}
	public String getPara(int lugar) {
		return Para[lugar];
	}
	public int getFecha(int lugar) {
		return Fecha[lugar];
	}
	
	public int getCount() {
		return xmlCount;
	}
}