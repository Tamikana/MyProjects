package ru.myMB.parser.SAX;

import ru.myMB.indvls.Indvl;
import ru.myMB.indvls.Indvls;
import ru.myMB.parser.IParser;

import java.io.File;
import java.util.ArrayList;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;


public class Parser implements IParser {
	public static Properties prop = null;
	public static Logger log = Logger.getLogger(UserHandler.class.getName());

	@Override
	public Object getObject(File file, @SuppressWarnings("rawtypes") Class c) throws JAXBException {
		UserHandler userhandler = new UserHandler();
		try {
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(file, userhandler);
		} catch (Exception e) {
			log.log(Level.SEVERE, e.getLocalizedMessage(), e);
		}
		Indvls indvls = new Indvls();
		ArrayList<Indvl> listIndvls1 = userhandler.getListIndvls();
		indvls.setListIndvls(listIndvls1);
		return indvls;
	}
	
	@Override
	public void saveObject(File file, Object o) throws JAXBException {
		}
}
