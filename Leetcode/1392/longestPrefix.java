import java.util.Scanner;

class longestPrefix {

    public int longestPrefix(String s) {

        int n = s.length();
        int[] lps = new int[n];

        int len = 0;
        int i = 1;
int sum=-1;
        while (i < n) {

            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {

                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        for(int j=0;j<lps.length;j++){
            sum=sum+lps[j];
        }

     return sum;
    }

    public static void main(String[] args) {

        longestPrefix obj = new longestPrefix();
        Scanner sc=new Scanner(System.in);
        String s = sc.nextLine();

        int result = obj.longestPrefix(s);

        System.out.println("Longest Happy Prefix: " + result);
    }
}