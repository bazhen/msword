package msword.engine;

import java.util.ArrayList;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Element;

/**
 * @author bazhen
 * @version 1.0
 */
class ActionFactory {

    private static final String ATTR_PASSWORD = "password";
    private static final String ATTR_PATTERN = "pattern";

    static final String TAG_REPLACE_ALL = "replace";
    static final String TAG_TABLE = "table";
    static final String TAG_ROW = "row";
    static final String TAG_COL = "column";

    static Action getAction(Element node) {
        if (TAG_REPLACE_ALL.equals(node.getName())) {
            return new ReplaceAction(node.getAttributeValue(ATTR_PATTERN), node.getValue());
        } else if (TAG_TABLE.equals(node.getName())) {
            ArrayList<ArrayList<Cell>> list = createTable(node);
            return new ReplaceTableAction(list);
        } else if (ProtectAction.PROTECT_TAG.equals(node.getName())) {
            return new ProtectAction(node.getAttributeValue(ATTR_PASSWORD));
        } else {
            return null;
        }
    }

    private static ArrayList<ArrayList<Cell>> createTable(Element node) {
        ArrayList<ArrayList<Cell>> list = new ArrayList<ArrayList<Cell>>();
        for (Iterator iter = node.getDescendants(); iter.hasNext();) {
            Element item = (Element) iter.next();
            list.add(createRow(item));
        }
        return list;
    }

    private static ArrayList<Cell> createRow(Element item) {
        ArrayList<Cell> row = new ArrayList<Cell>();
        for (Iterator iter = item.getDescendants(); iter.hasNext();) {
            Element col = (Element) iter.next();
            Cell rowCol = new Cell(col.getAttributeValue(ATTR_PATTERN), col.getValue());
            row.add(rowCol);
        }
        return row;
    }

    final Log log = LogFactory.getLog(this.getClass());

}
