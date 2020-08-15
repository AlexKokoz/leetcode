package org.leetcode.problems;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 * MEDIUM
 * 
 * @author Alexandros Kokozidis
 *
 */
public class _000211_AddAndSearchWordDataStructureDesign {
	static class WordDictionary {
		    
		    TrieNode root;

		    /** Initialize your data structure here. */
		    public WordDictionary() {
		        root = new TrieNode();
		    }
		    
		    /** Adds a word into the data structure. */
		    public void addWord(String word) {
		        assert word != null;
		        TrieNode cur = root;
		        for (int i = 0; i < word.length(); i++) {
		            char c = word.charAt(i);
		            cur = cur.putAndGet(c);
		        }
		        cur.flag = true;
		    }
		    
		    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
		    public boolean search(String word) {
		        return search(root, word, 0);
		    }
		    
		    private boolean search(TrieNode node, String s, int d) {
		        if (node == null) return false;
		        if (d == s.length()) return node.flag;
		        char ch = s.charAt(d);
		        if (ch == '.') {
		            for (char key : node.next.keySet()) {
		                if (search(node.next.get(key), s, d + 1)) return true;
		            }
		            return false;
		        } else {
		            return search(node.next.get(ch), s, d + 1);
		        }
		    }
		    
		    private static class TrieNode {
		        private boolean flag;
		        private Map<Character, TrieNode> next;
		        
		        public TrieNode() {
		            next = new HashMap<>();
		        }
		        
		        public TrieNode putAndGet(char c) {
		            TrieNode node = next.get(c);
		            if (node == null) {
		                node = new TrieNode();
		                next.put(c, node);
		            }
		            return node;
		        }
		    } 
		}
}
