import java.io.FileWriter;
import java.io.IOException;

public class KSortPerformance {

    public static void main(String[] args) {
        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingAlgorithm quickSort = new QuickSort();
        SortingAlgorithm insertionSort = new InsertionSort();
        SortingAlgorithm mergeSort = new MergeSort();
        SortingAlgorithm selectionSort = new SelectionSort();
        SortingAlgorithm shellSort = new ShellSort();

        KSortTester bubbleTester = new KSortTester(bubbleSort);
        KSortTester quickTester = new KSortTester(quickSort);
        KSortTester insertionTester = new KSortTester(insertionSort);
        KSortTester mergeTester = new KSortTester(mergeSort);
        KSortTester selectionTester = new KSortTester(selectionSort);
        KSortTester shellTester = new KSortTester(shellSort);

        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        String outputFile = "KSorting_performance_report.txt";

        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Sorting Performance Comparison - Using 10-Sorted Data\n");
            writer.write("\n\n");

        
            for (int size : sizes) {
                writer.write("\nTesting size " + size + " elements:\n");

              
                int[] kSortedData = generateKSortedData(size);

                writer.write("Bubble Sort:\n");
                bubbleTester.testToFile(kSortedData, 20, writer);
                writer.write("Quick Sort:\n");
                quickTester.testToFile(kSortedData, 20, writer);
                writer.write("Insertion Sort:\n");
                insertionTester.testToFile(kSortedData, 20, writer);
                writer.write("Merge Sort:\n");
                mergeTester.testToFile(kSortedData, 20, writer);
                writer.write("Selection Sort:\n");
                selectionTester.testToFile(kSortedData, 20, writer);
                writer.write("Shell Sort:\n");
                shellTester.testToFile(kSortedData, 20, writer);
            }

            System.out.println("Performance report generated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the performance report.");
            e.printStackTrace();
        }
    }
    public static int[] generateKSortedData(int size) {
        int[] data = new int[size];
        
        
        for (int i = 0; i < size; i++) {
            data[i] = (int)(Math.random() * 1000);
        }

        for (int i = 10; i < size; i++) {
            int j = i;
            while (j > 10 && data[j] < data[j - 10]) {
                int temp = data[j];
                data[j] = data[j - 10];
                data[j - 10] = temp;
                j -= 10;
            }
        }
        return data;
    }
}
