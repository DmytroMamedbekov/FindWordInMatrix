# FindWordInMatrix
 Allows you to input a matrix of size N^2 (and checks the size to be a perfect square), then  a sequence of charachters you want to find and then returns the string containing the sequence of cells forming the word in a matrix. The cells can be directly above, under, to the left or to the right from the previous cell.

Example:<br /><br />
Matrix String: abcdefghi<br />
Matrix Example:<br />
g h i<br />
d e f<br />
a b c <br />
Word to be found: bed<br />
Result: [0, 1]->[1, 1]->[1, 0]
<br />

Notes:<br />
If a word cannot be found, returns null.<br />
If there are several ways to form a word, only the first instance will be found.<br />
In [0,1] the first number resembles x axis, and the second one y axis.
