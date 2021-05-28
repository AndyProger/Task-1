import java.util.Scanner;

class Task1 {

    static int count = 0;

    public static void correctExpression(int number){
        // data validation
        if (number <= 0) {
            System.out.println("The number must be greater than 0!");
            return;
        }
        // recursive function
        correctExpressionR(number,0,0,"");
    }

    public static void correctExpressionR(int number, int open, int close, String ans) {

        /*
         *  number - n opening and n closing parentheses
         *  open - n opening parentheses
         *  close - n closing parentheses
         *  ans - string with correct bracketed expression
         */

        // base case
        if ((open + close) == (2 * number)) {
            System.out.println(ans);
            // counting expressions
            count++;
            return;
        }
        if (open < number) {
            // add opening bracket and recursive call
            correctExpressionR(number, open + 1, close, ans + '(');
        }
        if (open > close) {
            // add closing bracket and recursive call
            correctExpressionR(number, open, close + 1, ans + ')');
        }
    }

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Count of brackets: ");
        // get a number from the user
        int number = scanner.nextInt();

        correctExpression(number);
        System.out.println("Answer: " + count);
    }
}
