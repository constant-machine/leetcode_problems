public class Main {
    public static void main(String[] args) {
        var dict = new WordDictionary();
        dict.addWord("bad");
        dict.addWord("dad");
        dict.addWord("mad");
        assert !dict.search("pad"); // false
        assert dict.search("bad"); // true
        assert dict.search(".ad"); // true
        assert dict.search("ba."); // true
        assert dict.search("b.."); // true

        dict = new WordDictionary();
        dict.addWord("at");
        dict.addWord("and");
        dict.addWord("an");
        dict.addWord("add");
        assert !dict.search("a");   // false
        assert !dict.search(".at"); // false
        dict.addWord("bat");
        assert dict.search(".at"); // true
        assert dict.search("an."); // true
        assert !dict.search("a.d.");// false
        assert !dict.search("b.");  // false
        assert dict.search("a.d"); // true
        assert !dict.search(".");   // false

        dict = new WordDictionary();
        dict.addWord("a");
        dict.addWord("ab");
        assert dict.search("a");   // true
        assert dict.search("a.");  // true
        assert dict.search("ab");  // true
        assert !dict.search(".a");  // false
        assert dict.search(".b");  // true
        assert !dict.search("ab."); // false
        assert dict.search(".");   // true
        assert dict.search("..");  // true

        dict.addWord("abd");
        assert dict.search("..d");  // true
        dict.addWord("abdc");
        assert dict.search("a..c");  // true
        assert !dict.search("a.c.");  // false
        assert dict.search("a.d.");  // true
        dict.addWord("abdcf");
        dict.addWord("sbdcf");
        dict.addWord("abdc");
        assert dict.search("a.d.f");  // true
        assert dict.search("..dc");   // true
        assert dict.search("ab..");   // true
        assert dict.search("abd..");   // true
        assert !dict.search("sba..");   // false
        assert !dict.search("ab.d.");   // false
        dict.addWord("sbafc");
        dict.addWord("abddc");
        assert dict.search("sba..");   // true
        assert dict.search("ab.d.");   // true
    }
}