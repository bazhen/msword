package msword.engine;

import com.jacob.com.Variant;
import com.ms.word.Application;
import com.ms.word.Find;
import com.ms.word.Selection;
import com.ms.word.WdReplace;

/**
 * @author bazhen
 * @version 1.0
 */
class ReplaceAction implements Action {

    private final String pattern;

    private final String value;

    ReplaceAction(String pattern, String value) {
        this.pattern = pattern;
        this.value = value;
    }

    public void execute(Application app) {
        Selection selection = app.getSelection();
        selection.wholeStory();
        Find find = selection.getFind();
        Variant replaceWith = new Variant(value);
        find.execute(new Variant(pattern), null, null, Variant.VT_TRUE, null, null, null, null, null, replaceWith,
                new Variant(WdReplace.wdReplaceAll));
    }

}
