package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        List<Integer>[] freqs = new List[nums.length + 1];
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            int freq = entry.getValue();
            if (freqs[freq] == null) {
                freqs[freq] = new ArrayList<>();
            }
            freqs[freq].add(entry.getKey());
        }
        List<Integer> res = new ArrayList<>();
        for (int i = freqs.length - 1; i > -1 && k > 0; i--) {
            if (freqs[i] != null) {
                res.addAll(freqs[i]);
                k -= freqs[i].size();
            }
        }
        return res;
    }

    public List<Integer> topKFrequent2(int[] nums, int k) {
        List<Integer> res = new ArrayList<>();
        List<Integer>[] freqs = new List[nums.length + 1];
        Map<Integer, Integer> cnts = new HashMap<>();

        for (int num : nums)
            cnts.put(num, cnts.getOrDefault(num, 0) + 1);

        for (int num : cnts.keySet()) {
            int freq = cnts.get(num);
            if (freqs[freq] == null) freqs[freq] = new ArrayList<>();
            freqs[freq].add(num);
        }

        for (int i = freqs.length - 1; i > -1; i--) {
            if (freqs[i] == null) continue;
            for (int num : freqs[i])
                res.add(num);
            k -= freqs[i].size();
            if (k < 0) break;
        }

        return res;
    }
}
