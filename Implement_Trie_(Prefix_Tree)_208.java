class TrieNode {
    // Initialize your data structure here.
    char word ;
    boolean leaf;
    HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>() ;
    public TrieNode() {
        word = ' ' ;
    }
    public TrieNode(char c) {
        word = c ;
    }
}

public class Trie {
    
    private String __author__ = "tangjialiang" ;
    private String __V__ = "success_V" ;
    private String tips = "注意TrieNode"
    
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        Map<Character, TrieNode> children = root.children ;
        for(int i=0; i<word.length(); i++) {
            char c = word.charAt(i) ;
            
            TrieNode t = null ;
            if (children.containsKey(c)) {
                // t = children.get(c).children ;
                t = children.get(c) ;
            } else {
                // TrieNode tempNode = new TrieNode(c) ;
                // children.put(c, tempNode) ;
                // children = tempNode.children ;
                // if (i==word.length()-1) tempNode.leaf = true ;
                t = new TrieNode(c) ;
                children.put(c, t) ;
            }
            children = t.children ;
            if (i==word.length()-1) t.leaf = true ;
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        Map<Character, TrieNode> children = root.children ;
        TrieNode node = null ;
        for (int i=0; i<word.length(); i++) {
            char c = word.charAt(i) ;
            if (children.containsKey(c)) {
                node = children.get(c) ;
                children = node.children ;
            } else {
                return false ;
            }
        }
        return (node!=null) && (node.leaf==true) ;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        Map<Character, TrieNode> children = root.children ;
        TrieNode node = null ;
        
        for (int i=0; i<prefix.length(); i++) {
            char c = prefix.charAt(i) ;
            if (children.containsKey(c)) {
                node = children.get(c) ;
                children = node.children ;
            } else {
                return false ;
            }
        }
        return (node!=null);
    }
}

// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");
