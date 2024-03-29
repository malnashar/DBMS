package eg.edu.alexu.csd.oop.db.cs51.interpreter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import eg.edu.alexu.csd.oop.db.cs51.QueryParameters;
import eg.edu.alexu.csd.oop.db.cs51.visitor.Visitor;

public class DeleteInterpreter implements Interpreter {
    private static final String REGEX1 = "DELETE +FROM +([a-zA-Z_][a-zA-Z0-9_]*) +WHERE +(.+) *;*";
    private static final String REGEX2 = "DELETE +FROM +([a-zA-Z_][a-zA-Z0-9_]*) *;*";

    @Override
    public QueryParameters interpret(String query) throws SQLException {
        // TODO Auto-generated method stub
        Pattern pattern1 = Pattern.compile(REGEX1, Pattern.CASE_INSENSITIVE);
        Matcher matcher1 = pattern1.matcher(query);
        Pattern pattern2 = Pattern.compile(REGEX2, Pattern.CASE_INSENSITIVE);
        Matcher matcher2 = pattern2.matcher(query);
        
        if(matcher1.matches()) {
            QueryParameters qp = new QueryParameters();
            qp.setTableName(matcher1.group(1));
            qp.setCondition(matcher1.group(2));
            return qp;
        } else if(matcher2.matches()) {
            QueryParameters qp = new QueryParameters();
            qp.setTableName(matcher2.group(1));
            return qp;
        } else {
            throw new SQLException();
        }
    }

    @Override
	public Object accept(Visitor visit, String query) throws SQLException, ParserConfigurationException, SAXException, IOException {
		// TODO Auto-generated method stub
		return visit.visit(this, query);
	}

}
