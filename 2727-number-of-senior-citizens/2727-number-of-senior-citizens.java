class Solution {
    public int countSeniors(String[] details) {
        int res = 0;
        for(String person : details){
            if(person.charAt(10) == 'F' || person.charAt(10) == 'M' || person.charAt(10) == 'O'){
                String age = person.substring(11, 13);
                int ageToInt = Integer.valueOf(age);
                
                if(ageToInt > 60) res++;
            }
        }

        return res;
    }
}