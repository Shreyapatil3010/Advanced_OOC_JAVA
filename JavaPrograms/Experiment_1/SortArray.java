class SortArray {
public static void main(String[] args) {
int[] a = {45, 12, 78, 34, 23, 9, 56, 10, 89, 1};
int temp;
System.out.println("Unsorted Array:");
for (int i = 0; i < 10; i++) {
   System.out.print(a[i] + " ");
        }
for (int i = 0; i < 10; i++) {
     for (int j = i + 1; j < 10; j++) {
       if (a[i] > a[j]) {
           temp = a[i];
           a[i] = a[j];
           a[j] = temp;
                }
            }
        }
System.out.println("\nSorted Array in Ascending Order:");
    for (int i = 0; i < 10; i++) {
        System.out.print(a[i] + " ");
        }
    }
}