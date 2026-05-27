import javax.sound.midi.SysexMessage;
import java.util.Scanner;

public class Jump_Game_VII {

    public static boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        if (s.charAt(n - 1) == '1') return false;

        boolean[] dp = new boolean[n];
        dp[0] = true;

        int reachable = 0; // count of valid positions in window

        for (int i = 1; i < n; i++) {

            if (i >= minJump && dp[i - minJump]) {
                reachable++;
            }

            if (i > maxJump && dp[i - maxJump - 1]) {
                reachable--;
            }

            dp[i] = (reachable > 0) && s.charAt(i) == '0';
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();
        int minJump = sc.nextInt();
        int maxJump = sc.nextInt();

        System.out.println(canReach(s, minJump, maxJump));
    }
}
