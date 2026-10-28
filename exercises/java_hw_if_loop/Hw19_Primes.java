/** 19. 100～300 的素数。 */
public class Hw19_Primes {
    public static void main(String[] args) {
        for (int n = 100; n <= 300; n++) {
            if (isPrime(n)) {
                System.out.print(n + " ");
            }
        }
        System.out.println();
    }

    static boolean isPrime(int n) {
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
