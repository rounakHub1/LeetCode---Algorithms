class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if (s == null || words == null || words.length == 0) return result;

        int wordLen = words[0].length();
        int wordCount = words.length;
        int totalLen = wordLen * wordCount;
        int sLen = s.length();

        Map<String, Integer> wordFreq = new HashMap<>();
        for (String w : words) {
            wordFreq.put(w, wordFreq.getOrDefault(w, 0) + 1);
        }
        for (int i = 0; i < wordLen; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> seen = new HashMap<>();

            while (right + wordLen <= sLen) {
                String word = s.substring(right, right + wordLen);
                right += wordLen;

                if (wordFreq.containsKey(word)) {
                    seen.put(word, seen.getOrDefault(word, 0) + 1);
                    count++;

                    while (seen.get(word) > wordFreq.get(word)) {
                        String leftWord = s.substring(left, left + wordLen);
                        seen.put(leftWord, seen.get(leftWord) - 1);
                        count--;
                        left += wordLen;
                    }
                    if (count == wordCount) {
                        result.add(left);
                    }

                } else {
                    seen.clear();
                    count = 0;
                    left = right;
                }
            }
        } return result;
    }
}