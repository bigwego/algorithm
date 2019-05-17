package Array;

import java.util.Arrays;

public class Boats2SavePeople {

    public int numRescueBoats(int[] people, int limit) {
        Arrays.sort(people);
        int len = people.length;
        int l = 0;
        int r = len - 1;
        int res = 0;
        while (l <= r) {
            if (people[l] + people[r] <= limit) {
                l++;
            }
            r--;
            res++;
        }

        return res;
    }
}
