import java.util.*;

public class StringFeature extends Feature {
    private ArrayList<StringDataItem> dataItems = new ArrayList<>();
    private ArrayList<String> values = new ArrayList<>();

    public StringFeature(String featureName, ArrayList<StringDataItem> values) {
        super(featureName, "String");

        for (StringDataItem value : values) {
            this.values.add(value.value);
        }
        this.dataItems = values;
    }

    public ArrayList<String> getUniqueValues() {
        ArrayList<String> uniqueValues = new ArrayList<>();
        for (String value : values) {
            if (!uniqueValues.contains(value)) {
                uniqueValues.add(value);
            }
        }

        return uniqueValues;
    }

    public void printInfo() {
        System.out.println("Feature Name: " + featureName);
        System.out.println("Feature Type: " + featureType);
        System.out.println("Unique values: " + getUniqueValues());
    }
}
