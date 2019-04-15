package main.leetCode;

import java.util.HashSet;
import java.util.Set;
/*
* 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
示例 1:
输入: "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
示例 2:
输入: "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
示例 3:
输入: "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
* */
public class lengthOfLongestSubstringSolustion {

    public int lengthOfLongestSubstring(String s) {
        //by 向娟
        char[] chars=new char[s.length()];
        chars=s.toCharArray();
        int maxLen = 1;
        int curLen = 1;
        int startIndex = 0;
        int curIndex = 1;
        Set<Character> set = new HashSet<Character>();
        if(s.length() > 0){
            set.add(chars[0]);
        }else{
            return 0;
        }

        while(curIndex < s.length()){
            if(!set.contains(chars[curIndex])){
                set.add(chars[curIndex]);
                curIndex++;
            }else{
                curLen = set.size();
                if(curLen > maxLen){
                    maxLen = curLen;
                }
                set.clear();
                startIndex = startIndex+1;
                set.add(chars[startIndex]);
                curIndex = startIndex+1;
            };
        }

        if(set.size() > maxLen){
            maxLen = set.size();
        }

        return maxLen;
    }

    //Best Solution
    public int lengthOfLongestSubstringBest(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

}
