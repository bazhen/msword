package msword.engine;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.jacob.com.Variant;
import com.ms.word.Application;

/**
 * 
 * @author Bazhenov
 * 
 */
public class OfficeApplication {

    static final Log log = LogFactory.getLog(OfficeApplication.class);

    private Application app;

    void openSource(String source) {
        app.getDocuments().open(new Variant(source));
    }

    void start() {
        log.debug("application starting now...");
        app = new Application();
        app.setVisible(true);
        log.debug("application started. ok.");
    }

    void saveResult(String dest) {
        if (dest != null) {
            app.getActiveDocument().saveAs(new Variant(dest));
        } else {
            app.getActiveDocument().save();
        }
    }

    void close() {
        app.getActiveDocument().close();
        app.quit();
        log.debug("application quit.");
    }

    public Application getApplication() {
        return app;
    }

}