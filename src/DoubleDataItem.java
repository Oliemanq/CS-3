public class DoubleDataItem extends DataItem{
    public final Double value;

    public DoubleDataItem(Double value) {
        super("Double");
        this.value = value;
    }



    public String showString() {
        return value.toString();
    }
}
