package DataAccess;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class InputOutput {
    private final String filePath;
    private CsvResultSet data;

    public InputOutput(String filePath) {
        //creates input output for the file path
        this.filePath = filePath;
    }

    //writes to the file using the CsvResultSet saved on the object
    public boolean save() {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // A buffered writer is a character-output stream that uses a default-sized output buffer.
            // the file writer is a convenience class for writing character files.
            
            // get the set of strings for the columns
            List<String> columns = data.getColumns();

            // write the columns to the top of the file
            List<String> headers = new ArrayList<>(); // output for the headers
            for (String column : columns){
                //escape each column for the commas etc and then add to the headers list
                headers.add(escapeCsvCell(column));
            }
            // join and then write the headers to the file
            String headerLine = String.join(",", headers);
            writer.write(headerLine);
            writer.newLine();

            for (Map<String, Object> row : data.getData()) {
                // for each row in the data. the string is the column name and the object is the value

                List<String> values = new ArrayList<>(); // list of strings for the output array
                for (String column : columns) {
                    // for each columnof that row add the its value to the list of strings
                    values.add(escapeCsvCell(row.get(column).toString()));
                }
                //join that list to make a single row
                String line = String.join(",", values);
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
        //writes to the file using the CsvResultSet saved on the object
    public boolean save(CsvResultSet data) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            // A buffered writer is a character-output stream that uses a default-sized output buffer.
            // the file writer is a convenience class for writing character files.
            
            // get the set of strings for the columns
            List<String> columns = data.getColumns();

            // write the columns to the top of the file
            List<String> headers = new ArrayList<>(); // output for the headers
            for (String column : columns){
                //escape each column for the commas etc and then add to the headers list
                headers.add(escapeCsvCell(column));
            }
            // join and then write the headers to the file
            String headerLine = String.join(",", headers);
            writer.write(headerLine);
            writer.newLine();

            for (Map<String, Object> row : data.getData()) {
                // for each row in the data. the string is the column name and the object is the value

                List<String> values = new ArrayList<>(); // list of strings for the output array
                for (String column : columns) {
                    // for each columnof that row add the its value to the list of strings
                    values.add(escapeCsvCell(row.get(column).toString()));
                }
                //join that list to make a single row
                String line = String.join(",", values);
                writer.write(line);
                writer.newLine();
            }
            writer.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    public CsvResultSet load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            //read in just one line for the headings
            String[] columns = parseCsvLine(reader.readLine());
            
            //create a list of maps for the data result
            List<Map<String, Object>> coreData = new ArrayList<>();

            //read in first line
            String line = reader.readLine();
            while (line != null) {

                // get each separate value of that row as they are in the line.
                String[] values = parseCsvLine(line);

                Map<String, Object> row = new HashMap<>();
                for (int i=0; i<columns.length; i++) {
                    row.put(columns[i], values[i]);
                }
                coreData.add(row);

                //read in next line
                line = reader.readLine();
            }
            this.data = new CsvResultSet(columns, coreData);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.data;
    }
    
    public CsvResultSet where(String colName, Object colValue){
       CsvResultSet retData;
       List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
        while(this.data.next()){
            if (this.data.getObject(colName) == colValue) {
                rows.add(this.data.getCurrentRow());
            }
       }
        this.data = new CsvResultSet(this.data.getColumns(), rows);
        return this.data;
    }
    
    public CsvResultSet where(int colIndex, Object colValue){
    CsvResultSet retData;
       List<Map<String,Object>> rows = new ArrayList<Map<String,Object>>();
        while(this.data.next()){
            if (this.data.getObject(colIndex) == colValue) {
                rows.add(this.data.getCurrentRow());
            }
       }
        this.data = new CsvResultSet(this.data.getColumns(), rows);
        return this.data;
    }
    
    private static String[] parseCsvLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        boolean inQuotes = false;
        for (int i=0; i<line.length(); i++) {
            char c = line.charAt(i);
            if (c == ',' && !inQuotes) {
                values.add(sb.toString());
                sb.setLength(0);
            } else if (c == '\"') {
                inQuotes = !inQuotes;
                if (i+1 < line.length() && line.charAt(i+1) == '\"') {
                    sb.append('\"');
                    i++;
                }
            } else {
                sb.append(c);
            }
        }
        values.add(sb.toString());
        return values.toArray(new String[0]);
    }

    private static String escapeCsvCell(String input) {
        if (input == null) {
            return "";
        }
        if (input.contains(",") || input.contains("\"") || input.contains("\n")) {
            return "\"" + input.replace("\"", "\"\"") + "\"";
        } else {
            return input;
        }
    }
}
