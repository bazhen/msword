package msword.engine;

public abstract class CommonScript {

    final protected OfficeApplication app = new OfficeApplication();
    
    protected abstract void runScript() throws EngineException;

    public void run(Context context) throws EngineException {
        app.start();
        app.openSource(context.getSourcePath());
        runScript();
        app.saveResult(context.getDestinationPath());
        app.close();
    }

}