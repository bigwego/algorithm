package DynamicProgramming;

public class DeleteAndEarn {

    public int deleteAndEarn(int[] nums) {
        int[] value = new int[10001];
        for (int num : nums) value[num] += num;

        int take = 0, skip = 0;

        for (int i = 1; i < 100001; i++) {
            int takei = skip + value[i];
            int skipi = Math.max(skip, take);
            take = takei;
            skip = skipi;
        }

        return Math.max(take, skip);
    }
}
