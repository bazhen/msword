package msword.engine;

import com.jacob.com.Variant;
import com.ms.word.Application;
import com.ms.word.Document;
import com.ms.word.WdProtectionType;

/**
 * @author bazhen
 * @version 1.0
 */
class ProtectAction implements Action {

    static final String PROTECT_TAG = "protect";

    private String password;

    public ProtectAction(String password) {
        this.password = password;
    }

    public void execute(Application app) {
        Document activeDocument = app.getActiveDocument();
        activeDocument.protect(WdProtectionType.wdAllowOnlyFormFields, Variant.VT_FALSE, new Variant(password));
    }

}
