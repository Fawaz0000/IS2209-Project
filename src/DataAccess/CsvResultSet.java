package DataAccess;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class CsvResultSet {
    
    private final List<String> columns;
    private final List<Map<String,Object>> data;
    private int currentRow = -1;

    public CsvResultSet(List<String> columns, List<Map<String,Object>> data){
        this.columns=columns;
        this.data=data;
    }
    

    public CsvResultSet(String[] columns, List<Map<String,Object>> data){
        this.columns = Arrays.asList(columns);
        this.data=data;
    }

    public boolean next() {
        if (currentRow < data.size() - 1) {
            currentRow++;
            return true;
        } else {
            return false;
        }
    }

    public int getInt(String columnName){
        return Integer.parseInt((String)data.get(currentRow).get(columnName));
    }
    public int getInt(int columnIndex){
        
        return Integer.parseInt((String)data.get(currentRow).get(columns.get(columnIndex)));
    }

    public double getDouble(String columnName){
        return Double.parseDouble((String)data.get(currentRow).get(columnName));
    }

    public double getDouble(int columnIndex){
        return Double.parseDouble((String)data.get(currentRow).get(columns.get(columnIndex)));
    }

    public String getString(String columnName){
        return (String)data.get(currentRow).get(columnName);
    }

    public String getString(int columnIndex){
        return (String)data.get(currentRow).get(columns.get(columnIndex));
    }

    public boolean getBoolean(String columnName){
        return Boolean.parseBoolean((String)data.get(currentRow).get(columnName));
    }

    public boolean getBoolean(int columnIndex){
        return Boolean.parseBoolean((String)data.get(currentRow).get(columns.get(columnIndex)));
    }

    public Timestamp getTimestamp(String columnName){
        return Timestamp.valueOf((String)data.get(currentRow).get(columnName));
    }

    public Timestamp getTimestamp(int columnIndex){
        return Timestamp.valueOf((String)data.get(currentRow).get(columns.get(columnIndex)));
    }
    
     public Object getObject(int columnIndex){
        return data.get(currentRow).get(columns.get(columnIndex));
    }
     
     public Object getObject(String columnName){
        return data.get(currentRow).get(columnName);
    }

     public Map<String,Object> getCurrentRow(){
        return data.get(currentRow);
    }
     
   public List<Map<String,Object>> getData(){
       return this.data;
   }
    public List<String> getColumns(){
         return this.columns;
    }
    
}