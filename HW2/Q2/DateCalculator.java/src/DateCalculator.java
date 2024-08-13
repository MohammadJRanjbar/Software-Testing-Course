public class DateCalculator {

    public static void main(String[] args) {
        // Example usage
        h(100, 1399);  // Adjust the values of x and y for testing
    }

    // Method to determine if a year is a leap year
    public static boolean isLeapYear(int year) {
        // Assuming a simple logic for the leap year check in the Persian calendar
        if ((year - 474) % 2820 % 128 == 0 || ((year - 474) % 2820 % 128) % 4 == 0) {
            return true;
        }
        return false;
    }

    public static void h(int x, int y) {
        // pre-cond: x, y >= 0
        if (x <= 6 * 31) {
            System.out.println((x / 31 + 1) + " " + (x % 31 + 1));
        } else {
            x -= 6 * 31;
            if (x <= 5 * 30) {
                System.out.println((7 + x / 30) + " " + (1 + x % 30));
            } else {
                x -= 5 * 30;
                boolean leap = isLeapYear(y);
                if (x <= 29) {
                    if (leap && x == 29) {
                        System.out.println(12 + " " + 30);
                    } else {
                        System.out.println(12 + " " + (1 + x));
                    }
                } else {
                    throw new RuntimeException("Invalid day count for the given year");
                }
            }
        }
    }
}
