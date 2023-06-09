import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WordDictionary {

    private final TrieNode wordDictRoot = new TrieNode();

    public void addWord(String word) {
        char[] wordChars = word.toCharArray();
        TrieNode curr = wordDictRoot;
        for (char charr : wordChars) {
            if (!curr.children.containsKey(charr)) {
                curr.children.put(charr, new TrieNode());
            }
            curr = curr.children.get(charr);
        }
        curr.isEnd = true;
    }

    public boolean search(String word) {
        return recursiveWildcardSearch(wordDictRoot, 0, word);
    }

    private boolean recursiveWildcardSearch(TrieNode root, int index, String word) {
        char[] chars = word.toCharArray();
        TrieNode curr = root;
        for (int i = index; i < chars.length; i++) {
            if (chars[i] == '.') {
                for (Character variant: curr.children.keySet()) {
                    if (recursiveWildcardSearch(curr.children.get(variant), i + 1, word)) {
                        return true;
                    }
                }
                return false;
            } else {
                if (curr.children.containsKey(chars[i])) {
                    curr = curr.children.get(chars[i]);
                } else {
                    return false;
                }
            }
        }
        return curr.isEnd;
    }

    class TrieNode {
        public Map<Character, TrieNode> children = new HashMap<>();
        public boolean isEnd = false;
    }
}
