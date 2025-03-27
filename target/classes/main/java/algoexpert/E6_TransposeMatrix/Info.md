Transpose Matrix
<p>
    You're given a 2D array of integers <span>matrix</span>. Write a function
    that returns the transpose of the matrix.
  </p>
<p>
    The transpose of a matrix is a flipped version of the original matrix across
    its main diagonal (which runs from top-left to bottom-right); it switches
    the row and column indices of the original matrix.
  </p>
<p>
    You can assume the input matrix always has at least 1 value; however its
    width and height are not necessarily the same.
  </p>

<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">matrix</span> = [
  [1, 2],
]</pre>

<h3>Sample Output</h3>
<pre>[
  [1],
  [2]
]</pre>

<h3>Sample Input #2</h3>
<pre><span class="CodeEditor-promptParameter">matrix</span> = [
  [1, 2],
  [3, 4],
  [5, 6]
]</pre>
<h3>Sample Output #2</h3>
<pre>[
  [1, 3, 5],
  [2, 4, 6]
]</pre>
<h3>Sample Input #3</h3>
<pre><span class="CodeEditor-promptParameter">matrix</span> = [
  [1, 2, 3],
  [4, 5, 6],
  [7, 8, 9]
]</pre>
<h3>Sample Output #3</h3>
<pre>[
  [1, 4, 7],
  [2, 5, 8],
  [3, 6, 9]
]</pre>



Solution
1,1,2,3,5,7,22

change = 0
1 =< (change + 1)->1 ok, then change = 1 
1 =< (change + 1)->2 ok, then change+coin = 2
2 =< (change + 1)->3 ok, then change+coin = 4
3 =< (change + 1)->5 ok, then change+coin = 7
5 =< (change + 1)->8 ok, then change+coin = 13
7 =< (change + 1)->14 ok, then change+coin = 20
22 =< (change + 1)->21 NO

5 =< (change + 1)->1 NO, then change = 1
7

