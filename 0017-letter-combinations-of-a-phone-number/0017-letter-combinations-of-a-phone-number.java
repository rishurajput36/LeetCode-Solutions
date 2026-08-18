import java.util.*;

class Solution {
    public List<String> letterCombinations(String digits) {

        List<String> result = new ArrayList<>();

        if (digits.length() == 0) {
            return result;
        }

        String[] phone = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
        };

        backtrack(digits, 0, "", result, phone);

        return result;
    }

    private void backtrack(String digits, int index, String current,
                            List<String> result, String[] phone) {

      
        if (index == digits.length()) {
            result.add(current);
            return;
        }

       
        String letters = phone[digits.charAt(index) - '0'];

        for (char ch : letters.toCharArray()) {
            backtrack(
                digits,
                index + 1,
                current + ch,
                result,
                phone
            );
        }
      }
}