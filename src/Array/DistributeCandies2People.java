package Array;

public class DistributeCandies2People {

    public int[] distributeCandies(int candies, int num_people) {
        int[] res = new int[num_people];

        int i = 0;
        while (i + 1 <= candies) {
            res[i % num_people] += i + 1;
            candies -= i + 1;
            i++;
        }

        if (candies != 0) res[i % num_people] += candies;

        return res;
    }
}
