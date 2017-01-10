package msword.engine;

/**
 * @author bazhen
 * @version 1.0
 */
public class EngineException extends Exception {

    private static final long serialVersionUID = 1L;

    public EngineException(Throwable ex) {
        super(ex);
    }

    public EngineException(String msg, Throwable ex) {
        super(msg, ex);
    }

}
