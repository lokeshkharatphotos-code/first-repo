import java.util.Scanner;

public class OptimalStorageOnTape {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of files: ");
        int n = sc.nextInt();

        int[] length = new int[n];

        System.out.println("Enter length of each file:");
        for (int i = 0; i < n; i++) {
            length[i] = sc.nextInt();
        }

        // Sort the files in ascending order (Selection Sort)
        for (int i = 0; i <= n - 2; i++) {
            for (int j = i + 1; j <= n - 1; j++) {
                if (length[i] > length[j]) {
                    int temp = length[i];
                    length[i] = length[j];
                    length[j] = temp;
                }
            }
        }

        int total = 0;
        int retrieval = 0;

        // Calculate total retrieval time
        for (int i = 0; i < n; i++) {
            retrieval = retrieval + length[i];
            total = total + retrieval;
        }

        double average = (double) total / n;

        // Print results
        System.out.print("Optimal order: ");
        for (int i = 0; i < n; i++) {
            System.out.print(length[i] + " ");
        }
        System.out.println();

        System.out.println("Total Retrieval Time: " + total);
        System.out.println("Average Retrieval Time: " + average);

        sc.close();
    }
}