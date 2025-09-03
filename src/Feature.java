public abstract class Feature {
    protected String featureName;
    protected String featureType;

    private Feature(){};
    protected Feature(String featureName, String featureType) {
        this.featureName = featureName;
        this.featureType = featureType;
    }

    public abstract void printInfo();
}
