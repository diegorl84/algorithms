Non-Constructible Change
<p>
  Given an array of positive integers representing the values of coins in your
  possession, write a function that returns the minimum amount of change (the
  minimum sum of money) that you <b>cannot</b> create. The given coins can have
  any positive integer value and aren't necessarily unique (i.e., you can have
  multiple coins of the same value).
</p>
<p>
  For example, if you're given <span>coins = [1, 2, 5]</span>, the minimum
  amount of change that you can't create is <span>4</span>. If you're given no
  coins, the minimum amount of change that you can't create is <span>1</span>.
</p>
<h3>Sample Input</h3>
<pre><span class="CodeEditor-promptParameter">coins</span> = [5, 7, 1, 1, 2, 3, 22]
</pre>
<h3>Sample Output</h3>
20

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

