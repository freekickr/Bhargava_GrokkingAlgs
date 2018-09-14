package III_Recursion;

/* A ways to show a recursion methods. */

public class RecCountdown {
    public static void main(String[] args) {
//        basicInfRecursion(5);
//        basicRecursion(5);
    }

    //Simple infinite countdown
    private static void basicInfRecursion(int num) {
        System.out.print(num + " ");
        basicInfRecursion(num-1);
    }

    //Simple recursion with a final state verification
    private static void basicRecursion(int num) {
        System.out.print(num + " ");
        if (num == 0) {
            return;
        } else
            basicRecursion(num - 1);
    }

}
