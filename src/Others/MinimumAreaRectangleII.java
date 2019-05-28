package Others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinimumAreaRectangleII {

    public double minAreaFreeRect(int[][] points) {
        Map<String, List<int[]>> map = new HashMap<>();
        for (int i = 0, len = points.length; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                long dis = getDis(points[i], points[j]);
                double centerX = (points[i][0] + points[j][0]) / 2;
                double centerY = (points[i][1] + points[j][1]) / 2;
                String key = "" + dis + " " + centerX + " " + centerY;
                map.putIfAbsent(key, new ArrayList<>());
                map.get(key).add(new int[]{ i, j });
            }
        }

        double res = Double.MAX_VALUE;

        for (String key : map.keySet()) {
            if (map.get(key).size() > 1) {
                List<int[]> list = map.get(key);
                for (int i = 0, sz = list.size(); i < sz; i++) {
                    for (int j = i + 1; j < sz; j++) {
                        int[] p1 = points[list.get(i)[0]];
                        int[] p2 = points[list.get(i)[1]];
                        int[] p3 = points[list.get(j)[0]];
                        res = Math.min(res, Math.sqrt(getDis(p1, p2)) * Math.sqrt(getDis(p1, p3)));
                    }
                }
            }
        }

        return res == Double.MAX_VALUE ? 0 : res;
    }

    private long getDis(int[] p1, int[] p2) {
        return (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
    }
}
