package msword.engine;

import java.util.Iterator;

import org.jdom.Document;
import org.jdom.Element;

/**
 * 
 * @author Bazhenov
 *
 */
class DOMScript extends CommonScript {

    private final Document dom;

    DOMScript(Document dom) {
        this.dom = dom;
    }

    @Override
    protected void runScript() throws EngineException {
        for (Iterator iterator = dom.getDescendants(); iterator.hasNext();) {
            Element element = (Element) iterator.next();
            Action action = ActionFactory.getAction(element);
            action.execute(app.getApplication());
        }
    }

}
