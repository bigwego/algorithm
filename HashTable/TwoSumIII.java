class TwoSumIII {

        private Map<Integer, Integer> map = new HashMap();

        /**
         * @param number: An integer
         * @return: nothing
         */
        public void add(int number) {
            map.put(number, map.getOrDefault(number, 0) + 1);
        }

        /**
         * @param value: An integer
         * @return: Find if there exists any pair of numbers which sum is equal to the value.
         */
        public boolean find(int value) {
            for (int num : map.keySet()) {
                int o_num = value - num;
                if ((o_num == num && map.get(num) >= 2) || (o_num != num && map.containsKey(o_num)))
                    return true;
            }
            return false;
        }
    }
