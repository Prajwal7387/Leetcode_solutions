class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> ans = new ArrayList<>();

        Arrays.sort(candidates);

        solve(candidates, target, 0, new ArrayList<>(), ans);

        return ans;
    }

    private void solve(int[] nums, int target, int start,
                       List<Integer> list, List<List<Integer>> ans) {

        if (target == 0) {
            ans.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < nums.length; i++) {

            if (i > start && nums[i] == nums[i - 1])
                continue;

            if (nums[i] > target)
                break;

            list.add(nums[i]);

            solve(nums, target - nums[i], i + 1, list, ans);

            list.remove(list.size() - 1);
        }
    }
}