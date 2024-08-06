
The TextDiffUtility project provides functionality to compare two strings and highlight their differences using color codes. The project includes methods to:
Find the Longest Common Subsequence (LCS): Determines the longest sequence that appears in both strings in the same order but not necessarily consecutively.
Highlight Differences: Highlights the differences between the two strings based on the LCS. Characters not present in the LCS are highlighted with specific color codes.
Key Features
Longest Common Subsequence (LCS) Calculation: Uses a dynamic programming approach to find the LCS of two input strings.
Difference Highlighting: Highlights differing characters between the two strings:
Characters present in the first string but not in the LCS are highlighted in red with an underline.
Characters present in the second string but not in the LCS are highlighted in green with a strikethrough.

Notes

The output highlighting will be visible in a terminal that supports ANSI color codes. If you are using an IDE or editor that does not support these codes, you might need to view the results in a compatible terminal.
The highlighting uses ANSI escape codes which might not be rendered properly in all text editors or viewers. Ensure to run the code in an environment that supports ANSI color codes to see the colored output.



Dependencies
Java Development Kit (JDK) 8 or higher.
