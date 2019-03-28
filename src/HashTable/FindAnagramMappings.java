public class FindAnagramMappings {
    /**
     * @param A: lists A
     * @param B: lists B
     * @return: the index mapping
     */
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0, len = B.length; i < len; i++) {
            map.put(B[i], i);
        }
        int[] res = new int[A.length];
        for (int i = 0, len = res.length; i < len; i++) {
            res[i] = map.get(A[i]);
        }
        return res;
    }
}
