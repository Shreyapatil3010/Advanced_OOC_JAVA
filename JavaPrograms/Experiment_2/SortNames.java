class SortNames {
    public static void main(String[] args) {

        String[] names = {
            "Radha", "Emma", "Shreya", "Max", "Kaif",
            "Anna", "Nexa", "Pure", "Viky", "Sam"
        };

        String temp;

        for (int i = 0; i < names.length; i++) {
            for (int j = i + 1; j < names.length; j++) {
                if (names[i].compareTo(names[j]) > 0) {
                    temp = names[i];
                    names[i] = names[j];
                    names[j] = temp;
                }
            }
        }

        System.out.println("Names in Alphabetical Order:");
        for (String name : names)
            System.out.println(name);
    }
}