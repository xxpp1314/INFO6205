/*Q1
Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.

Note:

The length of both num1 and num2 is < 5100.
Both num1 and num2 contains only digits 0-9.
Both num1 and num2 does not contain any leading zero.
You must not use any built-in BigInteger library or convert the inputs to integer directly.
*/
public String addStrings(String num1, String num2){        
        StringBuilder res = new StringBuilder("");
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int val1 = i >= 0 ? num1.charAt(i) - '0' : 0;
            int val2 = j >= 0 ? num2.charAt(j) - '0' : 0;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            res.append(sum % 10);
            i--;
            j--;
        }
        if(carry == 1){
            res.append(1);
        }
        return res.reverse().toString();
}

/*Q2
Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

Example:

Input: 1->2->4, 1->3->4
Output: 1->1->2->3->4->4

*/
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
        if(l1 == null){
            return l2;
        }
        if(l2 == null){
            return l1;
        }
        if(l1.val < l2.val){
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        }
        else{
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
}

/*Q3
Given a string s, a k duplicate removal consists of choosing k adjacent and equal letters from s and
removing them causing the left and the right side of the deleted substring to concatenate together.

We repeatedly make k duplicate removals on s until we no longer can.

Return the final string after all such duplicate removals have been made.

It is guaranteed that the answer is unique.

Example:
Input: s = "abcd", k = 2
Output: "abcd"
Explanation: There's nothing to delete.

Input: s = "deeedbbcccbdaa", k = 3
Output: "aa"
Explanation: 
First delete "eee" and "ccc", get "ddbbbdaa"
Then delete "bbb", get "dddaa"
Finally delete "ddd", get "aa"
*/
public String removeDuplicates(String s, int k) {
        StringBuilder res = new StringBuilder(s);
        Stack<Integer> counts = new Stack<>();
        for (int i = 0; i < res.length(); ++i) {
            if (i == 0 || res.charAt(i) != res.charAt(i - 1)) {
                counts.push(1);
            } else {
                int increase = counts.pop() + 1;
                if (increase == k) {
                    res.delete(i - k + 1, i + 1);
                    i = i - k;
                } else {
                    counts.push(increase);
                }
            }
        }
        return res.toString();
}

/*Q4
Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

Example:

board =
[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

Given word = "ABCCED", return true.
Given word = "SEE", return true.
Given word = "ABCB", return false.
*/
private boolean[][] marked;
private int[][] direction = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};
private int m;
private int n;
private String word;
private char[][] board;

public boolean exist(char[][] board, String word) {
    m = board.length;
    if(m == 0){
        return false;
    }
    n = board[0].length;
    marked = new boolean[m][n];
    this.word = word;
    this.board = board;
    for(int i = 0; i < m; i++){
        for(int j = 0; j < n; j++){
            if(dfs(i, j, 0))
                return true;
        }
    }
    return false;
}
    
public boolean dfs(int i, int j, int begin){
    if(begin == word.length() - 1){
        return board[i][j] == word.charAt(begin);
    }
    if(board[i][j] == word.charAt(begin)){
        marked[i][j] = true;
        for(int k = 0; k < 4; k++){
            int newX = i + direction[k][0];
            int newY = j + direction[k][1];
            if(inArea(newX, newY) && !marked[newX][newY]){
                if(dfs(newX, newY, begin + 1)){
                    return true;
                }
            }
        }
        marked[i][j] = false;
    }
    return false;
}

public boolean inArea(int x, int y){
    return x >= 0 && x < m && y >= 0 && y < n; 
}

/*Q5
Given two non-empty binary trees s and t, check whether tree t has exactly the same structure and node values with a subtree of s. A subtree of s is a tree consists of a node in s and all of this node's descendants. The tree s could also be considered as a subtree of itself.

Example 1:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
Given tree t:
   4 
  / \
 1   2
Return true, because t has the same structure and node values with a subtree of s.
Example 2:
Given tree s:

     3
    / \
   4   5
  / \
 1   2
    /
   0
Given tree t:
   4
  / \
 1   2
Return false.
*/
public boolean isSubtree(TreeNode s, TreeNode t) {
        if(t == null){
            return true;
        }
        if(s == null){
            return false;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSametree(s, t);
}
    
public boolean isSametree(TreeNode s, TreeNode t){
        if(s == null && t == null){
            return true;
        }
        if(s == null || t == null){
            return false;
        }
        if(s.val != t.val){
            return false;
        }
        return isSametree(s.left, t.left) && isSametree(s.right, t.right);
}

/*Q6
Given a Binary Search Tree and a target number, return true if there exist two elements in the BST such that their sum is equal to the given target.

Example 1:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 9

Output: True
 

Example 2:

Input: 
    5
   / \
  3   6
 / \   \
2   4   7

Target = 28

Output: False
*/
public boolean findTarget(TreeNode root, int k) {
        Set<Integer> set = new HashSet();
        return findValue(root, k, set);
}
public boolean findValue(TreeNode root, int k, Set<Integer> set) {
        if (root == null)
            return false;
        if (set.contains(k - root.val))
            return true;
        set.add(root.val);
        return findValue(root.left, k, set) || findValue(root.right, k, set);
}

/*Q7
Given an encoded string, return its decoded string.

The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times.
Note that k is guaranteed to be a positive integer.

You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.

Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers,k.
For example, there won't be input like 3a or 2[4].

Example:
s = "3[a]2[bc]", return "aaabcbc".
s = "3[a2[c]]", return "accaccacc".
s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
*/
public String decodeString(String s) {
        StringBuilder res = new StringBuilder();
        int multi = 0;
        LinkedList<Integer> stack_multi = new LinkedList<>();
        LinkedList<String> stack_cur = new LinkedList<>();
        for(Character c : s.toCharArray()) {
            if(c == '[') {
                stack_multi.addLast(multi);
                stack_cur.addLast(res.toString());
                multi = 0;
                res = new StringBuilder();
            }
            else if(c == ']') {
                StringBuilder tmp = new StringBuilder();
                int cur_multi = stack_multi.removeLast();
                for(int i = 0; i < cur_multi; i++) tmp.append(res);
                res = new StringBuilder(stack_cur.removeLast() + tmp);
            }
            else if(c >= '0' && c <= '9') multi = multi * 10 + Integer.parseInt(c + "");
            else res.append(c);
        }
        return res.toString();
    }
}

/*Q8
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

Input:
11110
11010
11000
00000

Output: 1
Example 2:

Input:
11000
11000
00100
00011

Output: 3
*/

public int numIslands(char[][] grid) {
        int count = 0;
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    dfs(i, j, grid);
                    count++;
                }
            }
        }
        return count;
}
    
public void dfs(int i, int j, char[][] grid){
        if(i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0')
            return;
        grid[i][j] = '0';
        dfs(i + 1, j, grid);
        dfs(i - 1, j, grid);
        dfs(i, j + 1, grid);
        dfs(i, j - 1, grid);
}

/*Q9
There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.

Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

Example 1:

Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0. So it is possible.
Example 2:

Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take. 
             To take course 1 you should have finished course 0, and to take course 0 you should
             also have finished course 1. So it is impossible.
 

Constraints:

The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
You may assume that there are no duplicate edges in the input prerequisites.
1 <= numCourses <= 10^5
*/

public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] width = new int[numCourses];
        List<List<Integer>> connect = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            connect.add(new ArrayList<>());
        }
        for(int[] course : prerequisites) {
            width[course[0]]++;
            connect.get(course[1]).add(course[0]);
        }
        for(int i = 0; i < numCourses; i++){
            if(width[i] == 0) 
                queue.add(i);
        }
        while(!queue.isEmpty()) {
            int pre = queue.poll();
            numCourses--;
            for(int cur : connect.get(pre)){
                if(--width[cur] == 0) 
                    queue.add(cur);
            }    
        }
        return numCourses == 0;
}

/*Q10
Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

Example 1:

Input: [[0, 30],[5, 10],[15, 20]]
Output: 2
Example 2:

Input: [[7,10],[2,4]]
Output: 1
*/

public int minMeetingRooms(int[][] intervals) {
        int length = intervals.length;
        if(length < 2){
            return length;
        }
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        PriorityQueue<int[]> heap = new PriorityQueue<int[]>(length, (a, b) -> a[1] - b[1]);
        int roomNum = 0;
        for(int[] time: intervals){
            while(!heap.isEmpty() && time[0] >= heap.peek()[1]){
                heap.poll();
            }
            heap.offer(time);
            roomNum = Math.max(roomNum, heap.size());
        }
        return roomNum;
}
