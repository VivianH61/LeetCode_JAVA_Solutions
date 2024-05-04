/* Optimized backtrack
 * Only generate the first half of the palindrome. Then append the reversed string to the frst
 * half to generate the whole palindrome.
 * Save the frequancy of every characters in the string, then halve the frequency. If any character
 * is of odd frequency, save this character seperately as the midCharacter. If more than one 
 * character has odd frequency, then it is impossible to form a palindrome, return an empty list.
 * 
 */

public class Solution {
    Set <String> set = new HashSet<>();
    public List < String > generatePalindromes(String s) {
        char[] chArr = s.toCharArray();
        HashMap<Character, Integer> counter = new HashMap<Character, Integer>();
        List<int[]> counterList = new ArrayList<>();
        char[] half_s = new char[s.length() / 2];
        char mid_ch = 0;
        boolean hasMid = false;
        int k = 0;
        for (char ch : chArr) {
            counter.put(ch, counter.getOrDefault(ch, 0) + 1);
        }
        
        for (Map.Entry<Character, Integer> set : counter.entrySet()) {
            if (set.getValue() % 2 == 1) {
                if (hasMid) { return new ArrayList<String>(); }
                mid_ch = set.getKey();
                hasMid = true;
            }
            
            for (int i = 0; i < set.getValue() / 2; i++) {
                half_s[k++] = set.getKey();
            }
        }
        
        permute(half_s, 0, mid_ch);
        return new ArrayList < String > (set);
    }

    public void swap(char[] s, int i, int j) {
        char temp = s[i];
        s[i] = s[j];
        s[j] = temp;
    }
    void permute(char[] s, int l, char ch) {
        if (l == s.length) {
            set.add(new String(s) + (ch == 0 ? "" : ch) + new StringBuffer(new String(s)).reverse());
        } else {
            for (int i = l; i < s.length; i++) {
                if (s[l] != s[i] || l == i) {
                    swap(s, l, i);
                    permute(s, l + 1, ch);
                    swap(s, l, i);
                }
            }
        }
    }
}
