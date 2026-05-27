# 1392. Longest Happy Prefix

> Difficulty: Hard  
> Topics: String, KMP, Prefix Function

---

## Problem Statement

A string is called a **happy prefix** if it is a non-empty prefix which is also a suffix (excluding the entire string itself).

Given a string `s`, return the **longest happy prefix** of `s`.

Return an empty string `""` if no such prefix exists.

---

## Examples

### Example 1

#### Input
```text
s = "level"
```

#### Output
```text
"l"
```

#### Explanation

Prefixes:
- `"l"`
- `"le"`
- `"lev"`
- `"leve"`

Suffixes:
- `"evel"`
- `"vel"`
- `"el"`
- `"l"`

The longest prefix which is also a suffix is:

```text
"l"
```

---

### Example 2

#### Input
```text
s = "ababab"
```

#### Output
```text
"abab"
```

#### Explanation

Prefixes:
- `"a"`
- `"ab"`
- `"aba"`
- `"abab"`
- `"ababa"`

Suffixes:
- `"babab"`
- `"abab"`
- `"bab"`
- `"ab"`
- `"b"`

The longest matching prefix and suffix is:

```text
"abab"
```

---

### Example 3

#### Input
```text
s = "leetcodeleet"
```

#### Output
```text
"leet"
```

---

## Constraints

```text
1 <= s.length <= 10^5
s contains only lowercase English letters.
```

---

# Approach

## Using KMP (Prefix Function)

We use the KMP preprocessing algorithm to build the `LPS` array.

### What is LPS?

`lps[i]` stores the length of the:

> longest proper prefix which is also a suffix  
> for the substring `s[0...i]`

The answer will be:

```java
lps[n - 1]
```

because it represents the longest prefix-suffix for the entire string.

---

# Dry Run

## Input

```text
s = "ababab"
```

## LPS Construction

| Index | Character | LPS |
|------|------|------|
| 0 | a | 0 |
| 1 | b | 0 |
| 2 | a | 1 |
| 3 | b | 2 |
| 4 | a | 3 |
| 5 | b | 4 |

Final LPS Array:

```text
[0, 0, 1, 2, 3, 4]
```

Last value:

```text
4
```

So answer is:

```text
s.substring(0, 4) => "abab"
```

---

# Java Solution

```java
class Solution {

    public String longestPrefix(String s) {

        int n = s.length();

        int[] lps = new int[n];

        int len = 0;
        int i = 1;

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

        return s.substring(0, lps[n - 1]);
    }
}
```

---

# Complexity Analysis

## Time Complexity

```text
O(n)
```

Because each character is processed at most twice.

---

## Space Complexity

```text
O(n)
```

For storing the LPS array.

---


