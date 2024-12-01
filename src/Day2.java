public class Day2 {
    public static void main(String[] args) {
        inverseADigitByPostion(51342);
    }

    public static void inverseADigitByPostion(int number){
        int reverseNumber=0;
        int postion=1;
        while(number>0){
            int r=number%10;
            reverseNumber+=((int)Math.pow(10,r-1)*postion);
            number/=10;
            postion++;

        }
        System.out.println(reverseNumber);
    }

    // Method to print the digits of a number in reverse order
    public static void reverseANumber(int number) {
        // Loop through each digit from last to first
        while (number > 0) {
            int lastDigit = number % 10;  // Extract the last digit
            System.out.println(lastDigit); // Print the last digit
            number /= 10;                  // Remove the last digit from the number
        }
    }

    // Method to rotate a number by 'r' positions
    public static void rotateNumber(int number, int rotations) {
        int digitCount = 0;               // Count of digits in the number
        int temp = number;                // Temporary variable for counting digits

        // Count the total digits in the number
        while (temp > 0) {
            digitCount++;
            temp /= 10;
        }

        // Adjust rotations if greater than the number of digits
        rotations = rotations % digitCount;
        if (rotations < 0) {
            // If rotations is negative, adjust it to rotate in the correct direction
            rotations += digitCount;
        }

        int divisor = (int) Math.pow(10, digitCount - rotations); // Divider to separate rotated parts
        int leadingPart = number / divisor;                       // Part to be moved to the end
        int trailingPart = number % divisor;                      // Part that remains at the start

        // Shift the trailing part to make space for the leading part
        trailingPart = trailingPart * (int) Math.pow(10, rotations);
        int rotatedNumber = trailingPart + leadingPart;           // Combined rotated number

        System.out.println(number + " rotated by " + rotations + " is " + rotatedNumber);
    }

    // Method to print each digit in a number from left to right
    public static void printDigitsInNumber(int number) {
        int digitCount = 0;
        int temp = number;

        // Count the number of digits
        while (temp > 0) {
            digitCount++;
            temp /= 10;
        }

        int divisor = (int) Math.pow(10, digitCount - 1); // Divisor to extract the leftmost digit

        // Loop to extract each digit from left to right
        temp = number;
        while (divisor > 0) {
            int currentDigit = temp / divisor;      // Extract the current leading digit
            System.out.println(currentDigit);        // Print the current digit
            temp = temp % divisor;                  // Remove the printed digit from temp
            divisor /= 10;                          // Reduce divisor to move to the next digit
        }
    }

    // Method to count occurrences of a specific digit in a number
    public static void countADigit(int number, int targetDigit) {
        int count = 0;  // Counter for occurrences

        // Loop through each digit in the number
        while (number > 0) {
            int currentDigit = number % 10;         // Extract the last digit
            if (currentDigit == targetDigit) {      // Check if it matches the target digit
                count++;                            // Increment count if there's a match
            }
            number /= 10;                           // Remove the last digit from the number
        }
        System.out.println("Count of " + targetDigit + " is: " + count);
    }
}
