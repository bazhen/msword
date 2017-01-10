package msword.engine;

import java.io.File;
import java.io.IOException;

import msword.client.FileUtils;

import org.apache.commons.jelly.JellyContext;
import org.apache.commons.jelly.JellyException;
import org.apache.commons.jelly.XMLOutput;
import org.jdom.Document;

/**
 * 
 * @author Bazhenov
 *
 */
public class JellyScript extends CommonScript {
    
    private static final String APPLICATION = "application";
    private static final String DOCUMENT = "document";
    
    private static final String SCRIPT_SUFFIX = ".xml";
    private static final String SCRIPT_PREFIX = "script_";

    JellyContext context = new JellyContext();
    
    private final File file;

    public JellyScript(byte[] data) throws EngineException {
        try {
            file = FileUtils.createTempFile(SCRIPT_PREFIX, SCRIPT_SUFFIX, data);
        } catch (IOException e) {
            throw new EngineException(e);
        }
    }

    public void setDocument(Document document) {
        context.setVariable(DOCUMENT, document);
    }

    @Override
    protected void runScript() throws EngineException {
        XMLOutput output = XMLOutput.createDummyXMLOutput();
        try {
            context.setVariable(APPLICATION, app.getApplication());
            this.context.runScript(file, output);
        } catch (JellyException e) {
            throw new EngineException(e);
        }
    }


}