package ood;

import java.util.*;

public class solution {
	//172 factorization of n.解题思路：找有多少个5，因为2很多，5*2可以凑出0末尾.
	public int trailingZeroes(int n) {
		int temp = 5;
		int result = 0;
		while(n >= temp){
			result = result + n/temp;
			temp = temp * 5;
		}
		return result;
	}
	//return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	public int trailingZeroe(int n) {

		if(n == 0) return 0;
		return n/5 + trailingZeroe(n/5);

	}
	//171思路：从左往右，每次出的结果都乘上26在加下一个。
	//168和这道题是反向的
	public int titleToNumber(String s) {
		double result = 0;
		int l = s.length();
		for(int i = 0; i< l; i++){
			result = result + Math.pow(26,(l-i-1))*(s.charAt(i) - 'A' + 1);

		}
		return (int)result;
	}
	//alternative&better
	public int titleToNumberr(String s) {
		int result = 0;

		for(int i = 0; i< s.length(); i++){
			result = result * 26 + s.charAt(i) - 'A' + 1;
		}

		return result;
	}
	//169 考察hash map的基本操作：containsKey();map.get();map.put();以及遍历
	public int majorityElement(int[] num) {
		HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
		for(int i : num){
			if(count.containsKey(i)){ 
				count.put(i, count.get(i) + 1);
			}else{
				count.put(i, 1);  
			}
			if(count.get(i) > num.length/2){
				return i;
			}
		}
		return -1;
	}
	//168和171反向
	public String convertToTitle(int n) {
		return n==0?"":convertToTitle((n-1)/26)+(char)((n-1)%26+'A');        
	}
	//alternative
	public String convertttitle(int n){
		StringBuffer sb = new StringBuffer("");
		while(n > 0){
			//n 需要减1，处理整除为零却是z的情况
			n--;
			//注意每次插入都在前面，不用插入到后面再reverse；而且可以插入字符
			sb.insert(0, (char)('A' + (n % 26)));
			//decrement n
			n = n/26;
		}
		return sb.toString();
	}

	//167
	//解题思路：1.把字符串切分,两个pointer 2.按照小数点分类 3.比较 4.注意末尾为0的，1.00 ＝1；所以要去掉尾部的0
	//把string里面的char变成数字：charAt(i) - '0'；
	public int compareVersion(String version1, String version2) {
		int i = 0; int j = 0;
		while(i < version1.length() || j < version2.length()){
			//两个vectors装小数点中间的数字
			int a = 0; int b = 0;
			//注意跨域问题 －》判越界放在前面！
			while(i < version1.length()&&version1.charAt(i) != '.'){
				a = 10 * a + (version1.charAt(i) - '0');
				i++;
			}
			while(j < version2.length()&&version2.charAt(j) != '.'){
				b = 10*b + (version2.charAt(j) - '0');
				j++;
			}
			if(a < b){
				return -1;
			}
			if(a > b){
				return 1;
			}
			i++;
			j++;
		}
		return 0;
	}
	//166 two linked list - find merge point O(N) TIME O(1) MEMMORY
	//解题思路：这个方法是遍历太耗时：可以考虑HashSet来做,存储空间要求多了一些
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA == null || headB == null){
			return null;
		}

		ListNode ha = headA;
		while(ha.next != null){
			ListNode hb = headB;
			while(hb.next != null){
				if(hb == ha){
					return ha;
				}
				hb = hb.next;
			}
			ha = ha.next;
		}
		return null;
	}
	//Alternative: HashSet: O(N) O(N)
	public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
		HashSet<ListNode> set = new HashSet<ListNode>();
		ListNode ha = headA;
		ListNode hb = headB;
		while (ha!= null || hb != null){
			if(ha != null){
				if(set.contains(ha)){
					return ha;
				}else{
					set.add(ha);
				}
				ha = ha.next;
			}
			if(hb != null){
				if(set.contains(hb)){
					return hb;
				}else{
					set.add(hb);
				}
				hb = hb.next;
			}
		}
		return null;
	}
	//125: 解题思路：1:用string buffer存下，比较reverse之前之后是不是一样：A.equals(B)
	public boolean isPalindrome(String s) {
		if(s.length() == 0){
			return true;
		}
		StringBuffer sb = new StringBuffer("");
		for(int i = 0; i< s.length(); i++){
			if(Character.isLetter(s.charAt(i))){
				sb.append(s.charAt(i));
			}
		}
		String str = sb.toString();
		System.out.print(str);
		sb.reverse();
		System.out.print(sb);
		if(str.equals(sb.toString())){
			return true;
		}
		return false;     
	}
	//简洁的答案算法：
	public boolean isPalindrome1(String s) {
		s = s.toLowerCase(); // convert all to lower cases.
		s = s.replaceAll("[^a-z^0-9]+", ""); // remove all non-digital and non-letter.
		int len = s.length();
		for (int i = 0; i < len; i++){
			if (s.charAt(i) != s.charAt(len - i - 1)){
				return false;
			}
		}
		return true;
	}
	//思路2:用两个pointers，一前一后往中间走，空过非数字以及非字母的
	public boolean isPalindrome2(String s){
		if(s.length() == 0){
			return true;
		}
		s = s.toLowerCase();
		int i = 0;
		int j = s.length() - 1;
		while(i < j){
			boolean a = Character.isDigit(s.charAt(i)) || Character.isLetter(s.charAt(i));
			boolean b = Character.isDigit(s.charAt(j)) || Character.isLetter(s.charAt(j));
			if(a && b){
				char m = s.charAt(i);
				char n = s.charAt(j);
				if(m != n){
					return false;
				}
				i++;
				j--;
			}
			if(!a) i++;
			if(!b) j--;
			else{
				i++;
				j--;
			}
		}
		return true;
	}
	//119: Pascal Triangle II
	//解题思路1:用阶乘相除，问题：无法处理大于20的数字，会返回负值
	//should use another approach to solve this， refer to解题方法2
	public List<Integer> getRow(int rowIndex){
		List<Integer> result = new ArrayList<Integer>();
		for(int i = 0; i <= rowIndex; i++){
			long m = fact(rowIndex);
			long n = fact(i);
			long q = fact(rowIndex - i);
			long r = m/(n*q);
			//System.out.println(m);
			//System.out.println(n);
			result.add((int)r);
		}
		return result;
	}
	public long fact(int a){
		if(a == 0) return 1;
		return fact(a - 1) * a;
	}
	//解题方法2:用数学定义，杨辉三角的相加法则
	public List<Integer> getRow2(int rowIndex) {
		List<Integer> list = new ArrayList<Integer>();
		if (rowIndex < 0)
			return list;

		for (int i = 0; i < rowIndex + 1; i++) {
			list.add(0, 1); //set the starting index to be 1.
			for (int j = 1; j < list.size() - 1; j++) {
				list.set(j, list.get(j) + list.get(j + 1));
			}
		}
		return list;
	}
	//way3:从后往前走
	public ArrayList<Integer> getRow3(int rowIndex) {  
		ArrayList<Integer> res = new ArrayList<Integer>();  
		if(rowIndex<0)  
			return res;  
		res.add(1);  
		for(int i=1;i<=rowIndex;i++)  
		{  
			for(int j=res.size()-2;j>=0;j--)  
			{  
				res.set(j+1,res.get(j)+res.get(j+1));  
			}  
			res.add(1);  
		}  
		return res;  
	}  
	//118: Pascal triangle打印出所有的array：解题思路：保留上一层的指针
	public ArrayList<ArrayList<Integer>> generate(int numRows) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(numRows <= 0){
			return result;
		}
		ArrayList<Integer> pre = new ArrayList<Integer>();
		pre.add(1);
		result.add(pre);
		for(int i = 0; i< numRows; i++){
			ArrayList<Integer> cur = new ArrayList<Integer>();
			cur.add(1);
			for(int j = 0; j < pre.size(); j++){
				cur.add(pre.get(j) + pre.get(j+1));
			}
			cur.add(1);
			result.add(cur);
			pre = cur;
		}
		return result;
	}
	//check if a tree is symmetric对称树：recursive
	//思路：左枝的右侧等于右枝的左侧；左枝左侧等于右枝右侧
	public boolean isSymmetric(treeNode root){
		if(root == null){
			return true;
		}else{
			return symmetric(root.left, root.right);
		}
	}
	public boolean symmetric(treeNode l, treeNode r){
		if(l == null && r == null){
			return true;
		}else if(l != null && r != null && l.val == r.val){
			return symmetric(l.left, r.right) && symmetric(l.right, r.left);
		}else{
			return false;
		}
	}
	//101 check if a tree is symmetric对称树：iterate
	//use stack:解题思路：用两个stack分别存下来左枝和右枝，按照顺序左枝左侧，右枝右侧，左至右侧，右枝左侧
	public boolean isSymmetric2(treeNode root){
		if(root == null || (root.left == null && root.right == null)){
			return true;
		}
		Stack<treeNode> left = new Stack<treeNode>();
		Stack<treeNode> right = new Stack<treeNode>();
		left.push(root.left);
		right.push(root.right);
		while(left!= null && right != null){
			treeNode l = left.pop();
			treeNode r = right.pop();
			if(l == null && r == null) continue;
			if(l != null && r != null){
				left.push(l.left);
				right.push(r.right);
				left.push(l.right);
				right.push(r.left);
				continue;
			}else{
				return false;
			}	
		}
		return true;
	}
	//112: check if there is a path sum to a number
	//解题思路：recursive 
	public boolean haspathsum(treeNode root, int n){
		//base case
		if(root == null) return false;
		if(root.left == null && root.right == null){
			return root.val == n;
		}
		return haspathsum(root.left, n - root.val) || haspathsum(root.right, n - root.val);	
	}
	//最小高度，跟最大高度反的来
	public int minDepth(treeNode root){

		if(root == null){
			return 0;
		}
		if(root.left == null || root.right == null){
			return 1;
		}
		int l = minDepth(root.left);
		int r = minDepth(root.right);
		if(l < r){
			return l+1;
		}else{
			return r + 1;
		}
	}
	//100. check if two trees are the same:注意base case！！要写全！！
	public boolean isSameTree(treeNode p, treeNode q) {
		if(p == null && q == null) return true;
		if(p == null && q != null) return false;
		if(p != null && q == null) return false;
		if(p.left == null && p.right == null){
			return q.val == p.val && q.left == null && q.right == null;
		}
		if(p.val == q.val){
			return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
		}
		return false;

	}
	//解题思路，两个数列都排好序了，而且A的长度长于m+n，那要结合就从后往前遍历，放到m+n-1的位置往前走
	//three pointers也可以用另一中方法：两个pointer，另一个在loop
	public void merge(int A[], int m, int B[], int n) {
		int a = m - 1;
		int b = n - 1;
		int last = m + n - 1;

		while(last >= 0){
			if(b < 0) break;
			if(a < 0) {
				A[last] = B[b];
				b--;
				last--;
				continue; //不要再往下走了
			}
			if(A[a] >= B[b]){
				A[last] = A[a];
				a--;
				last--;
			}else if( a <= 0 || A[a] < B[b]){
				A[last] = B[b];
				b--;
				last--;
			}

		}
	}
	//alternative
	public void merge1(int A[], int m, int B[], int n){
		int i = m - 1;
		int j = n - 1;
		for (int k = m + n -1; k >= 0; k--){
			if(j <0) break;
			if(i<0){
				A[k] = B[j];
				j--;
			}
			if(A[i] > B[j]){
				A[k] = A[i]; 
				i--;
			}
			if(A[i] <= B[j]){ 
				A[k] = B[j]; 
				j--;

			}
		}
	}
	//70 climbing stairs using DP
	public int climbStairs(int n) {
		if(n < 2) return 1;
		int[] temp = new int[n];
		temp[0] = 1;
		temp[1] = 2;
		for(int i = 2; i < n; i++){
			temp[i] = temp[i-2] + temp[i-1];
		}

		return temp[n-1];

	}
	//66. int array represent number, compute add one:
	// {1,2,9} => {1,3,0} 解题思路：空集就null；指针从后往前，while遍历数组，小于9就加1 break；
	// 等于9而且是最后一位，变零，搞新数组，转移旧数组到新的；＝＝9且非最后一位，变零，继续遍历。
	public int[] plusOne(int[] digits) {
		if(digits.length == 0){
			return null;
		}
		int l = digits.length - 1;
		int[] newd;

		while(l > -1){
			if(digits[l] != 9){
				digits[l] = digits[l] + 1;
				break;
			} 
			if(digits[l] == 9 && l == 0){
				digits[l] = 0;
				newd = new int[digits.length + 1];
				newd[0] = 1;

				for(int j = newd.length - 1; j > 0; j--){
					newd[j] = digits[j-1];
				}
				return newd;
			}

			digits[l] = 0;
			l--;
		}
		return digits;


	}

	//答案：需要buffer, carry, 两个指针
	public String addBinary(String a, String b) {
		StringBuffer res = new StringBuffer("");
		int carryOver = 0;
		for(int i = a.length()-1, j = b.length()-1; i>=0 || j>=0; i--, j--){
			int ai = ((i<0) ? 0 : Integer.parseInt(a.charAt(i)+""));
			//必须要有后面的""把char变成string才能用parseInt
			int bi = ((j<0) ? 0 : Integer.parseInt(b.charAt(j)+""));

			res.insert(0, (ai ^ bi) ^ carryOver);
			//bit manipulation: ^: bitwise XOR
			carryOver = ((ai+bi+carryOver)>1) ? 1 : 0;
		}
		if(carryOver == 1)
			res.insert(0, '1'); 
		return res.toString();
	}

	//merge two sorted linked list:方法一 recursion
	public ListNode MergeLists(ListNode list1, ListNode list2) {
		if (list1 == null) return list2;
		if (list2 == null) return list1;

		if (list1.val < list2.val) {
			list1.next = MergeLists(list1.next, list2);
			return list1;
		} else {
			list2.next = MergeLists(list2.next, list1);
			return list2;
		}
	}
	//find the last word's length。用split分解字符串，返回array的最后一个
	public int lengthOfLastWord(String s) {
		String[] parts = s.split(" ");
		if (parts.length == 0) return 0;
		return parts[parts.length - 1].length();
	}

	//或者就：从后往前遍历，注意要考虑最后一个字符是空格的情况
	public int lengthOfLastWord1(String s) {
		int l = s.length() - 1;
		int a = 0;
		if(l < 0) return a;
		if(s.charAt(l) == ' '){
			while(l >= 0 && s.charAt(l) == ' '){
				l--;
			}
		}
		while(l >= 0 && s.charAt(l) != ' '){
			a++;
			l--;
		}
		return a;
	}

	public ArrayList<ArrayList<Integer>> ALLcountAndSay(int n) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if(n <= 0) return result;
		ArrayList<Integer> prelevel = new ArrayList<Integer>();
		prelevel.add(1);
		result.add(prelevel);
		for(int i = 1; i < n; i++){
			ArrayList<Integer> level = new ArrayList<Integer>();
			level.add(prelevel.get(0));
			int num = 1;
			for(int j = 1; j < prelevel.size(); j++){
				if(prelevel.get(j) == prelevel.get(j - 1)){
					num++;
				}else{
					level.add(level.size() - 1,num);
					level.add(prelevel.get(j));
					num = 1;
				}
			}
			level.add(level.size() - 1, num);
			result.add(level);
			prelevel = level;
		}

		return result;
	}

	public String countAndSay(int n){
		StringBuffer sb = new StringBuffer();
		if(n <= 0){
			return "";
		}

		sb.append(1);

		for(int i = 1; i < n; i++){
			int count = 1;
			StringBuffer level = new StringBuffer();
			level.append(sb.charAt(0));
			for(int j = 1; j < sb.length(); j++){
				if(sb.charAt(j) == sb.charAt(j-1)){
					count++;
				}else{
					level.insert(level.length() - 1, count);
					level.append(sb.charAt(j));
					count = 1;
				}
			}
			level.insert(level.length() - 1, count);
			sb = new StringBuffer(level);
		}
		return sb.toString();
	}
	//other people's answer; easier than mine
	public String countAndSayO(int n) {  
		String s = "1";  

		for(int i=1; i<n; i++) {  
			int cnt = 1;  
			StringBuilder tmp = new StringBuilder();  
			for(int j=1; j<s.length(); j++) {  
				if(s.charAt(j) == s.charAt(j-1)) {  
					cnt++;  
				} else {  
					tmp.append(cnt).append(s.charAt(j-1));  
					cnt = 1;  
				}  
			}  
			tmp.append(cnt).append(s.charAt(s.length()-1));  
			s = tmp.toString();  
		}  

		return s;  
	}  

	//解题思路：用helper－fn，截取两个对角点(x,y)(a,b)，遍历里面点是否有重合
	//先查横竖，再查九宫格。helper-fn里面用hashSet来查重。
	public boolean isValidSudoku(char[][] board) {
		for(int i = 0; i< 9; i++){
			if(!checkPartial(board, 0,i,8,i)){
				return false;
			}
			if(!checkPartial(board, i, 0, i, 8)){
				return false;
			}
		}
		for(int i = 0; i< 3; i++){
			for(int j = 0; j<3; j++){

				if(!checkPartial(board, i*3, 3*j,i*3+2, 3*j+2)){
					return false;
				}
			}
		}

		return true;
	}
	//
	public boolean checkPartial(char[][] b, int p, int q, int x, int y){
		HashSet<Character> row = new HashSet<Character>();
		for(int i = p; i <= x; i++){
			for(int j = q; j <= y; j++){
				char a = b[i][j];
				if(a != '.' && row.contains(a)){
					return false;
				}else if(a != '.'){
					row.add(a);
				}
			}
		}
		return true;
	}

	public char firstNonRep(String s){
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		char c = s.charAt(0);
		for(int i = 0; i < s.length(); i++){
			if(map.containsKey(s.charAt(i))){
				int j = map.get(s.charAt(i));
				map.put(s.charAt(i), j+1);
			}else{
				map.put(s.charAt(i), 1);
			}
		}

		for(int i = 0; i< s.length(); i++){
			if(map.get(s.charAt(i)) == 1){
				c = s.charAt(i);
				break;
			}
		}
		return c;
	}
	// VALID PARENTHESIS
	//Given a string containing just the characters '(', ')', '{', '}', '[' and ']', 
	//determine if the input string is valid.
	//解题思路：用一个stack存每一个括号，遍历string，开括号存，关括号peek来检查
	//＊注意＊stack容易空，操作之前一定要先查空，stack.emtpy()检查一下
	public boolean validParen(String s){
		if(s.length() == 0){
			return true;
		}
		Stack<Character> stack = new Stack<Character>();
		for(int i = 0; i < s.length(); i++){
			if(s.charAt(i) == '(' ||s.charAt(i) == '[' || s.charAt(i) == '{'){
				stack.push(s.charAt(i));
			}
			else if(s.charAt(i) == ')' && !stack.empty() && stack.peek() == '('){
				stack.pop();
			}
			else if(s.charAt(i) == ']' && !stack.empty() && stack.peek() == '['){
				stack.pop();
			}
			else if(s.charAt(i) == '}' && !stack.empty() && stack.peek() == '}'){
				stack.pop();
			}else{
				return false;
			}
		}
		return stack.empty();

	}
	/**
	 * Definition for singly-linked list.
	 * public class ListNode {
	 *     int val;
	 *     ListNode next;
	 *     ListNode(int x) {
	 *         val = x;
	 *         next = null;
	 *     }
	 * }
	     ===== Remove the nth to the last linkedlist and return the head =====
	     注意里面的位置问题，next还是next.next!!!!
	    public class Solution {
	        public ListNode removeNthFromEnd(ListNode head, int n) {
	            if(head == null){
	                return null;
	            }

	            ListNode current = head;
	            ListNode looper = head;

	            while(n > 0){
	                looper = looper.next;
	                n--;
	            }
	            if(looper == null){
	                return head.next;
	            }
	            looper = looper.next;
	            while(looper != null){
	                looper = looper.next;
	                current = current.next;
	            }
	            ListNode list = current.next.next;
	            current.next = list;
	            return head;
	        }
	    }*/
	//*Find the longest prefix
	//解题思路：两个pointers一个指array一个指字符串里面的index；条件1：长度不出；条件2:相等
	public String longestCommonPrefix(String[] strs){
		StringBuffer prefix = new StringBuffer("");
		for(int i = 0; i < strs[0].length(); i++){
			Character first = strs[0].charAt(i);
			for(int j = 0; j < strs.length; j++){
				if(strs[j].length() <= i || strs[j].charAt(i) != first){
					//注意这里的length和index，应该师有等于
					return prefix.toString();
				}
			}
			prefix.append(first);
		}
		return prefix.toString();
	}

	// converting to integer from Romen NUmbers
	// I  V  X  L  C  D  M 
	// representing 1  5  10  50  100  500  1000
	// 先用map把这些值都存上，然后keep track前一个数值
	public int roman(String s){
		int result = 0;
		if(s.isEmpty()) return result;
		HashMap<Character, Integer> map = new HashMap<Character, Integer>();
		map.put('I', 1);
		map.put('V', 5);
		map.put('X', 10);
		map.put('L', 50);
		map.put('C', 100);
		map.put('D', 500);
		map.put('M', 1000);

		int previousnumber = map.get(s.charAt(0));
		result = map.get(s.charAt(0));

		for(int i = 1; i< s.length(); i++){
			if(map.get(s.charAt(i)) > previousnumber){
				result += map.get(s.charAt(i)) - 2*previousnumber;
			}
			previousnumber = map.get(s.charAt(i));
			result += map.get(s.charAt(i));
		}
		return result;
	}
	//Palindrome Number: DON'T use extra space/memory
	// DON'T convert to string, or simply reverse the integer!!!
	//思路：找数字一半的reverse，一边找一边把原始数字➗10，最后让rev一半的和原始数字相等
	//注意 10的倍数都不能通过这个方法detect出来
	public boolean palinnum(int x){
		if(x < 0 || (x % 10 == 0 && x != 0)){
			return false;
		}
		int rev = 0;
		while(rev < x){
			rev = 10 * rev + x%10;  //倒着的后面几位
			x = x/10;
		}
		return (x == rev)||(x == rev/10);
	}
	
	public int[] mergetwoSortedLists(int[] A, int[] B){
		int[] result = new int[A.length + B.length - 1];
		int i = A.length - 1; 
		int j = B.length - 1;
		while(i != 0 || j != 0){
		     if(A[i] > B[j]){
		    	 result[i+j - 1] = A[i];
		    	 i--;
		     }else{
		    	 result[i+j -1] = B[j];
		    	 j--;
		     }
		     
		}
		return result;
	}
}
