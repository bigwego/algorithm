class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> res = new ArrayList<>();
		if (candidates == null || candidates.length == 0) {
			return res;
		}
		Arrays.sort(candidates);
		help(res, new ArrayList<>(), candidates, target, 0);
		return res;
	}

	private void help(List<List<Integer>> res, ArrayList arrayList, int[] candidates, int target, int start) {
		if (target == 0) {
			res.add(new ArrayList<>(arrayList));
		}
		for (int i = start; i < candidates.length; i++) {
			if (candidates[i] > target) {
				continue;
			}
			arrayList.add(candidates[i]);
			help(res, arrayList, candidates, target - candidates[i], i);
			arrayList.remove(arrayList.size() - 1);
		}
	}
}
