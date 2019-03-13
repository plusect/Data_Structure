package cn.plusect;

/**
 * Trie树
 */
public class Trie {
    // 存储无意义字符
    private TrieNode root = new TrieNode('/');

    // 往 Trie 树中插入一个字符串
    public void insert(char[] text){

    }

    // 在 Trie 树中查找一个字符串
    public boolean find(char[] patern){
        return false;
    }

    class TrieNode{
        public char data;
        public TrieNode[] children = new TrieNode[26];
        public boolean isEndingChar = false;

        public TrieNode(char data) {
            this.data = data;
        }
    }
}
