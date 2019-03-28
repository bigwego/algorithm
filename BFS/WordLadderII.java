public class Solution {
    /*
     * @param start: a string
     * @param end: a string
     * @param dict: a set of string
     * @return: a list of lists of string
     */
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<String>> graph = new HashMap<>();
        Set<String> words = new HashSet<>(wordList);
        bfs(beginWord, endWord, words, graph);
        List<List<String>> res = new ArrayList<>();
        dfs(res, new ArrayList<String>(Arrays.asList(beginWord)), graph, beginWord, endWord);
        return res;
    }

    private void dfs(List<List<String>> res, ArrayList<String> path, Map<String, List<String>> graph, String currWord, String endWord) {
        if (currWord.equals(endWord)) {
            res.add(new ArrayList<>(path));
            return;
        }
        if (graph.containsKey(currWord)) {
            for (String word : graph.get(currWord)) {
                path.add(word);
                dfs(res, path, graph, word, endWord);
                path.remove(path.size() - 1);
            }
        }
    }

    private void bfs(String beginWord, String endWord, Set<String> words, Map<String, List<String>> graph) {
        LinkedList<String> queue = new LinkedList<>();
        Set<String> visted = new HashSet<>();
        boolean found = false;
        queue.add(beginWord);
        visted.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            Set<String> toAdd = new HashSet<>();
            for (int i = 0; i < size; i++) {
                String currWord = queue.poll();
                char[] chs = currWord.toCharArray();
                for (int j = 0; j < chs.length; j++) {
                    char old = chs[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c != old) {
                            chs[j] = c;
                            String newWord = new String(chs);
                            if (!visted.contains(newWord) && words.contains(newWord)) {
                                if (endWord.equals(newWord)) {
                                    found = true;
                                }
                                if (!toAdd.contains(newWord)) {
                                    toAdd.add(newWord);
                                    queue.add(newWord);
                                }
                                if (!graph.containsKey(currWord)) {
                                    graph.put(currWord, new ArrayList<>());
                                }
                                graph.get(currWord).add(newWord);
                            }
                            chs[j] = old;
                        }
                    }
                }
            }
            if (found) {
                break;
            }
            visted.addAll(toAdd);
        }
    }
}
