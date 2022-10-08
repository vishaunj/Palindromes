/*Vishaun Jones
* 2-25-2022
* Professor Silei Song
* Assignment2 - Palindromes
*/
import java.util.Scanner;
import java.lang.StringBuilder;

/*ABOUT
*   */

public class Palindromes {

    //Method takes each user input from userStringCopy, reverses the user input and checks for equality between the original string and the reversed string.
    //It returns either true or false to the main.
    public static boolean isPalin(String userString) {
        StringBuilder primeReversed = new StringBuilder(userString).reverse();

        if (userString.equals(primeReversed.toString())) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        //Variable Declarations
        Scanner in = new Scanner(System.in);
        boolean check;

        //Prompt for user to enter number of strings they will enter
        System.out.println("Enter the number of strings:");
        int stringNum = in.nextInt();

        //String Arrays and String Builder Declarations
        String[] userStrings = new String[stringNum]; //Array to collect user strings. Size initiated by user input of number of strings.
        String[] userStringsCopy = new String[stringNum]; //Array to collect strings from UserStrings that have had spaces removed and letter cases all made the same.
        StringBuilder result = new StringBuilder(50); //A result string that will be updated with every palindrome entered by the user.

        //Prompt for user to enter strings
        System.out.println("Enter the strings:");

        //Loop to update the userStrings array with user inputs.
        in.nextLine();
        for (int i = 0; i < stringNum; i++) {
            userStrings[i] = in.nextLine();
        }

        //Loop to copy userStrings array, changing the string to lower case and removing their spaces
        for (int i = 0; i < stringNum; ++i) {
            String holder = userStrings[i];
            holder = holder.replace(" ","");
            holder = holder.toLowerCase();
            userStringsCopy[i] = holder;
        }

        //Loop to check the palindromic status of the strings of the array, and update the result string.
        for (int i = 0; i < stringNum; ++i) {
            check = isPalin(userStringsCopy[i]); //Call to isPalin method that will check if the lower case and spaces removed string is a palindrome.

            //If true is returned the original string will append to the result string.
            if (check == true) {
                result.append(userStrings[i]);
                result.append("; ");
            }
        }

        //Removes the extra ';' symbol from the end.
        result.deleteCharAt(result.length() - 2);

        //Prints the result string that has collected all the palindromes.
            System.out.println("The palindromes are: " + result);
    }
}
