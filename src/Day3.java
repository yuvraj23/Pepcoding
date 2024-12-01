public class Day3 {

    // Precondition: n1 (minuend) is always greater than or equal to n2 (subtrahend).
    public static void subtractInBase(int minuend, int subtrahend, int base) {
        int borrow = 0;        // Tracks any borrow required for the current place.
        int result = 0;        // Accumulates the final result in the given base.
        int placeValue = 1;    // Multiplier for placing digits in the correct decimal place.

        // Repeat until there are no more digits left in n1.
        while (minuend > 0) {
            // Extract the current digit from the minuend and subtrahend.
            int minuendDigit = minuend % 10;
            int subtrahendDigit = subtrahend % 10;

            // Move to the next higher place in both minuend and subtrahend.
            minuend /= 10;
            subtrahend /= 10;

            // Calculate the difference for the current place, adjusting for any borrow.
            int difference = minuendDigit - borrow - subtrahendDigit;

            // If the result is negative, adjust by borrowing from the next higher place.
            if (difference < 0) {
                difference += base;
                borrow = 1;  // Set borrow for the next higher place.
            } else {
                borrow = 0;  // Reset borrow if no borrowing is needed.
            }

            // Add the computed difference to the result at the correct place value.
            result += difference * placeValue;
            placeValue *= 10;  // Move to the next decimal place.
        }

        // Print the final result in the given base.
        System.out.println(result);
    }

    // Multiplies two numbers in a given base
    public static void anyBaseMultiplication(int n1, int n2, int base) {
        int resultSum = 0;   // To accumulate the results of partial multiplications
        int placeValueMultiplier = 1;   // Tracks the place value in the result (units, tens, hundreds...)

        // Loop through each digit in n2, starting from the rightmost digit
        while (n2 > 0) {
            int lastDigitOfN2 = n2 % 10;    // Extract the last digit of n2
            int partialProduct = multiplyWithSingleDigit(n1, lastDigitOfN2, base);   // Get partial product for this digit
            resultSum = addInBase(resultSum, partialProduct * placeValueMultiplier, base);  // Add partial product to result
            n2 /= 10;   // Remove the last digit of n2
            placeValueMultiplier *= 10;   // Move to the next place value
        }

        System.out.println(resultSum);    // Print the final result
    }

    // Multiplies a number by a single digit in a given base
    private static int multiplyWithSingleDigit(int number, int singleDigit, int base) {
        int carry = 0;      // Holds the carry-over for each multiplication step
        int result = 0;     // Accumulates the multiplication result in the correct base
        int placeValue = 1; // Tracks the place value of the result (units, tens, etc.)

        // Loop through each digit in the number, starting from the rightmost
        while (number > 0 || carry > 0) {
            int lastDigitOfNumber = number % 10;    // Extract the last digit of the number
            int product = lastDigitOfNumber * singleDigit + carry;  // Multiply and add any carry from the last step
            carry = product / base;   // Update carry for the next iteration
            result += (product % base) * placeValue;    // Add the product's digit (in base) to the result
            number /= 10;   // Move to the next digit
            placeValue *= 10;   // Update place value for the next digit
        }

        return result;   // Return the final product in the given base
    }

    // Adds two numbers in a given base
    private static int addInBase(int n1, int n2, int base) {
        int carry = 0;   // Holds the carry-over for each addition step
        int placeValue = 1;   // Tracks the place value in the result (units, tens, etc.)
        int sumResult = 0;    // Accumulates the sum result in the correct base

        // Loop through each digit of n1 and n2, starting from the rightmost digit
        while (n1 > 0 || n2 > 0 || carry > 0) {
            int lastDigitOfN1 = n1 % 10;   // Extract the last digit of n1
            int lastDigitOfN2 = n2 % 10;   // Extract the last digit of n2
            int digitSum = lastDigitOfN1 + lastDigitOfN2 + carry;   // Sum the digits and the carry
            carry = digitSum / base;   // Update carry for the next iteration
            sumResult += (digitSum % base) * placeValue;   // Add the sum's digit (in base) to the result
            n1 /= 10;   // Move to the next digit of n1
            n2 /= 10;   // Move to the next digit of n2
            placeValue *= 10;   // Update place value for the next digit
        }

        return sumResult;   // Return the final sum in the given base
    }

    public static void anyBaseAddition(int n1,int n2,int base){
        int carry=0;
        int mul=1;
        int total=0;
        while(n1>0 || n2>0 || carry >0){

            int d1=n1%10;
            n1=n1/10;

            int d2=n2%10;
            n2=n2/10;

            int digitSum=(d1+d2+carry)%base;
            digitSum*=mul;
            carry=(d1+d2+carry)/base;

            total=total+digitSum;
            mul*=10;

        }

    }

    public static void anyBaseToDecimal(int number, int base){
        int mul = 0;  // Exponent for base power
        int ans = 0;  // This will hold the final result
        while (number > 0) {
            int rem = number % 10;  // Get the rightmost digit
            ans += (rem * (int) Math.pow(base, mul));  // Add the digit * (base^position)
            number /= 10;  // Remove the rightmost digit
            mul++;  // Move to the next digit position
        }
        System.out.println(ans);  // Print the result in decimal
    }

    public static void decimalToAnyBase(int decimalNumber, int base) {
        int ans = 0;
        int mul = 1;

        while (decimalNumber > 0) {
            int rem = decimalNumber % base;
            decimalNumber /= base;
            ans += rem * mul;  // Add the remainder multiplied by the current multiplier
            mul *= 10;  // Shift to the next place value
        }

        System.out.println("Result in base " + base + ": " + ans);
    }

    public static void pythagoreanTriplet(int n1, int n2, int n3) {
        // Determine the maximum value to be treated as the hypotenuse
        int max = Math.max(n3, Math.max(n1, n2));
        int a, b, c;

        // Assign a, b, c based on which one is the largest
        if (max == n1) {
            c = n1;
            a = n2;
            b = n3;
        } else if (max == n2) {
            c = n2;
            a = n1;
            b = n3;
        } else {
            c = n3;
            a = n1;
            b = n2;
        }

        // Check if the sum of squares of a and b equals the square of c
        if (a * a + b * b == c * c) {
            System.out.println(a + "^2 + " + b + "^2 = " + c + "^2");
            System.out.println("The numbers " + a + ", " + b + ", and " + c + " form a Pythagorean triplet.");
        } else {
            System.out.println("The numbers " + n1 + ", " + n2 + ", and " + n3 + " do not form a Pythagorean triplet.");
        }
    }

    public static void benjaminBulb(int n) {
        // Iterate over integers starting from 1
        for (int i = 1; i * i <= n; i++) {
            // Print the perfect square of i
            System.out.println(i * i);
        }
    }

    public static void primeFactorization(int number) {
        // Check divisibility by 2 first
        while (number % 2 == 0) {
            System.out.println(2);
            number /= 2;
        }

        // Check divisibility by odd numbers starting from 3
        for (int div = 3; div * div <= number; div += 2) {
            while (number % div == 0) {
                System.out.println(div);
                number /= div;
            }
        }

        // If number is still greater than 2, it must be prime
        if (number > 2) {
            System.out.println(number);
        }
    }

    public static void gcdAndLcd(int n1, int n2) {
        // Store the original values to compute the LCM correctly later
        int originalN1 = n1, originalN2 = n2;

        // Calculate GCD using Euclidean algorithm
        while (n1 != 0) {
            int r = n2 % n1;
            n2 = n1;
            n1 = r;
        }

        // Now n2 is the GCD of the original n1 and n2
        int gcd = n2;

        // Calculate LCM using the formula: LCM(a, b) = (a * b) / GCD(a, b)
        int lcm = (originalN1 * originalN2) / gcd;

        // Output the results
        System.out.println("GCD: " + gcd);
        System.out.println("LCM: " + lcm);
    }

}
