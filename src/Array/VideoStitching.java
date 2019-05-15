package Array;

import java.util.Arrays;
import java.util.Comparator;

public class VideoStitching {

    public int videoStitching(int[][] clips, int T) {
        Arrays.sort(clips, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            }
        });
        int len = clips.length;
        if (clips[0][0] > 0 || clips[len - 1][1] < T) {
            return -1;
        }

        int res = 1;
        int end = clips[0][1];
        int[] prev = clips[0];
        for (int i = 1; i < len; i++) {
            if (end < clips[i][0]) {
                return -1;
            }
            if (clips[i][1] == end) {
                prev = clips[i];
                continue;
            } else if (clips[i][0] <= prev[0]) {
                end = clips[i][1];
                prev = clips[i];
                continue;
            } else {
                res++;
                end = clips[i][1];
                prev = clips[i];
            }
        }

        return res;
    }
}
