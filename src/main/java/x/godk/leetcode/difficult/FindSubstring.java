package x.godk.leetcode.difficult;

import java.util.*;

/**
 *
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 *
 *  
 *
 * 示例 1：
 *
 * 输入：
 *   s = "barfoothefoobarman",
 *   words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。
 * 示例 2：
 *
 * 输入：
 *   s = "wordgoodgoodgoodbestword",
 *   words = ["word","good","best","word"]
 * 输出：[]
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author wt
 * @program practice
 * @create 2021-03-02  15:23
 */
public class FindSubstring {

    public static void main(String[] args) {

        List<Integer> barfoothefoobarman = solution4("aaaaaaaaaaaaaa", new String[]{"aa","aa"});
        System.out.println(barfoothefoobarman);
    }

    public static List<Integer> solution1(String s, String[] words){
    List<Integer> vals = new ArrayList<>();
        int len = s.length();

        if(words==null||words.length==0 ){
            return new ArrayList<>(0);
        }
        int wordsLen =  words[0].length() * words.length;
        int i = 0;
        if(len < wordsLen){
            return new ArrayList<>(0);
        }
        char[] chars = s.toCharArray();
        while (i < len && wordsLen <= len - i ){
           int j = i;
           List<String> wordList = Arrays.asList(words);
            boolean index =  match(chars,j,wordList);
            if(index){
                vals.add(i);
            }
            i++;
        }
        return vals;
    }

    public static boolean match(char[] chars ,int i,List<String> words ){
        if(words.size()==0){
            return true;
        }
        if(i>=chars.length){
            return false;
        }
        int j = i;

        for (int m =0; m<words.size() ;m++) {
            String word = words.get(m);
            int index = 0;
            while(index < word.length()  && word.charAt(index) ==chars[i]){
        i++;
        index++;
            }
            if(index == word.length()){
                //单词匹配
                List<String> wordList = new ArrayList<>(words);
                wordList.remove(m);
              return  match(chars,i,wordList);
            }else{
                i = j;
            }
        }
        return false;

    }




    public static List<Integer> solution4(String s, String[] words){
        List<Integer> result = new ArrayList<>();
        if(words==null || words.length==0 || s==null || s.length()==0){
            return result;
        }
        int len = s.length();
        int wordLen = words[0].length();
        int allLen =wordLen* words.length;
        if(len < allLen){
            return result;
        }
        // 自己实现 双指针移动
        Map<String,Integer> param = new HashMap<>(words.length);
        for (String word : words) {
            Integer num = param.computeIfAbsent(word, x -> 0);
            param.put(word,num+1);
        }
        Map<String,Integer> tmp = new HashMap<>(param.size());
        for(int i=0;i< wordLen;i++){
            int left = i; int right = i;
            // 当前共有多少个单词 组成的字符串,当字符串个数等于给定的数组个数时，符合条件返回左指针
            int count = 0;
          while(left <= right && right <= s.length()-wordLen){
              String word = s.substring(right,right+wordLen);
              // 窗口向右移动一位
              right +=wordLen;
              if(param.containsKey(word)){
                  Integer orDefault = tmp.getOrDefault(word, 0);
                  tmp.put(word,orDefault+1);
                  count++;
                  if(tmp.get(word) > param.get(word)){
                      // 此时 tmp内word数量超过 param中的数量，说明 left -> right 这一段字符串 多出了一个单词。 此时left->right字符串并不符合要求，所以左侧指针向右移动一个单词继续匹配，同时一除掉最左侧的单词
                      String leftWord = s.substring(left,left+wordLen);
                      tmp.put(leftWord,tmp.get(leftWord) -1);
                      count--;
                      left = left+wordLen;
                  }
                  if(count == words.length){
                      // 单词数量匹配 正确
                      result.add(left);
                  }
              }else{
                  // 没有这个单词，不能以这个单词开头, left ->right 因为中间有存在不合格字符串 这一段字符串都不合格，left直接跳到right指针
                  tmp.clear();
                  count=0;
                  left=right;
              }

          }
          tmp.clear();
        }
return result;


    }
    public static List<Integer> solution2(String s, String[] words){
        List<Integer> result = new ArrayList<>();
        if(words==null || words.length==0 || s==null || s.length()==0){
            return result;
        }
        int len = s.length();
        int wordLen = words[0].length();
        int allLen =wordLen* words.length;
        if(len < allLen){
            return result;
        }
        Map<String,Integer> param = new HashMap<>(words.length);
        for (String word : words) {
            Integer num = param.computeIfAbsent(word, x -> 0);
            param.put(word,num+1);
        }
        Map<String,Integer> tmp = new HashMap<>(words.length);
        for(int i=0;i< len && i<= len-allLen;i++){
            int index = i;

            while(index < len && index <= len-wordLen){
                String word = s.substring(index,index + wordLen);
                Integer num = tmp.computeIfAbsent(word, x -> 0);
                tmp.put(word,num+1);
                index = index + wordLen;
                if(!param.containsKey(word)){
                    tmp.clear();
                    break;
                }
                if(tmp.size()>param.size()){
                    tmp.clear();
                    break;
                }
                if(tmp.equals(param)){
                    result.add(i);
                    tmp.clear();
                    break;
                }
            }
            tmp.clear();

        }
        return result;
    }

/**
 * 功能描述: <br>
 * 〈〉  大概意思：  滑动窗口 维持一段字符串 如果 对比字符串是否符合条件，移动右指针 一旦出现不匹配那么移除 最左侧的一个单词，左指针向右移动一个单词
 * @param s
 * @param words
 * @return java.util.List<java.lang.Integer>
 * @author weitao
 * @date 2021/3/3 10:08
 */
    public static List<Integer> solution3(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) return res;
        HashMap<String, Integer> map = new HashMap<>();
        int oneWord = words[0].length();
        int wordNum = words.length;
        int allLen = oneWord * wordNum;
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        for (int i = 0; i < oneWord; i++) {
            int left = i, right = i, count = 0;
            HashMap<String, Integer> tmpMap = new HashMap<>();
            while (right + oneWord <= s.length()) {
                String w = s.substring(right, right + oneWord);
                right += oneWord;
                if (!map.containsKey(w)) {
                    count = 0;
                    left = right;
                    tmpMap.clear();
                } else {
                    tmpMap.put(w, tmpMap.getOrDefault(w, 0) + 1);
                    count++;
                    while (tmpMap.getOrDefault(w, 0) > map.getOrDefault(w, 0)) {
                        String tW = s.substring(left, left + oneWord);
                        count--;
                        tmpMap.put(tW, tmpMap.getOrDefault(tW, 0) - 1);
                        left += oneWord;
                    }
                    if (count == wordNum) res.add(left);
                }
            }
        }
        return res;
    }


}
