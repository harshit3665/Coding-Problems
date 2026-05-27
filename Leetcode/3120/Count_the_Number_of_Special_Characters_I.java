import java.util.HashSet;

public class Count_the_Number_of_Special_Characters_I {

    public static int count(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }
        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char upper = Character.toUpperCase(ch);
            if (set.contains(ch) && set.contains(upper)) {
                count++;
            }
        }
        return count;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s = sc.nextInt();
        System.out.println(count(s));
    }
}
