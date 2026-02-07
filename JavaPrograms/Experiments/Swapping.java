class Swapping {
    public static void main(String[] args) {
        int a = 5, b = 10, temp;

        System.out.println("Before Swapping:");
        System.out.printf("a = %d%n", a);
        System.out.printf("b = %d%n", b);

        temp = a;
        a = b;
        b = temp;

        System.out.println("After Swapping:");
        System.out.printf("a = %d%n", a);
        System.out.printf("b = %d%n", b);
    }
}