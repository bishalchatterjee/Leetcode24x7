class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        if(target.length != arr.length) return false;

        int[] freqMapTarget = new int[1001];
    
        for (int i = 0; i < target.length; i++) {
            freqMapTarget[target[i]]++;
            freqMapTarget[arr[i]]--;
        }

        for(int x : freqMapTarget){
            if(x > 0) return false;
        }

        return true;
    }
}

/*
class Solution {
    public boolean canBeEqual(int[] target, int[] arr) {
        Map<Integer, Integer> freqMapTarget = new HashMap<>();
        Map<Integer, Integer> freqMapArr = new HashMap<>();

        for (int x : target) {
            freqMapTarget.put(x, freqMapTarget.getOrDefault(x, 0) + 1);
        }

        for (int x : arr) {
            freqMapArr.put(x, freqMapArr.getOrDefault(x, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : freqMapArr.entrySet()) {
            int key = entry.getKey();
            int value = entry.getValue();
            if (!freqMapTarget.containsKey(key) || !freqMapTarget.get(key).equals(value)) {
                return false;
            }
        }

        return true;
    }
}

*/