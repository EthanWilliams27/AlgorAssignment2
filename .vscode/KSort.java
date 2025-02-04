public class KSort {

    public static void generateKSorted(int[] my_array) {
        int k = 10;
        

        for (int gap = k; gap > 0; gap /= 2) {
            for (int i = gap; i < my_array.length; i++) {

                int current = my_array[i];
                int j = i;
                
                while (j >= gap && my_array[j - gap] > current) {
                    my_array[j] = my_array[j - gap];
                    j -= gap;
                }
             
                my_array[j] = current;
            }
        }
    }
    public static void main(String[] args) {
        int[] my_array = { 1, 4, 2, 3, 5, 7, 6, 8, 10, 9 };
        
        System.out.println("Original Array:");
        for (int num : my_array) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        generateKSorted(my_array);
        
        System.out.println("10-Sorted Array:");
        for (int num : my_array) {
            System.out.print(num + " ");
        }
    }
}
