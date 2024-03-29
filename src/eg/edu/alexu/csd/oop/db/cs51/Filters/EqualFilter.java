package eg.edu.alexu.csd.oop.db.cs51.Filters;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class EqualFilter implements Filter{
    private String colName;
    private String value;
    
    public EqualFilter(String colName, String value) {
        this.colName = colName;
        this.value = value;
    }
    
    @Override
    public List<Map<String, String>> filterTable(List<Map<String, String>> table) throws SQLException {
    	try {
        List<Map<String, String>> filtered = new ArrayList<Map<String, String>>();
        for(Map<String, String> row : table) {
            if(row.get(colName).equalsIgnoreCase(value)) {
                filtered.add(row);
            }
        }
        return filtered;
    	} catch(Exception e) {
    		throw new SQLException();
    	}
    }

}
