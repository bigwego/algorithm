/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class FindTheCelebrity extends Relation {
    /**
     * @param n a party with n people
     * @return the celebrity's label or -1
     */
    public int findCelebrity(int n) {
        int c = 0;
        for (int i = 1; i < n; i++) {
            if (knows(c, i)) {
                c = i;
            }
        }
        for (int i = 0; i < n; i++) {
            if (i == c) {
                continue;
            }
            if (knows(c, i) || !knows(i, c)) {
                return -1;
            }
        }
        return c;
    }
}
