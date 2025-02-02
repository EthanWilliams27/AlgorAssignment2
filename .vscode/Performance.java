import java.io.FileWriter;
import java.io.IOException;

public class Performance {

    public static void main(String[] args) {
        SortingAlgorithm bubbleSort = new BubbleSort();
        SortingAlgorithm quickSort = new QuickSort();
        SortingAlgorithm insertionSort = new InsertionSort();
        SortingAlgorithm mergeSort = new MergeSort();
        SortingAlgorithm selectionSort = new SelectionSort();
        SortingAlgorithm shellSort = new ShellSort();

        Tester bubbleTester = new Tester(bubbleSort);
        Tester quickTester = new Tester(quickSort);
        Tester insertionTester = new Tester(insertionSort);
        Tester mergeTester = new Tester(mergeSort);
        Tester selectionTester = new Tester(selectionSort);
        Tester shellTester = new Tester(shellSort);

    
        int[] sizes = {100, 500, 1000, 2000, 5000, 10000, 20000, 75000, 150000};

        String outputFile = "sorting_performance_report.txt";


        try (FileWriter writer = new FileWriter(outputFile)) {
            writer.write("Sorting Performance Comparison\n");
            writer.write("\n\n");

        
            for (int size : sizes) {
                writer.write("\nTesting size " + size + " elements:\n");

             
                writer.write("Bubble Sort:\n");
                bubbleTester.testToFile(20, size, writer);
                writer.write("Quick Sort:\n");
                quickTester.testToFile(20, size, writer);
                writer.write("Insertion Sort:\n");
                insertionTester.testToFile(20, size, writer);
                writer.write("Merge Sort:\n");
                mergeTester.testToFile(20, size, writer);
                writer.write("Selection Sort:\n");
                selectionTester.testToFile(20, size, writer);
                writer.write("Shell Sort:\n");
                shellTester.testToFile(20, size, writer);
            }

            System.out.println("Performance report generated successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while generating the performance report.");
            e.printStackTrace();
        }
    }
}
