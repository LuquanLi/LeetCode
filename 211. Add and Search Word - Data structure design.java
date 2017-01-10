public class WordDictionary {

    private TrieNode root;

    WordDictionary() {
        root = new TrieNode();
    }

    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode n = root;
        for(char c: word.toCharArray()){
            if(n.next[c - 'a'] == null){
                n.next[c - 'a'] = new TrieNode();
                n.next[c - 'a'].val = c;
            }
            n = n.next[c - 'a'];
        }
        n.word = word;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        return searchhelper(word, root);
    }

    public boolean searchhelper(String word, TrieNode newroot){
        if(word.equals("") && newroot.word == null) return false;
        TrieNode n = newroot;

        for(int i = 0; i < word.length(); i ++){
            char c = word.charAt(i);

            if(c == '.'){
                for(TrieNode tn: n.next){
                    if(tn != null && searchhelper(word.substring(i + 1), tn)){
                        return true;
                    }
                }
                return false;
            }else if(n.next[c - 'a'] == null){
                return false;
            }else {
                n = n.next[c - 'a'];
            }
        }
        return (n.word != null);
    }
}

class TrieNode {
    TrieNode[] next = new TrieNode[26];
    char val;
    String word;
}

// Your WordDictionary object will be instantiated and called as such:
// WordDictionary wordDictionary = new WordDictionary();
// wordDictionary.addWord("word");
// wordDictionary.search("pattern");