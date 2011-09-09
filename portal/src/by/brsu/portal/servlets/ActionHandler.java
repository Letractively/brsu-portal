/**
 * BrSU Projects Portal
 * (c) 2011, BrSU Java Group
 */
package by.brsu.portal.servlets;


import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import by.brsu.portal.PortalTechnicalException;

/**
 * @author Roman Ulezlo
 * 
 */
public class ActionHandler extends DefaultHandler {
	private String actionName;
	private String className;
	private String currentAction;

	public ActionHandler(String actionName) {
		className = "";
		currentAction = "";
		this.actionName = actionName;
		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {			
			SAXParser saxParser = factory.newSAXParser();
			saxParser
					.setProperty(
							"http://apache.org/xml/properties/schema/external-noNamespaceSchemaLocation",
							getClass().getResourceAsStream(
									"SchemaForActionsMap.xsd"));
			saxParser.parse(
					new InputSource(getClass().getResourceAsStream(
							"MapOfActions.xml")), this);
		} catch (Throwable t) {
			new PortalTechnicalException("xml invalid");
		}
	}

	@Override
	public void startElement(String namespaceURI, String localName,
			String qualifiedName, Attributes attributes) throws SAXException {
		if (qualifiedName.equals("action")) {
			if (attributes.getValue("name").equals(actionName)) {
				currentAction = actionName;
			}
		}
	}

	@Override
	public void endElement(String namespaceURI, String simpleName,
			String qualifiedName) throws SAXException {
	}

	@Override
	public void characters(char buf[], int offset, int len) throws SAXException {
		if (currentAction.equals(actionName)) {
			className = new String(buf, offset, len);
			currentAction = "";
		}
	}

	String getClassName() {
		return className;
	}
}
