class Solution {
    public int hIndex(int[] citations) {
        if (citations.length == 0) return 0;
        if (citations.length == 1) return citations[0] == 0 ? 0 : 1;

        Arrays.sort(citations);
        int n = citations.length;
        int maxHIndex = 0;

        for (int i = 0; i < n; i++) {
            int countOfCitationsEqualOrGreater = n - i;
            if (countOfCitationsEqualOrGreater >= citations[i]) {
                maxHIndex = Math.max(maxHIndex, citations[i]);
            } else {
                // If countOfCitationsEqualOrGreater < citations[i], the current countOfCitationsEqualOrGreater could be a potential H-index
                maxHIndex = Math.max(maxHIndex, countOfCitationsEqualOrGreater);
            }
        }
        return maxHIndex;
    }
}
