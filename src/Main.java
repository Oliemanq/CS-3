public class Main {
    public static void main(String[] args) {
        Dataset dataset = new Dataset("src/data/breast-cancer-wisconsin.csv");

        dataset.loadFromCSV();
        dataset.printInfo();
    }
}