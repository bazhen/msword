package msword.client;

import java.io.File;
import java.io.IOException;

import msword.engine.Context;
import msword.engine.EngineException;


/**
 * 
 * @author Bazhenov
 *
 */
class ContextBuilder {
    
    static final String TEMP_POSTFIX = ".doc";
    static final String TEMP_INPUT_PREFIX = "in_";
    static final String TEMP_OUT_PREFIX = "out_";
    
    Context context = new Context();
    
    void addDestination() throws EngineException {
        try {
            context.setOutput(File.createTempFile(TEMP_OUT_PREFIX, TEMP_POSTFIX));
        } catch (IOException e) {
            throw new EngineException(e);
        }
    }
    
    void addSource(byte[] source) throws EngineException {
        try {
            context.setInput(FileUtils.createTempFile(TEMP_INPUT_PREFIX, TEMP_POSTFIX, source));
        } catch (IOException e) {
            throw new EngineException(e);
        }
    }

    Context getContext() {
        return this.context;
    }
    
}