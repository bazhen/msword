package msword.engine;


import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import msword.client.StreamUtils;


/**
 * 
 * @author Bazhenov
 * 
 */
public class Context {

    private File input;
    private File outFile;

    String getSourcePath() {
        return getInput().getAbsolutePath();
    }

    String getDestinationPath() {
        return getOutput().getAbsolutePath();
    }

    public byte[] readOutput() throws EngineException {
        try {
            InputStream fis = new BufferedInputStream(new FileInputStream(getOutput()));
            return StreamUtils.getBytes(fis);
        } catch (IOException ex) {
            throw new EngineException("Result reading exception:", ex);
        }
    }

    public void setInput(File file) {
        this.input = file;
    }

    File getInput() {
        return input;
    }

    public void setOutput(File file) {
        this.outFile = file;
    }

    File getOutput() {
        return outFile;
    }

}