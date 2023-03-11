package Problem_6996;

import java.util.Scanner;

public class Main {

    private static boolean solveAnagrams(String first, String second ) {
        /* ------------------- INSERT CODE HERE --------------------
         *
         * Your code should return true if the two strings are anagrams of each other.
         *
         * */
        int[] first_ = new int[26];
        int[] second_ = new int[26];

        for(int i = 0; i<first.length(); i++) 
            first_[first.charAt(i)-'a']++;
        for(int i = 0; i<second.length(); i++) 
            second_[second.charAt(i)-'a']++;
        for(int i = 0; i<26; i++) if(first_[i] != second_[i]) return false;
        return true;

        /* -------------------- END OF INSERTION --------------------*/
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numTests = sc.nextInt();

        for (int i = 0; i < numTests; i++) {
            String first = sc.next().toLowerCase();
            String second = sc.next().toLowerCase();

            System.out.println(first + " & " + second + " are " + (solveAnagrams(first, second) ? "anagrams." : "NOT anagrams."));
        }
    }
}
