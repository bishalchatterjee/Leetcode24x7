class Pair{
    int element;
    int freq;

    Pair(int element, int freq){
        this.element = element;
        this.freq = freq;
    }
}

class Solution {
    public int[] frequencySort(int[] nums) {
        int n = nums.length;
        Pair[] eleWithFreq = new Pair[n];
        
        int[] freqArray = new int[201];

        // Count the frequencies of each number
        for (int num : nums) {
            if (num >= -100 && num <= 100) {
                freqArray[num + 100]++; // Offset by 100 to handle negative indices
            }
        }

        int index = 0;
        for (int num : nums){
            eleWithFreq[index] = new Pair(num, freqArray[num + 100]);
            index++;
        }   

        Arrays.sort(eleWithFreq, (x, y) -> x.freq != y.freq ? x.freq - y.freq : y.element - x.element);
    
        int[] res = new int[n];
        index = 0;
        for(Pair ele : eleWithFreq){
            res[index] = ele.element;
            index++;
        }

        return res;
    }
}