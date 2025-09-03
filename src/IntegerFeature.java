import java.util.*;

public class IntegerFeature extends Feature {
    private ArrayList<IntegerDataItem> dataItems = new ArrayList<>();
    private ArrayList<Integer> values = new ArrayList<>();

    public IntegerFeature(String featureName, ArrayList<IntegerDataItem> values) {
        super(featureName, "Integer");

        for (IntegerDataItem value : values) {
            this.values.add(value.value);
        }
        Collections.sort(this.values);
        this.dataItems = values;
    }

    public int getMaxValue() {
        return Collections.max(values);
    }

    public int getMinValue() {
        return Collections.min(values);
    }

    public ArrayList<Integer> getUniqueValues() {
        ArrayList<Integer> uniqueValues = new ArrayList<>();

        for (Integer value : values) {
            if (!uniqueValues.contains(value)) {
                uniqueValues.add(value);
            }
        }

        return uniqueValues;
    }

    public void printInfo(){
        System.out.println("Feature Name: " + featureName);
        System.out.println("Feature Type: " + featureType);
        System.out.println("Unique values: " + getUniqueValues());
        System.out.println("Max Value: " + getMaxValue());
        System.out.println("Min Value: " + getMinValue());
    }
}
