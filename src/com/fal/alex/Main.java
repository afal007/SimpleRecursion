package com.fal.alex;

import static java.lang.System.out;

public class Main {

    public static void main(String[] args) {
        for(int i = 0; i < 0; i++) {
//            out.println(factorial(i));
//            out.println(bunnyEars(i));
//            out.println(fibonacci(i));
//            out.println(bunnyEarsModified(i));
            out.println(triangle(i));
        }

//        out.println(sumDigits(12));
//        out.println(count7(0));
//        out.println(count8(888188));
//        out.println(powerN(2, 3));
//        out.println(countX("xxhixx0x1x"));
        out.println(countHi("xxihhhihixhix0x1x"));
    }

    /**
     * Given n of 1 or more, return the factorial of n,
     * which is n * (n-1) * (n-2) ... 1.
     * Compute the result recursively (without loops).
     *
     * @param n number
     * @return factorial of number
     */
    private static int factorial(int n) {
        if(n == 0 || n == 1)
            return 1;

        return  n * factorial(n-1);
    }

    /**
     * We have a number of bunnies and each bunny has two big floppy ears.
     * We want to compute the total number of ears across all the bunnies recursively
     * without loops or multiplication).
     *
     * @param n number of bunnies     ()()
     * @return number of ears        ('.')
     *                              (")(")
     */
    private static int bunnyEars(int n) {
        if(n == 0)
            return 0;

        return 2 + bunnyEars(n - 1);
    }

    /**
     * The fibonacci sequence is a famous bit of mathematics, and it happens to have a recursive definition.
     * The first two values in the sequence are 0 and 1 (essentially 2 base cases).
     * Each subsequent value is the sum of the previous two values,
     * so the whole sequence is: 0, 1, 1, 2, 3, 5, 8, 13, 21 and so on.
     * Define a recursive fibonacci(n) method that returns the nth fibonacci number,
     * with n=0 representing the start of the sequence.
     *
     * @param n fibonacci number number
     * @return nth fibonacci number
     */
    private static int fibonacci(int n) {
        if(n == 0)
            return 0;
        if(n == 1)
            return 1;

        return fibonacci(n - 1) + fibonacci(n - 2);
    }

    /**
     * We have bunnies standing in a line, numbered 1, 2, ...
     * The odd bunnies (1, 3, ..) have the normal 2 ears.
     * The even bunnies (2, 4, ..) we'll say have 3 ears, because they each have a raised foot.
     * Recursively return the number of "ears" in the bunny line 1, 2, ... n (without loops or multiplication).
     *
     * @param n number of bunnies   ()()   ()()()   ()()
     * @return number of ears      ('.')   ('.')   ('.')
     *                            (")(")  (")(")  (")(")
     */
    private static int bunnyEarsModified(int n) {
        if(n == 0)
            return 0;

        return 2 + ((n % 2) == 0 ? 1 : 0) + bunnyEarsModified(n - 1);
    }

    /**
     * We have triangle made of blocks.
     * The topmost row has 1 block, the next row down has 2 blocks, the next row has 3 blocks, and so on.
     * Compute recursively (no loops or multiplication) the total number of blocks in such a
     * triangle with the given number of rows.
     *
     * @param n number of triangles
     * @return number of blocks
     */
    private static int triangle(int n) {
        if(n == 0)
            return 0;

        return n + triangle(n - 1);
    }

    /**
     * Given a non-negative int n, return the sum of its digits recursively (no loops).
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
     * while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     *
     * @param n
     * @return
     */
    private static int sumDigits(int n) {
        if(n == 0)
            return 0;

        return n % 10 + sumDigits(n / 10);
    }

    /**
     * Given a non-negative int n, return the count of the occurrences of 7 as a digit,
     * so for example 717 yields 2. (no loops).
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
     * while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     *
     * @param n number
     * @return number of 7 in number
     */
    private static int count7(int n) {
        if(n == 0)
            return 0;

        return ((n % 10) == 7 ? 1 : 0) + count7(n / 10);
    }

    /**
     * Given a non-negative int n, compute recursively (no loops) the count of the occurrences of 8 as a digit,
     * except that an 8 with another 8 immediately to its left counts double, so 8818 yields 4.
     * Note that mod (%) by 10 yields the rightmost digit (126 % 10 is 6),
     * while divide (/) by 10 removes the rightmost digit (126 / 10 is 12).
     *
     * @param n number
     * @return number of 8
     */
    private static int count8(int n) {
        //TODO: doesn't work :(
        if(n == 0)
            return 0;

        if(n % 10 == 8) {
            if (n % 100 == 8) {
                return 2 + count8(n / 10);
            } else {
                return 1 + count8(n / 10);
            }
        } else
            return count8(n / 10);
    }

    /**
     * Given base and n that are both 1 or more, compute recursively (no loops)
     * the value of base to the n power, so powerN(3, 2) is 9 (3 squared).
     *
     * @param base base
     * @param power power
     * @return base to power
     */
    private static int powerN(int base, int power) {
        if(power == 0)
            return 1;

        return base * powerN(base, power - 1);
    }

    /**
     * Given a string, compute recursively (no loops) the number of lowercase 'x' chars in the string.
     * @param str string
     * @return number of x
     */
    private static int countX(String str) {
        if("".equals(str))
            return 0;

        return (str.endsWith("x") ? 1 : 0) + countX(str.substring(0, str.length() - 1));
    }

    /**
     * Given a string, compute recursively (no loops) the number of times lowercase "hi" appears in the string.
     * @param str string
     * @return number of hi
     */
    private static int countHi(String str) {
        if("".equals(str))
            return 0;

        return (str.endsWith("hi") ?
                1 + countHi(str.substring(0, str.length() - 2)) :
                countHi(str.substring(0, str.length() - 1)));
    }
}
