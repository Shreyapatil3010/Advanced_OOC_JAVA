class MergeArrays {
public static void main(String[] args) {
int[] a = {1, 3, 5};
int[] b = {2, 4, 6};
int[] c = new int[6];
System.out.println("First Array:");
for (int i = 0; i < 3; i++)
    System.out.print(a[i] + " ");
System.out.println("\nSecond Array:");
for (int i = 0; i < 3; i++)
    System.out.print(b[i] + " ");
int k = 0;
for (int i = 0; i < 3; i++)
    c[k++] = a[i];
for (int i = 0; i < 3; i++)
    c[k++] = b[i];
System.out.println("\nMerged Array:");
for (int i = 0; i < 6; i++)
    System.out.print(c[i] + " ");
    }
}