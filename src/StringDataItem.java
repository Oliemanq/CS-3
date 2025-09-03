public class StringDataItem extends DataItem{
    public final String value;

    public StringDataItem(String value) {
        super("String");
        this.value = value;
    }

    @Override
    public String findType() {
        try {
            Integer.parseInt(value);
            System.out.println("Parsed as Integer: - " + value);
            return "Integer";

        } catch (NumberFormatException e) {
            try {
                Double.parseDouble(value);
                System.out.println("Parsed as Double: -- " + value);
                return "Double";

            } catch (NumberFormatException ex) {
                System.out.println("Parsed as String: --- " + value);
                return "String";
            }
        }
    }

    public IntegerDataItem toInt() {
        return new IntegerDataItem(Integer.parseInt(value));
    }
    public DoubleDataItem toDouble() {
        return new DoubleDataItem(Double.parseDouble(value));
    }



    @Override
    public String showString() {
        return value;
    }
}
