# FindWordInMatrix
 Allows you to input a matrix of size N^2 (and checks the size to be a perfect square), then  a sequence of charachters you want to find and then returns the string containing the sequence of cells forming the word in a matrix. The cells can be directly above, under, to the left or to the right from the previous cell.

Example:
Matrix String: abcdefghi
Matrix Example:

g h i
d e f
a b c 

Word to be found:bed
Result: [0, 1]->[1, 1]->[1, 0]


Notes:
If a word cannot be found, returns null.
If there are several ways to form a word, only the first instance will be found.
In [0,1] the first number resembles x axis, and the second one y axis.
