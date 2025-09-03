public class Main {
    public static void main(String[] args) {
        Dataset dataset = new Dataset("src/data/simple.csv");

        dataset.loadFromCSV();
        dataset.printInfo();
    }
}