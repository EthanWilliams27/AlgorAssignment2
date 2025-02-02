import java.io.FileWriter;
import java.io.IOException;

public class Tester {

    private SortingAlgorithm sortingAlgorithm;

    public Tester(SortingAlgorithm sa) {
        this.sortingAlgorithm = sa;
    }

    
    public double singleTest(int size) {
      
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 100); 
        }

        long start = System.nanoTime();

        sortingAlgorithm.sorty(arr);

        long end = System.nanoTime();
        return (end - start) / 1_000_000.0; 
    }

  
    public void test(int iterations, int size) {
        double total = 0;

        for (int i = 0; i < iterations; i++) {
            total += singleTest(size);
        }

        double averageTime = total / iterations;
        System.out.println("Average time for sorting " + size + " elements: " + averageTime + " ms");
    }

    public void testToFile(int iterations, int size, FileWriter writer) throws IOException {
        double total = 0;

        for (int i = 0; i < iterations; i++) {
            total += singleTest(size);
        }

        double averageTime = total / iterations;
        writer.write("Average time for sorting " + size + " elements: " + averageTime + " ms\n");
    }
}

