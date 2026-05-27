# 3120. Count the Number of Special Characters I

> Difficulty: Easy  
> Topics: Hash Table, String

---

# Problem Statement

You are given a string `word`.

A letter is called **special** if it appears in both:

- lowercase form
- uppercase form

For example:

```text
'a' and 'A'
```

are considered one special character.

Return the number of special characters in `word`.

---

# Examples

## Example 1

### Input

```text
word = "aaAbcBC"
```

### Output

```text
3
```

### Explanation

Special characters are:

```text
a
b
c
```

because both lowercase and uppercase versions exist.

---

## Example 2

### Input

```text
word = "abc"
```

### Output

```text
0
```

### Explanation

No uppercase characters exist.

---

## Example 3

### Input

```text
word = "abBCab"
```

### Output

```text
1
```

### Explanation

Only:

```text
b
```

is special.

---

# Constraints

```text
1 <= word.length <= 50
word consists of only lowercase and uppercase English letters.
```

---

# Approach

## Using HashSet

We store every character of the string inside a:

```java
HashSet<Character>
```

This allows fast lookup in:

```text
O(1)
```

time.

Then we iterate from:

```text
'a' to 'z'
```

For every lowercase character:

1. Convert it to uppercase
2. Check whether both lowercase and uppercase exist in the set
3. If yes, increment the count

---

# Algorithm

## Step 1

Insert all characters into the HashSet.

---

## Step 2

Loop through all lowercase letters:

```java
for (char ch = 'a'; ch <= 'z'; ch++)
```

---

## Step 3

Convert current character to uppercase:

```java
char upper = Character.toUpperCase(ch);
```

---

## Step 4

Check:

```java
set.contains(ch) && set.contains(upper)
```

If true:

```java
count++
```

---

# Dry Run

## Input

```text
word = "aaAbcBC"
```

## HashSet

```text
[a, A, b, c, B, C]
```

## Checking Characters

| Lowercase | Uppercase | Exists? |
|------|------|------|
| a | A | Yes |
| b | B | Yes |
| c | C | Yes |

Count:

```text
3
```

---

# Java Solution

```java
import java.util.HashSet;
import java.util.Scanner;

public class Count_the_Number_of_Special_Characters_I {

    public static int count(String s) {

        HashSet<Character> set = new HashSet<>();

        // Store all characters
        for (char ch : s.toCharArray()) {
            set.add(ch);
        }

        int count = 0;

        // Check lowercase and uppercase pairs
        for (char ch = 'a'; ch <= 'z'; ch++) {

            char upper = Character.toUpperCase(ch);

            if (set.contains(ch) && set.contains(upper)) {
                count++;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        System.out.println(count(s));
    }
}
```

---

# Complexity Analysis

## Time Complexity

```text
O(n + 26)
```

Which simplifies to:

```text
O(n)
```

---

## Space Complexity

```text
O(n)
```

For storing characters in the HashSet.

---

# Key Concepts

- HashSet
- Character Processing
- Uppercase & Lowercase Mapping

---

# Tags

```text
Hash Table
String
Easy
```