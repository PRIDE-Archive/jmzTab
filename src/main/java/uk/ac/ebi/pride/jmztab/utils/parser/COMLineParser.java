package uk.ac.ebi.pride.jmztab.utils.parser;

import uk.ac.ebi.pride.jmztab.model.Comment;
import uk.ac.ebi.pride.jmztab.utils.errors.MZTabErrorList;
import uk.ac.ebi.pride.jmztab.utils.errors.MZTabException;

/**
 * User: Qingwei
 * Date: 10/02/13
 */
public class COMLineParser extends MZTabLineParser {
    public void parse(int lineNumber, String line, MZTabErrorList errorList) throws MZTabException {
        super.parse(lineNumber, line, errorList);
    }

    public Comment getComment() {
        String msg = items.length == 1 ? "" : items[1];
        return new Comment(msg);
    }
}