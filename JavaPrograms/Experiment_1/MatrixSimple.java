import java.util.Scanner;

class MatrixSimple {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[][] A = new int[2][2];
        int[][] B = new int[2][2];
        int[][] C = new int[2][2];

        System.out.println("Enter Matrix A elements:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                A[i][j] = sc.nextInt();

        System.out.println("Enter Matrix B elements:");
        for (int i = 0; i < 2; i++)
            for (int j = 0; j < 2; j++)
                B[i][j] = sc.nextInt();

        System.out.println("1.Addition");
        System.out.println("2.Multiplication");
        System.out.println("3.Transpose of Matrix A");
        System.out.print("Enter your choice: ");
        int ch = sc.nextInt();

        switch (ch) {

            case 1: // Addition
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++)
                        C[i][j] = A[i][j] + B[i][j];
                break;

            case 2: // Multiplication
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++) {
                        C[i][j] = 0;
                        for (int k = 0; k < 2; k++)
                            C[i][j] += A[i][k] * B[k][j];
                    }
                break;

            case 3: // Transpose
                for (int i = 0; i < 2; i++)
                    for (int j = 0; j < 2; j++)
                        C[j][i] = A[i][j];
                break;

            default:
                System.out.println("Wrong Choice");
        }

        System.out.println("Result Matrix:");
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++)
                System.out.print(C[i][j] + " ");
            System.out.println();
        }
    }
}