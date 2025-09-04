import java.util.*;

public class IntegerFeature extends Feature {
    private ArrayList<IntegerDataItem> dataItems = new ArrayList<>();
    private final ArrayList<Integer> values = new ArrayList<>();

    public IntegerFeature(String featureName, ArrayList<IntegerDataItem> values) {
        super(featureName, "Integer");

        for (IntegerDataItem value : values) {
            this.values.add(value.value);
        }
        Collections.sort(this.values);
        this.dataItems = values;
    }

    public String getMaxValue() {

        int highestIndex = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) > values.get(highestIndex)) {
                highestIndex = i;
            }
        }

        return dataItems.get(highestIndex).showString();
    }

    public String getMinValue() {
        int lowestIndex = 0;
        for (int i = 0; i < values.size(); i++) {
            if (values.get(i) < values.get(lowestIndex)) {
                lowestIndex = i;
            }
        }

        return dataItems.get(lowestIndex).showString();
    }

    public String getUniqueValues() {
        ArrayList<Integer> uniqueValues = new ArrayList<>();

        for (IntegerDataItem dataItem : dataItems) {
            if (!uniqueValues.contains(dataItem.value)) {
                uniqueValues.add(dataItem.value);
            }
        }

        StringBuilder result = new StringBuilder("[");
        for (Integer item : uniqueValues) {
            result.append(item).append(", ");
        }

        return result.substring(0, result.length() - 2) + "]";
    }

    public void printInfo(){
        System.out.println("Feature Name: " + featureName);
        System.out.println("Feature Type: " + featureType);
        System.out.println("Unique values: " + getUniqueValues());
        System.out.println("Max Value: " + getMaxValue());
        System.out.println("Min Value: " + getMinValue());
    }
}
