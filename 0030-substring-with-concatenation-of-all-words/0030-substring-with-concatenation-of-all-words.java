

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();

        if (s.length() == 0 || words.length == 0) {
            return result;
        }

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;

        if (s.length() < totalLen) {
            return result;
        }

       
        HashMap<String, Integer> wordMap = new HashMap<>();

        for (String word : words) {
            wordMap.put(word, wordMap.getOrDefault(word, 0) + 1);
        }

      
        for (int offset = 0; offset < wordLen; offset++) {

            int left = offset;
            int right = offset;
            int count = 0;

            HashMap<String, Integer> currentMap = new HashMap<>();

            while (right + wordLen <= s.length()) {

                String word = s.substring(right, right + wordLen);
                right += wordLen;

             
                if (wordMap.containsKey(word)) {

                    currentMap.put(
                        word,
                        currentMap.getOrDefault(word, 0) + 1
                    );

                    count++;

                   
                    while (currentMap.get(word) > wordMap.get(word)) {

                        String leftWord =
                            s.substring(left, left + wordLen);

                        currentMap.put(
                            leftWord,
                            currentMap.get(leftWord) - 1
                        );

                        left += wordLen;
                        count--;
                    }

                   
                    if (count == wordCount) {
                        result.add(left);
                    }

                } else {

                
                    currentMap.clear();
                    count = 0;
                    left = right;
                }
            }
        }

        return result;
    }
}