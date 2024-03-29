package eg.edu.alexu.csd.oop.db.cs51.interpreter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.ParserConfigurationException;

import org.xml.sax.SAXException;

import eg.edu.alexu.csd.oop.db.cs51.QueryParameters;
import eg.edu.alexu.csd.oop.db.cs51.visitor.Visitor;

public class CreateDBInterpreter implements Interpreter {
	private static final String CREATE_DB_PATTERN = "create +database +([A-Za-z_][A-Za-z0-9_]*) *;*";

	@Override
	public QueryParameters interpret(String query) throws SQLException {
		Pattern pattern = Pattern.compile(CREATE_DB_PATTERN, Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(query);
		if (matcher.matches()) {
			QueryParameters queryParameters = new QueryParameters();
			queryParameters.setDatabaseName(matcher.group(1));
			return queryParameters;
		} else {
			throw new SQLException();
		}
	}

	@Override
	public Object accept(Visitor visit, String query) throws SQLException, ParserConfigurationException, SAXException, IOException{
		return null;
	}

}
