package x.godk.leetcode.middle;


import java.util.ArrayList;
import java.util.List;

/**
 * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
 * <p>
 * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
 * <p>
 * L   C   I   R
 * E T O E S I I G
 * E   D   H   N
 * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
 * <p>
 * 请你实现这个将字符串进行指定行数变换的函数：
 * <p>
 * string convert(string s, int numRows);
 * 示例 1:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 3
 * 输出: "LCIRETOESIIGEDHN"
 * 示例 2:
 * <p>
 * 输入: s = "LEETCODEISHIRING", numRows = 4
 * 输出: "LDREOEIIECIHNTSG"
 * 解释:
 * <p>
 * L     D     R
 * E   O E   I I
 * E C   I H   N
 * T     S     G
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/zigzag-conversion
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author wt
 * @program practice
 * @create 2020-07-14  14:53
 */
public class ZConvert {

    public static void main(String[] args) {
        String str = "LEETCODEISHIRING";
        String s = solution5(str, 4);
        String result = "LDREOEIIECIHNTSG";
        System.out.println(result.equals(s));
    }


    static String solution1(String str, int row) {
        if (str == null || str.length() == 0) {
            return "";
        }
        if (row >= str.length()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        String[] strs = new String[row];
        if (row == 1) {
            return str;
        }
        if (row == 2) {
            for (int i = 0; i < str.length(); i++) {
                String s = strs[i % 2];
                if (s == null) {
                    s = "";
                }
                strs[i % 2] = s += str.charAt(i);
            }
            for (String s : strs) {
                sb.append(s);
            }
            return sb.toString();
        }
        // 二维数组
        List<Character[]> list = new ArrayList<>();
        Character[] characters = new Character[row];
        list.add(characters);
        boolean change = false;
        int flag = row - 1;
        for (int i = 0; i < str.length(); i++) {

            // 此时接下来的 数组为满编数组
            if (i <= flag) {
                characters[i] = str.charAt(i);
                continue;
            } else if (i % flag == 0 && i / flag % 2 == 0) {
                characters = new Character[row];
                list.add(characters);
                change = true;
            } else if (i % flag == 0 && i / flag % 2 == 1) {
                change = false;
            } else if (!change) {
                characters = new Character[row];
                list.add(characters);
            }
            if (change) {
                characters[i % flag] = str.charAt(i);
            } else {
                characters[flag - i % flag] = str.charAt(i);
            }
        }

        int index;
        for (Character[] characters1 : list) {
            index = 0;
            for (Character character : characters1) {
                if (character != null) {
                    String s = strs[index];
                    if (s == null) {
                        s = "";
                    }
                    strs[index++] = s += character;
                } else {
                    index++;
                }
            }
        }

        for (String s : strs) {
            sb.append(s);
        }
        return sb.toString();

    }


    static String solution2(String s, int row) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (row >= s.length()) {
            return s;
        }
        if (row == 1) {
            return s;
        }
        if (row == 2) {
            // 奇数
            StringBuilder s1 = new StringBuilder();
            //偶数
            StringBuilder s2 = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i % 2 == 0) {
                    s1.append(c);
                } else {
                    s2.append(c);
                }
            }

            return s1.append(s2).toString();
        }

        int flag = row - 1;
        int len = s.length();
        Character[][] characters = new Character[row][len];
        for (int i = 0; i < row; i++) {
            Character[] c1 = new Character[len];
            characters[i] = c1;
        }

        int rows = 0;
        boolean change = false;
        for (int i = 0; i < s.length(); i++) {
            if (i <= flag) {
                characters[flag - i][rows] = s.charAt(i);
                continue;
            } else if (i % flag == 0 && i / flag % 2 == 0) {
                change = true;
                rows++;
            } else if (i % flag == 0 && i / flag % 2 == 1) {
                change = false;
            } else if (!change) {
                rows++;
            }
            if (change) {
                characters[flag - i % flag][rows] = s.charAt(i);
            } else {
                characters[i % flag][rows] = s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();


        for (int i = characters.length - 1; i >= 0; i--) {
            for (Character character : characters[i]) {
                if (character != null) {
                    sb.append(character);
                }
            }
        }

        return sb.toString();


    }


    static String solution3(String s, int row) {
        if (s == null || s.length() == 0) {
            return "";
        }
        if (row >= s.length()) {
            return s;
        }
        if (row == 1) {
            return s;
        }
        if (row == 2) {
            // 奇数
            StringBuilder s1 = new StringBuilder();
            //偶数
            StringBuilder s2 = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i % 2 == 0) {
                    s1.append(c);
                } else {
                    s2.append(c);
                }
            }

            return s1.append(s2).toString();
        }

        int flag = row - 1;
        String[] characters = new String[row];
        boolean change = false;
        for (int i = 0; i < s.length(); i++) {
            if (i <= flag) {
                String c = characters[flag - i] == null ? "" : characters[flag - i];
                characters[flag - i] = c + s.charAt(i);
                continue;
            } else if (i % flag == 0 && i / flag % 2 == 0) {
                change = true;
            } else if (i % flag == 0 && i / flag % 2 == 1) {
                change = false;
            } else if (!change) {
            }
            if (change) {
                String content = characters[flag - i % flag] == null ? "" : characters[flag - i % flag];
                characters[flag - i % flag] = content + s.charAt(i);
            } else {
                String content = characters[i % flag] == null ? "" : characters[i % flag];
                characters[i % flag] = content + s.charAt(i);
            }
        }
        StringBuilder sb = new StringBuilder();


        for (int i = characters.length - 1; i >= 0; i--) {
            sb.append(characters[i]);
        }

        return sb.toString();


    }


    /**
     * 官解1
     *
     * @param s
     * @param numRows
     * @return
     */
    static String solution4(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
        for (int i = 0; i < Math.min(numRows, s.length()); i++) {
            rows.add(new StringBuilder());
        }
        int curRow = 0;
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder row : rows) {
            ret.append(row);
        }
        return ret.toString();
    }


    static String solution5(String s, int numRows) {
        if (s.length() <= 1) {
            return s;
        }
        List<StringBuilder> rows = new ArrayList<>();
// 确定 有多少行，有多少行那么添加多少行的 StringBuilder ，放置每一行的数据
        for (int i = 0; i < Math.min(s.length(), numRows); i++) {
            rows.add(new StringBuilder());
        }
        // 当前行标记
        int curRow = 0;
        // 是否向下移动行号
        boolean down = false;
        char[] chars = s.toCharArray();
        for (char c : chars) {
            // 根据当前行号获取 每一行的 StringBuilder
            rows.get(curRow).append(c);
            if (curRow == 0 || curRow == numRows - 1) {
                // 行号为0 和最后一行时 切换方向行号移动方向
                down = !down;
            }
            // 向下移动 行号+1 向上移动 行号-1
            curRow += down ? 1 : -1;
        }
        StringBuilder sb = new StringBuilder();
        for (StringBuilder row : rows) {
            sb.append(row);
        }
        return sb.toString();
    }


}
