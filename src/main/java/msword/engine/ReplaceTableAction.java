package msword.engine;

import java.util.ArrayList;

import com.ms.word.Application;

/**
 * @author bazhen
 * @version 1.0
 */
public class ReplaceTableAction implements Action {

    static final String TABLE_PATTERN_PREFIX = "%#";
    
    final ArrayList<ArrayList<Cell>> table;
    
    public ReplaceTableAction(ArrayList<ArrayList<Cell>> table) {
        this.table = table;
    }
    
    public void execute(Application app) {
        for (ArrayList<Cell> row : table) {
            if (!MsWordUtils.findText(app, TABLE_PATTERN_PREFIX)) {
                return;
            }
            MsWordUtils.insertRow(app);
            for (Cell cell : row) {
                String pattern = TABLE_PATTERN_PREFIX + cell.getPattern();
                MsWordUtils.processCol(app, pattern, cell.getValue());
            }
        }
        if (MsWordUtils.findText(app, TABLE_PATTERN_PREFIX)) {
            MsWordUtils.removeRow(app);
        }
    }

}
