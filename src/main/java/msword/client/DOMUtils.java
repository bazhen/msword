package msword.client;

import java.io.ByteArrayInputStream;
import java.io.IOException;

import msword.engine.EngineException;

import org.jdom.Document;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

/**
 * 
 * @author Bazhenov
 *
 */
public class DOMUtils {

    public static Document parse(byte[] content) throws EngineException {
        SAXBuilder builder = new SAXBuilder();
        ByteArrayInputStream bais = new ByteArrayInputStream(content);
        try {
            Document document = builder.build(bais);
            return document;
        } catch (JDOMException e) {
            throw new EngineException(e);
        } catch (IOException e) {
            throw new EngineException(e);
        }
    }

}
