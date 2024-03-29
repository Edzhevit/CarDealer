package cardealer.util;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class XmlParserImpl implements XmlParser {

    @Override
    public <O> O parseXml(Class<O> object, String path) throws JAXBException, FileNotFoundException {
        JAXBContext context = JAXBContext.newInstance(object);
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(new File(path))));
        Unmarshaller unmarshaller = context.createUnmarshaller();

        return (O) unmarshaller.unmarshal(reader);
    }

    @Override
    public <O> void exportToXml(O object, Class<O> objectClass, String path) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(objectClass);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
        marshaller.marshal(object, new File(path));
    }
}
