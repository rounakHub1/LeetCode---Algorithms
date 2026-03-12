class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> indx = new ArrayList<>();
        if (s == null || s.length() == 0 || words == null || words.length == 0) {
            return indx;
        }

        int ln = words[0].length();
        int totalWords = words.length;
        int sln = s.length();

        // 1. Build the Target Inventory
        Map<String, Integer> inventory = new HashMap<>();
        for (String w : words) {
            inventory.put(w, inventory.getOrDefault(w, 0) + 1);
        }

        // 2. We shift the starting point from 0 to ln-1 to catch all word alignments
        for (int i = 0; i < ln; i++) {
            Map<String, Integer> count = new HashMap<>();
            int left = i;
            int wordsMatched = 0;

            // 3. Move the 'right' pointer across the string in steps of 'ln'
            for (int right = i; right <= sln - ln; right += ln) {
                String sub = s.substring(right, right + ln);

                if (inventory.containsKey(sub)) {
                    // Update our current window's count
                    count.put(sub, count.getOrDefault(sub, 0) + 1);
                    wordsMatched++;

                    // 4. If we have too many of 'sub', shrink from the left until valid
                    // This prevents NullPointerExceptions by checking keys safely
                    while (count.get(sub) > inventory.get(sub)) {
                        String leftWord = s.substring(left, left + ln);
                        count.put(leftWord, count.get(leftWord) - 1);
                        wordsMatched--;
                        left += ln;
                    }

                    // 5. Success: the window size matches our word count requirements
                    if (wordsMatched == totalWords) {
                        indx.add(left);
                    }
                } else {
                    // 6. Found a word not in our list: Clear the window and start over
                    count.clear();
                    wordsMatched = 0;
                    left = right + ln;
                }
            }
        }
        return indx;
    }
}