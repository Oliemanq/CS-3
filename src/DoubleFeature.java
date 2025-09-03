import java.util.*;

public class DoubleFeature extends Feature {
    private ArrayList<DoubleDataItem> DataItems = new ArrayList<>();
    private ArrayList<Double> values = new ArrayList<>();

    public DoubleFeature(String featureName, ArrayList<DoubleDataItem> values) {
        super(featureName, "Double");

        for (DoubleDataItem value : values) {
            this.values.add(value.value);
        }
        Collections.sort(this.values);
        this.DataItems = values;
    }

    public double getMeanValue() {
        double sum = 0.0;
        for (double value : values) {
            sum += value;
        }
        return sum / values.size();
    }

    public double getMedianValue() {
        int size = values.size();
        if (size % 2 == 0) {
            return (values.get((size / 2) - 1) + values.get(size / 2)) / 2.0; //Getting average of two median values
        } else {
            return values.get(size / 2); //returning median value
        }
    }

    public double getStandardDeviation() {
        double mean = getMeanValue();
        double sum = 0.0;
        for (double value : values) {
            sum += Math.pow(value - mean, 2);
        }
        return Math.sqrt(sum / values.size());
    }



    public void printInfo() {
        System.out.println("Feature Name: " + featureName);
        System.out.println("Feature Type: " + featureType);
        System.out.println("Mean Value: " + getMeanValue());
        System.out.println("Median Value: " + getMedianValue());
        System.out.println("Standard Deviation: " + getStandardDeviation());
    }
}
