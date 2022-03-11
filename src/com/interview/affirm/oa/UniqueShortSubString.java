package com.interview.affirm.oa;

import java.util.*;

/**
 * Given an input list of names, for each name, find the shortest substring that only appears in that name.
 * <p>
 * Example:
 * <p>
 * Input: ["cheapair", "cheapoair", "peloton", "pelican"]
 * Output:
 * "cheapair": "pa"  // every other 1-2 length substring overlaps with cheapoair
 * "cheapoair": "po" // "oa" would also be acceptable
 * "pelican": "ca"   // "li", "ic", or "an" would also be acceptable
 * "peloton": "t"    // this single letter doesn't occur in any other string
 */
public class UniqueShortSubString {

    public static void main(String[] args) {
        String[] input = {"cheapair", "cheapoair", "peloton", "pelican"};
        List<String> list = Arrays.asList("cheapair", "cheapoair", "peloton", "pelican");
        solution(list);
//        System.out.println(compare("abch", "def"));
//        Map<String, String> map = new HashMap<>();
//        for (String s : input) {
//            map.put(s, s);
//            for (int i = 0; i < s.length(); i++) {
//                for (int j = i + 1; j < s.length(); j++) {
//                    String subStr = s.substring(i, j);
//                    boolean valid = true;
//                    for (String s1 : input) {
//                        if (s1.equals(s)) continue;
//                        if (s1.contains(subStr)) {
//                            valid = false;
//                            break;
//                        }
//                    }
//                    if (valid && map.get(s).length() > subStr.length()) {
//                        map.put(s, subStr);
//                    }
//                }
//            }
//        }
//        map.forEach((k, v) -> System.out.println(k + " " + v));
    }

    public static Map<String, String> solution(List<String> list) {
//        final TreeMap<String, Set<Integer>> trie = new TreeMap<>(new StringComparator());

        HashMap<String, Set<Integer>> trie = new HashMap<>();

        for (int i = 0; i < list.size(); ++i) // O(N)
        {
            List<StringBuilder> suffix = new ArrayList<>();
            for (int j = 0; j < list.get(i).length(); ++j) // O(L)
            {
                for (StringBuilder sb : suffix) // O(L)
                {
                    sb.append(list.get(i).charAt(j));
                    trie.putIfAbsent(sb.toString(), new HashSet<>());
                    trie.get(sb.toString()).add(i); // if Map then O(1)..
                }
                StringBuilder sb = new StringBuilder();
                sb.append(list.get(i).charAt(j));
                trie.putIfAbsent(sb.toString(), new HashSet<>());
                trie.get(sb.toString()).add(i);
                suffix.add(sb);
            }
//            System.out.println(suffix);
        }
        ArrayList<String> sortedKeys
                = new ArrayList<String>(trie.keySet());

        Collections.sort(sortedKeys, new StringComparator());
        final Map<String, String> res = new HashMap<>();
        for (String key : sortedKeys) {
            if (trie.get(key).size() > 1) continue;
            int idx = trie.get(key).iterator().next();
            res.putIfAbsent(list.get(idx), key);
        }
//        for (Map.Entry<String, Set<Integer>> entry : trie.entrySet()) {
//            System.out.println(entry.getKey() + "  " + entry.getValue());
//            if (entry.getValue().size() > 1) continue;
//            int idx = entry.getValue().iterator().next();
//            res.putIfAbsent(list.get(idx), entry.getKey());
//        }

        res.forEach((k, v) -> System.out.println(k + " " + v));
        return res;
    }

    public static int compare(String o1, String o2) {
        return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
    }

}

class StringComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        return o1.length() == o2.length() ? o1.compareTo(o2) : o1.length() - o2.length();
    }
}