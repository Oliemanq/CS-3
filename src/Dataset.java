import java.util.*;
import com.opencsv.*;

public class Dataset {
    ArrayList<Feature> features = new ArrayList<>();
    ArrayList<ArrayList<StringDataItem>> data = new ArrayList<>();
    ArrayList<DataItem> columns = new ArrayList<>();

    private final String filepath;

    public Dataset(String filepath) {
        this.filepath = filepath;
    }

    public void loadFromCSV() {
        try (CSVReader r = new CSVReader(new java.io.FileReader(this.filepath))) {
            String[] row;
            while ((row = r.readNext()) != null) {
                ArrayList<StringDataItem> dataRow = new ArrayList<>();
                for (String item : row) {
                    StringDataItem dataItem = new StringDataItem(item);
                    dataRow.add(dataItem);
                }
                data.add(dataRow);
            }

            for (int i = 0; i <= data.size(); i++) {
                for (ArrayList<StringDataItem> rowData : data) {
                    columns.add(rowData.get(i));
                }
            }

            for(int i = 0; i <= data.size(); i++) {
                loadFeatureForColumn(i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void loadFeatureForColumn(int columnNum) {
        ArrayList<String> types = new ArrayList<>();
        ArrayList<StringDataItem> thisColumnData = new ArrayList<>();

        for (ArrayList<StringDataItem> rowData : data) {
            thisColumnData.add(rowData.get(columnNum));
        }

        String featureName = thisColumnData.getFirst().value;
        thisColumnData.removeFirst(); //Remove header

        for (StringDataItem columnItem : thisColumnData) {
            types.add(columnItem.findType());
        }



        if (types.contains("String")) {
            features.add(new StringFeature(featureName, thisColumnData));

        } else if (types.contains("Double")) {
            ArrayList<DoubleDataItem> doubleDataItems = new ArrayList<>();
            for (StringDataItem item : thisColumnData) {
                DoubleDataItem doubleItem = new DoubleDataItem(Double.parseDouble(item.value));
                doubleDataItems.add(doubleItem);
            }
            features.add(new DoubleFeature(featureName, doubleDataItems));

        } else { //Integer
            ArrayList<IntegerDataItem> intDataItems = new ArrayList<>();
            for (StringDataItem item : thisColumnData) {
                IntegerDataItem intItem = new IntegerDataItem(Integer.parseInt(item.value));
                intDataItems.add(intItem);
            }
            features.add(new IntegerFeature(featureName, intDataItems));
        }
    }

    public void printInfo() {
        for (int i = 0; i < features.size(); i++) {
            System.out.println("---");
            System.out.println("Feature " + (i+1) + ":");
            features.get(i).printInfo();
        }
    }
}
