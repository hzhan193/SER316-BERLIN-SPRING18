package main.java.memoranda;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
public class Driver {
	private int id;
	private String name;
	private String phoneNumber;
	
	// Constructors
	public Driver(int idVar, String nameVar, String phoneNumberVar) {
		id = idVar;
		name = nameVar;
		phoneNumber = phoneNumberVar;
	}
	
	public Driver() {
		id = 0;
		name = "";
		phoneNumber = "";
	}
	
	
	// Getters
	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	
	// Setters
	public void setId(int idVar) {
		id = idVar;
	}
	
	public void setName(String nameVar) { 
		name = nameVar;
	}
	
	public void setPhoneNumber(String phoneNumberVar) {
		phoneNumber = phoneNumberVar;
	}
	
    /**
     * this method generate a XML file and initialize driver nodes.
     */
    public static void createXML() {
        try {
            
            DocumentBuilderFactory documentFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder documentBuilder = documentFactory.newDocumentBuilder();
            Document document = documentBuilder.newDocument();
            // root element
            Element root = document.createElement("company");
            document.appendChild(root);
            // driver element
            Element driver = document.createElement("driver");
            root.appendChild(driver);
            // set an attribute to driver element
            Attr attr = document.createAttribute("id");
            attr.setValue("1");
            driver.setAttributeNode(attr);
            // name element
            Element name = document.createElement("name");
            name.appendChild(document.createTextNode("James"));
            driver.appendChild(name);
 
            // phone element
            Element phone = document.createElement("phone");
            phone.appendChild(document.createTextNode("666-333-4444"));
            driver.appendChild(phone);
            
            // driver2 element
            Element driver2 = document.createElement("driver");
            root.appendChild(driver2);
            
            // set an attribute to driver element
            Attr attr2 = document.createAttribute("id");
            attr2.setValue("2");
            driver2.setAttributeNode(attr2);
            // name element
            Element name2 = document.createElement("name");
            name2.appendChild(document.createTextNode("John"));
            driver2.appendChild(name2);
 
            // phone element
            Element phone2 = document.createElement("phone");
            phone2.appendChild(document.createTextNode("215-314-6321"));
            driver2.appendChild(phone2);

            Element driver3 = document.createElement("driver");
            root.appendChild(driver3);
            
            // set an attribute to driver element
            Attr attr3 = document.createAttribute("id");
            attr3.setValue("3");
            driver3.setAttributeNode(attr3);
            // name element
            Element name3 = document.createElement("name");
            name3.appendChild(document.createTextNode("Alex"));
            driver3.appendChild(name3);
 
            // phone element
            Element phone3 = document.createElement("phone");
            phone3.appendChild(document.createTextNode("876-365-4125"));
            driver3.appendChild(phone3);
            // create the xml file
            //transform the DOM Object to an XML File
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource domSource = new DOMSource(document);
            //generate XML file
            StreamResult streamResult = new StreamResult(new File("main/resources/util/driver.xml"));
            transformer.transform(domSource, streamResult);
            //System.out.println("Done creating XML File");
        } catch (ParserConfigurationException pce) {
            pce.printStackTrace();
        } catch (TransformerException tfe) {
            tfe.printStackTrace();
        }

    }
	/**
	 * this method read XML file to look up all drivers
	 * @param fileName XML file name
	 * @return
	 * all driver objects
	 */
    public static Driver[] lookupDriver(String fileName) {
        try {
                File fXmlFile = new File(fileName);
                DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                Document doc = dBuilder.parse(fXmlFile);

                doc.getDocumentElement().normalize();

                System.out.println("Root element :" + doc.getDocumentElement().getNodeName());

                NodeList nList = doc.getElementsByTagName("driver");

                Driver drivers[] = new Driver[nList.getLength()];
                for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                //System.out.println("\nCurrent Element :" + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    //System.out.println("driver id : " + eElement.getAttribute("id"));
                    //System.out.println("name : " + eElement.getElementsByTagName("name").item(0).getTextContent());
                    //System.out.println("phone number : " + eElement.getElementsByTagName("phone").item(0).getTextContent());
                    drivers[temp].id = Integer.parseInt(eElement.getAttribute("id"));
                    drivers[temp].name = eElement.getElementsByTagName("phone").item(0).getTextContent();
                    drivers[temp].phoneNumber = eElement.getElementsByTagName("phone").item(0).getTextContent();
                    System.out.println("driver id : " + drivers[temp].id);
                    System.out.println("name : " + drivers[temp].name);
                    System.out.println("phone number : " + drivers[temp].phoneNumber);
                }
            }
            return drivers;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
    }
}
