# Tag Content Extractor

![Difficulty](https://img.shields.io/badge/Difficulty-Medium-yellow)

## Problem

In a tag-based language like *XML* or *HTML*, contents are enclosed between a *start tag* and an *end tag* like `<tag>contents</tag>`. Note that the corresponding *end tag* starts with a `/`.

Given a string of text in a tag-based language, parse this text and retrieve the contents enclosed within sequences of well-organized tags meeting the following criterion:

1. The name of the *start* and *end* tags must be same. The HTML code `<h1>Hello World</h2>` is *not valid*, because the text starts with an `h1` tag and ends with a non-matching `h2` tag.

2. Tags can be nested, but content between nested tags is considered *not valid*. For example, in `<h1><a>contents</a>invalid</h1>`, `contents` is *valid* but `invalid` is *not valid*.
        
3. Tags can consist of any printable characters.



**Input Format**

The first line of input contains a single integer, $N$ (the number of lines). 	
The $N$ subsequent lines each contain a line of text.

**Constraints**  

- $1 \leq N \leq 100$	
- Each line contains a maximum of $10^4$ printable characters. 	
- The total number of characters in all test cases will not exceed $10^6$.



**Output Format**

For each line, print the content enclosed within valid tags. 	
If a line contains multiple instances of valid content, print out each instance of valid content on a new line; if no valid content is found, print `None`.

## Solution

**Language:** Java  
**Runtime:** N/A  
**Memory:** N/A  
**Submitted:** 2026-10-05T18:26:07.443Z  

```java
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution{
	public static void main(String[] args){
		
		Scanner in = new Scanner(System.in);
		int testCases = Integer.parseInt(in.nextLine());
		while(testCases>0){
			String line = in.nextLine();
			
          	            String regex = "<(.+?)>([^<]+)</\\1>";
            Pattern p = Pattern.compile(regex);
            
            Matcher m = p.matcher(line);
            boolean found = false;
            
            while (m.find()) {
                System.out.println(m.group(2));
                found = true;
            }
            
            if (!found) {
                System.out.println("None");
            }
            //Write your code here
			
			testCases--;
		}
	}
}




```

---

[View on HackerRank](https://www.hackerrank.com/challenges/tag-content-extractor/problem)