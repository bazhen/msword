package msword.engine;

import com.jacob.com.Variant;
import com.ms.word.Application;
import com.ms.word.Find;
import com.ms.word.Selection;

/**
 * 
 * @author Bazhenov
 *
 */
class MsWordUtils {

    static void removeRow(Application app) {
        Selection selection = app.getSelection();
        selection.selectRow();
        selection.getRows().delete();
    }

    static void insertRow(Application app) {
        Selection selection = app.getSelection();
        selection.insertRowsAbove();
    }

    static boolean findText(Application app, String text) {
        Selection selection = app.getSelection();
        selection.wholeStory();
        Find find = selection.getFind();
        return find.execute(new Variant(text));
    }

    static void processCol(Application app, String pattern, String value) {
        if (MsWordUtils.findText(app, pattern)) {
            Selection selection = app.getSelection();
            selection.moveUp();
            selection.insertAfter(value);
        }
    }
    
}