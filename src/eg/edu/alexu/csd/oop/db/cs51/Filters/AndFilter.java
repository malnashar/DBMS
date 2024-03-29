package eg.edu.alexu.csd.oop.db.cs51.Filters;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class AndFilter implements Filter{
    private Filter a;
    private Filter b;
    
    public AndFilter(Filter a, Filter b) {
        this.a = a;
        this.b = b;
    }
    
    @Override
    public List<Map<String, String>> filterTable(List<Map<String, String>> table) throws SQLException {
    	try {
        return a.filterTable(b.filterTable(table));
    	} catch(Exception e) {
    		throw new SQLException();
    	}
    }

}
