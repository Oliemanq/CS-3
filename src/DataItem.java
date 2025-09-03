public abstract class DataItem {
    private String dataType;

    private DataItem(){};
    protected DataItem(String dataType) {
        this.dataType = dataType;
    }

    public String findType() {
        return null;
    }

    public abstract String showString();
}

