package Graph;

public class SatisfiabilityOfEqualityEquations {

    private final int[] uf = new int[26];

    public boolean equationsPossible(String[] equations) {
        for (int i = 0; i < 26; i++) {
            uf[i] = i;
        }
        for (String eq : equations) {
            if (eq.charAt(1) == '=') {
                int p1 = findParent(eq.charAt(0) - 26);
                int p2 = findParent(eq.charAt(3) - 26);
                uf[p1] = p2;
            }
        }

        for (String eq : equations) {
            if (eq.charAt(1) == '!') {
                int p1 = findParent(eq.charAt(0) - 26);
                int p2 = findParent(eq.charAt(3) - 26);
                if (p1 == p2) {
                    return false;
                }
            }
        }
        return true;
    }

    private int findParent(int i) {
        while (i != uf[i]) {
            i = uf[i];
        }
        return i;
    }
}
