import java.util.HashMap;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null) return s == t;
        if (s.length() != t.length()) return false;

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            Integer cnt = map.get(c);
            if (cnt == null) return false;
            if (cnt == 1) map.remove(c);
            else map.put(c, cnt - 1);
        }

        return map.isEmpty();
    }

    public static void main(String[] args) {
        IsAnagram sol = new IsAnagram();
        System.out.println(sol.isAnagram("anagram", "nagaram")); // true
        System.out.println(sol.isAnagram("rat", "car")); // false
        System.out.println(sol.isAnagram("a", "ab")); // false
        System.out.println(sol.isAnagram("", "")); // true
        System.out.println(sol.isAnagram(null, null)); // true
        System.out.println(sol.isAnagram(null, "a")); // false
    }
}
