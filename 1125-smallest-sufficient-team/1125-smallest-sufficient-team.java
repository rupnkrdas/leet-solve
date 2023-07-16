class Solution {
    Map<String, Integer> dp = new HashMap<>();
    int n, m;
    Map<String, Integer> skills = new HashMap<>();
    int target_mask = 0;
    List<Integer> res = new ArrayList<>();
    private void solve(int idx, int[] people_skill, List<Integer> temp, int mask) {
        if (idx == m) {
            if (mask == target_mask) {
                if (res.size() == 0 || temp.size() <= res.size()) {
                    res = new ArrayList<>(temp);
                }
            }

            return;
        }

        // pruning
        if (res.size() != 0 && temp.size() > res.size()) {
            return;
        }

        String key = Integer.toString(idx) + "," + Integer.toString(mask);
        if (dp.containsKey(key)) {
            if (dp.get(key) <= temp.size()) return;
        }

        // not-take
        solve(idx + 1, people_skill, temp, mask);

        // take
        // take only if current person has at least some skill
        if ((mask | people_skill[idx]) != mask) {
            temp.add(idx);
            solve(idx + 1, people_skill, temp, mask | people_skill[idx]);
            temp.remove(temp.size() - 1);
        }

        dp.put(key, temp.size());
    }
    public int[] smallestSufficientTeam(String[] req_skills, List<List<String>> people) {
        n = req_skills.length;
        m = people.size();

        for (int i = 0; i < req_skills.length; i++) { // skill -> unique number index
            String skill_name = req_skills[i];
            skills.put(skill_name, i);
        }

        int[] people_skill = new int[m];
        for (int i = 0; i < m; i++) {
            int skill_bit = 0;
            for (String skill : people.get(i)) {
                skill_bit |= (1 << skills.get(skill));
            }
            people_skill[i] = skill_bit;
        }

        target_mask = (int)(Math.pow(2, n)) - 1;
        
        solve(0, people_skill, new ArrayList<>(), 0);

        int[] ans = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            ans[i] = res.get(i);
        }

        return ans;
    }
}