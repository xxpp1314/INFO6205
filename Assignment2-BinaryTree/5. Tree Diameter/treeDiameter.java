class Solution {
    int res = 0;
    HashMap<Integer, List<Integer>> map = new HashMap();
    public int treeDiameter(int[][] edges) {
        int n = edges.length;
        for(int i = 0; i <= n; i++){
            map.put(i, new ArrayList());
        }
        for(int[] node: edges) {
            map.get(node[0]).add(node[1]);
            map.get(node[1]).add(node[0]);
        }
        dfs(0, new boolean[n + 1]);
        return res;
    }

    public int dfs(int index, boolean[] visited) {
        if(visited[index]){
            return 0;
        }
        visited[index] = true;
        int max1 = 0;
        int max2 = 0;
        for(Integer nei: map.get(index)) {
            int val = dfs(nei, visited);
            if(val > max1) {
                max2 = max1;
                max1 = val;
            } else if(val > max2) {
                max2 = val;
            }     
        }
        res = Math.max(res, max1 + max2);
        return Math.max(max1, max2) + 1;
    }
}
