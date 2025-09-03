public class IntegerDataItem extends DataItem{
    public final Integer value;

    public IntegerDataItem(Integer value) {
        super("Integer");
        this.value = value;
    }

    @Override
    public String showString() {
        return value.toString();
    }
}
