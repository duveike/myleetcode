//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
//
// Related Topics 字符串 动态规划 回溯 👍 3256 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs("", res, 0, 0, n);
        return res;

    }

    private void dfs(String str,List<String> res, int left, int right, int n) {
        if(left>n) return;
        if(right>=n) {
            res.add(str);
        }
        dfs(str+"(", res, left+1,right,n);
        if(right<left) {
            dfs(str+")", res, left, right+1, n);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)
