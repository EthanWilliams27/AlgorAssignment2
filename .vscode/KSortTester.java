import java.io.FileWriter;
import java.io.IOException;
class KSortTester {
    private SortingAlgorithm algorithm;

    public KSortTester(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    public void testToFile(int[] data, int size, FileWriter writer) throws IOException {
        // Run the sorting algorithm once and measure the time
        int[] dataCopy = data.clone();  // Ensure sorting on the original data
        long startTime = System.nanoTime();
        algorithm.sorty(dataCopy);  // Sorting the data
        long endTime = System.nanoTime();

        // Calculate the time taken in milliseconds
        double timeMs = (endTime - startTime) / 1_000_000.0;

        // Write the result formatted with 12 decimal places
        writer.write(String.format("Average time for sorting %d elements: %.12f ms\n", size, timeMs));
    }
}