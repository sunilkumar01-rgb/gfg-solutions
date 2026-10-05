# Java Exception Handling

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

You are required to compute the power of a number by implementing a calculator. Create a class *MyCalculator* which consists of a single method `long power(int, int)`. This method takes two integers, $n$ and $p$, as parameters and finds $n^p$. If either $n$ or $p$ is negative, then the method must throw an exception which says "$\texttt{n or p should not be negative}$". Also, if both $n$ and $p$ are zero, then the method must throw an exception which says "$\texttt{n and p should not be zero.}$"

For example, *-4* and *-5* would result in $\texttt{java.lang.Exception: n or p should not be negative}$.

Complete the function `power` in class *MyCalculator* and return the appropriate result after the power operation or an appropriate exception as detailed above. 

**Input Format**

Each line of the input contains two integers, $n$ and $p$. The locked stub code in the editor reads the input and sends the values to the method as parameters.

**Constraints**

- $-10 \le n \le 10$
- $-10 \le p \le 10$

**Output Format**

Each line of the output contains the result $n^p$, if both $n$ and $p$ are positive. If either $n$ or $p$ is negative, the output contains "n and p should be non-negative". If 
both $n$ and $p$ are zero, the output contains "n and p should not be zero.". This is printed by the locked stub code in the editor.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T18:28:42.032Z  

```java

class MyCalculator {
    /*
    * Create the method long power(int, int) here.
    */
        long power(int n, int p) throws Exception {
        if (n < 0 || p < 0) {
            throw new Exception("n or p should not be negative.");
        }
        if (n == 0 && p == 0) {
            throw new Exception("n and p should not be zero.");
        }
        return (long) Math.pow(n, p);
    }
}


```

---

[View on HackerRank](https://www.hackerrank.com/challenges/java-exception-handling/problem)