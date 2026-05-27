# 1871. Jump Game VII

> Difficulty: Medium  
> Topics: String, Dynamic Programming, Sliding Window

---

# Problem Statement

You are given a binary string `s` and two integers `minJump` and `maxJump`.

Initially, you are standing at index `0`, where:

```text
s[0] == '0'
```

You can move from index `i` to index `j` if:

```text
i + minJump <= j <= min(i + maxJump, s.length - 1)
```

and:

```text
s[j] == '0'
```

Return:

```text
true
```

if you can reach the last index of the string, otherwise return:

```text
false
```

---

# Examples

## Example 1

### Input

```text
s = "011010"
minJump = 2
maxJump = 3
```

### Output

```text
true
```

### Explanation

Possible jumps:

```text
0 -> 3 -> 5
```

---

## Example 2

### Input

```text
s = "01101110"
minJump = 2
maxJump = 3
```

### Output

```text
false
```

---

# Constraints

```text
2 <= s.length <= 10^5
s[i] is either '0' or '1'
s[0] == '0'
1 <= minJump <= maxJump < s.length
```

---

# Approach

## Sliding Window + Dynamic Programming

We use a DP array:

```text
dp[i] = true
```

if index `i` is reachable.

Instead of checking every previous index manually,
we maintain a sliding window count called:

```text
reachable
```

This stores how many reachable indices exist
inside the valid jump range.

This optimizes the solution from:

```text
O(n * maxJump)
```

to:

```text
O(n)
```

---

# Logic

For every index `i`:

## Add New Reachable Index

If:

```java
i >= minJump && dp[i - minJump]
```

then this index enters the sliding window.

---

## Remove Old Reachable Index

If:

```java
i > maxJump && dp[i - maxJump - 1]
```

then this index leaves the window.

---

## Current Position Reachability

Current index is reachable if:

```java
reachable > 0 && s.charAt(i) == '0'
```

---

# Dry Run

## Input

```text
s = "011010"
minJump = 2
maxJump = 3
```

## DP Processing

| Index | Character | Reachable Window Count | dp[i] |
|------|------|------|------|
| 0 | 0 | - | true |
| 1 | 1 | 0 | false |
| 2 | 1 | 1 | false |
| 3 | 0 | 1 | true |
| 4 | 1 | 1 | false |
| 5 | 0 | 1 | true |

Final Answer:

```text
true
```

---

# Java Solution

```java
import java.util.Scanner;

public class MinmaxJump {

    public static boolean canReach(String s, int minJump, int maxJump) {

        int n = s.length();

        if (s.charAt(n - 1) == '1')
            return false;

        boolean[] dp = new boolean[n];

        dp[0] = true;

        int reachable = 0;

        for (int i = 1; i < n; i++) {

            // Add new index entering the window
            if (i >= minJump && dp[i - minJump]) {
                reachable++;
            }

            // Remove old index leaving the window
            if (i > maxJump && dp[i - maxJump - 1]) {
                reachable--;
            }

            // Mark current index reachable
            dp[i] =
                (reachable > 0) &&
                s.charAt(i) == '0';
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int minJump = sc.nextInt();

        int maxJump = sc.nextInt();

        System.out.println(
            canReach(s, minJump, maxJump)
        );
    }
}
```

---

# Complexity Analysis

## Time Complexity

```text
O(n)
```

Each index is processed once.

---

## Space Complexity

```text
O(n)
```

For the DP array.

---
