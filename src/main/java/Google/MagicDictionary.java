package Google;

import Utils.Printer;

public class MagicDictionary {

    Trie root;
    /** Initialize your data structure here. */
    public MagicDictionary() {
        root = new Trie();
    }

    /** Build a dictionary through a list of words */
    public void buildDict(String[] dict) {
        for (String word : dict) {
            Trie node  = root;
            for (char c : word.toCharArray()) {
                if (node.children[c-'a'] == null) {
                    node.children[c-'a'] = new Trie();
                }
                node = node.children[c-'a'];
            }
            node.isWord = true;
        }
    }

    /** Returns if there is any word in the trie that equals to the given word after modifying exactly one character */
    public boolean search(String word) {
        if (word == null || word.length() == 0) { return false; }
        Trie node = root;
        char[] ch = word.toCharArray();
        for (int i=0;i<ch.length;i++) {
            if (node == null) { return false; }
            for (char c ='a';c<='z';c++) {
                if (c != ch[i] && valid(node.children[c-'a'], ch, i+1)) {
                    return true;
                }
            }
            node = node.children[ch[i]-'a'];
        }
        return false;
    }

    private boolean valid(Trie node, char[] ch, int idx) {
        for (int i=idx;i<ch.length;i++) {
            if (node == null) { return false; }
            node = node.children[ch[i]-'a'];
        }
        return node != null && node.isWord;
    }

    public static void main(String[] args) {
        MagicDictionary dictionary = new MagicDictionary();
        String[] dict = {"hello","hallo","leetcode","judge"};
        dictionary.buildDict(dict);
        Printer.printWithExpectResult(dictionary.search("hello"), true);
        Printer.printWithExpectResult(dictionary.search("hallo"), true);
        Printer.printWithExpectResult(dictionary.search("hell"), false);
        Printer.printWithExpectResult(dictionary.search("leetcodd"), true);
        Printer.printWithExpectResult(dictionary.search("aaaaa"), false);
    }

    public class Trie {
        Trie[] children;
        boolean isWord;
        public Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }

}
