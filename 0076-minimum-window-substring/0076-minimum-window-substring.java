class Solution {
    public String minWindow(String str, String target) {
        if(target.length() > str.length()) return "";
        
        int startIdx=0;

        Map<Character, Integer> freqMap=new HashMap<>();

        for(char ch:target.toCharArray()){
            freqMap.put(ch, freqMap.getOrDefault(ch, 0)+1);
        }

        int minLen=Integer.MAX_VALUE;

        int start=0;
        int end=0;
        
        int numOfUniqueCharactersFromTarget=freqMap.size(); //unique characters count

        while(end < str.length()){
            if(freqMap.containsKey(str.charAt(end))){
                freqMap.put(str.charAt(end), freqMap.get(str.charAt(end))-1);

                if(freqMap.get(str.charAt(end))==0){
                   numOfUniqueCharactersFromTarget--;
                }
            }
            
            if(numOfUniqueCharactersFromTarget==0){
                while(numOfUniqueCharactersFromTarget==0){
                    if(freqMap.containsKey(str.charAt(start))){
                        freqMap.put(str.charAt(start), freqMap.get(str.charAt(start)) + 1);

                        if(freqMap.get(str.charAt(start))==1){
                            numOfUniqueCharactersFromTarget++;

                            if(end-start+1 < minLen){
                                minLen=end-start+1;
                                startIdx=start;
                            }
                        }
                    }
                    start++;
                }
            }
            end++;
        }

        return minLen != Integer.MAX_VALUE ? str.substring(startIdx, startIdx + minLen) : "";
    }
}
