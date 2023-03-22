package DataAccess;

import java.util.List;
import java.util.Map;

public class CsvResultSet {
    private String[] columns;
    private List<Map<String,Object>> data;
    private int currentRow = -1;

    public CsvResultSet(String[] columns,List<Map<String,Object>>data){
        this.columns=columns;
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

    public double getDouble(String columnName){
        return Double.parseDouble((String)data.get(currentRow).get(columnName));
    }

    public String getString(String columnName){
        return (String)data.get(currentRow).get(columnName);
    }

   public List<Map<String,Object>> getData(){
       return this.data;
   }
    public String[] getColumns(){
         return this.columns;
    }
}