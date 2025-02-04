import java.io.FileWriter;
import java.io.IOException;

public class KSortTester {
    private SortingAlgorithm algorithm;

    public KSortTester(SortingAlgorithm algorithm) {
        this.algorithm = algorithm;
    }

    // Run the sorting algorithm and write the runtime to a file
    public void testToFile(int[] data, int numTests, FileWriter writer) throws IOException {
        long totalTime = 0;
        
        // Run the test `numTests` times to get an average time
        for (int i = 0; i < numTests; i++) {
            int[] testData = data.clone();  // Clone the data to avoid sorting the same array repeatedly
            long startTime = System.nanoTime();
            algorithm.sorty(testData);  // Sort the data using the algorithm
            long endTime = System.nanoTime();
            totalTime += (endTime - startTime);
        }

        // Write the average time to the file
        long avgTime = totalTime / numTests;
        writer.write("Average time for " + algorithm.getClass().getSimpleName() + ": " + avgTime + " ns\n");
    }
}
