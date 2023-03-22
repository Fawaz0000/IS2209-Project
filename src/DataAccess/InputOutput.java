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
    private String filePath;
    private CsvResultSet data;

    public InputOutput(String filePath) {
        this.filePath = filePath;
    }

    public void save() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Set<String> columns = data.getData().get(0).keySet();
            writer.write(String.join(",", columns));
            writer.newLine();
            for (Map<String, Object> row : data.getData()) {
                List<String> values = new ArrayList<>();
                for (String column : columns) {
                    values.add(row.get(column).toString());
                }
                String line = String.join(",", values);
                writer.write(line);
                writer.newLine();
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CsvResultSet load() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String[] columns = reader.readLine().split(",");
            List<Map<String, Object>> data = new ArrayList<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] values = line.split(",");
                Map<String, Object> row = new HashMap<>();
                for (int i=0; i<columns.length; i++) {
                    row.put(columns[i], values[i]);
                }
                data.add(row);
            }
            reader.close();
            this.data = new CsvResultSet(columns, data);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return this.data;
    }
}
