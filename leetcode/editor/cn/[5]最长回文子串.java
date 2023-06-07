//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母组成 
// 
//
// Related Topics 字符串 动态规划 👍 6556 👎 0


//leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {
        String res = s.substring(0,1);
        for(int i=0;i<s.length();i++) {
            for(int left=i,right=i+1;left>=0&&right<s.length();left--, right++) {
                if(s.charAt(left) != s.charAt(right)) {
                    break;
                } else if(right-left+1 > res.length()){
                    res = s.substring(left, right+1);
                }
            }
            for(int left=i-1,right=i+1;left>=0&&right<s.length();left--, right++) {
                if(s.charAt(left) != s.charAt(right)) {
                    break;
                } else if(right-left+1 > res.length()){
                    res = s.substring(left, right+1);
                }
            }
        }
        return res;

    }
}
//leetcode submit region end(Prohibit modification and deletion)
