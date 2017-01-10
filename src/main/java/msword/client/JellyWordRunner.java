package msword.client;

import msword.engine.Context;
import msword.engine.JellyScript;
import msword.engine.EngineException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;



/**
 * @author bazhen
 * @version 1.0
 */
public class JellyWordRunner {

    private static final Log log = LogFactory.getLog(JellyWordRunner.class);

    public byte[] transform(byte[] source, byte[] data, byte[] script) throws EngineException {
        log.debug("transform start.");
        
        ContextBuilder builder = new ContextBuilder();
        builder.addDestination();
        builder.addSource(source);
        Context context = builder.getContext();

        JellyScript engine = new JellyScript(script);
        Document document = DOMUtils.parse(data);
        engine.setDocument(document);
        engine.run(context);
        
        byte[] rv = context.readOutput();
        log.debug("transform end.");
        return rv ;
    }
    
}
