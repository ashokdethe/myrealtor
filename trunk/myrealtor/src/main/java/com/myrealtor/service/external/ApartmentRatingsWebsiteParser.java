package com.myrealtor.service.external;

import java.net.URL; 
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;
import org.jaxen.SimpleNamespaceContext;
import org.jaxen.dom4j.Dom4jXPath;
import org.xml.sax.XMLReader;

import com.myrealtor.domain.beans.Apartment;

public class ApartmentRatingsWebsiteParser extends ApartmentHTMLParser {

	@SuppressWarnings("unchecked")
	public List<Apartment> parse(URL url) throws Exception {
		log.debug("parse: " + url);
		// "http://www.apartmentratings.com/rate/SearchResults?action=post&query=78727&x=20&y=4"
		
		// Need to use HTML parser (NekoHTML) to avoid:
		// org.dom4j.DocumentException: Server returned HTTP response code: 503
		// for URL: http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd
		XMLReader xmlReader = new org.cyberneko.html.parsers.SAXParser();

		SAXReader sax = new SAXReader(xmlReader);
		//Document doc = sax.read(new URL("http://www.apartmentratings.com/rate/SearchResults?action=post&query=78727&x=20&y=4"));
		Document doc = sax.read( url );

		//log.info( "doc.hasContent(): " + doc.hasContent() );

		Map<String, String> map = new HashMap<String, String>();
		map.put("xhtml", "http://www.w3.org/1999/xhtml");

		Dom4jXPath xpath = new Dom4jXPath("//xhtml:DIV[@class='address']");
		xpath.setNamespaceContext(new SimpleNamespaceContext(map));
		List listNodes = xpath.selectNodes(doc);
		
		List <Apartment> listApt = new ArrayList<Apartment>();
		for (Object object : listNodes) {
			Node node = (Node)object;
			String var = node.getText().trim();
			log.debug( var );
			listApt.add( new Apartment( var ) );
		}
		
//		if (listApt.isEmpty()) {
//			log.info("listApt.isEmpty(): " + doc.asXML());
//		}

		return listApt;
	}

}
