class PrimeCheck {
public static void main(String[] args) {
if (args.length == 0) {
    System.out.println("Please enter a number");
            return;
        }
int n = Integer.parseInt(args[0]);
int flag = 0;
if (n <= 1) {
    flag = 1;
        }
for (int i = 2; i <= n / 2; i++) {
    if (n % i == 0) {
       flag = 1;
         break;
            }
        }
if (flag == 0)
      System.out.println("Number is Prime");
 else
      System.out.println("Number is Not Prime");
    }
}