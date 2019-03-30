package Others;

/**
 * The rand7() API is already defined in the parent class SolBase.
 * public int rand7();
 */
public class ImplementRand10UsingRand7 extends SolBase {

    /**
     * @return a random integer in the range 1 to 7
     */
    public int rand10() {
        int result = 40;
        while (result >= 40) {
            result = 7 * (rand7() - 1) + rand7() - 1;
        }
        return result % 10 + 1;
    }

    private int rand7() {
        return 0;
    }
}

class SolBase {}
