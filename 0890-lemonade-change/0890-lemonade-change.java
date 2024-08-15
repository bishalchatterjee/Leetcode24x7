//Without HashMap

class Solution {
    public boolean lemonadeChange(int[] bills) {
        int countOfFiveDollarBills=0;
        int countOfTenDollarBills=0;

        for(int bill:bills){
            if(bill==5){
                countOfFiveDollarBills++;
            }else if(bill==10){
                countOfFiveDollarBills--; //provide the $5 change to the customer
                countOfTenDollarBills++;  //take $10 from the customer
            }else if(bill==20){
                //Two possibilities

                //One Way - provide change using one $10 and one $5
                if(countOfFiveDollarBills >=1 && countOfTenDollarBills>=1){
                    countOfFiveDollarBills--;
                    countOfTenDollarBills--;
                }else if(countOfFiveDollarBills >=3){ //Second Way - Provide change using three $5                 
                    countOfFiveDollarBills-=3;
                }else{
                    return false;
                }
            }

            if(countOfFiveDollarBills < 0){
                return false;
            }
        }
        return true;
    }
}
/*

//Using HashMap to keep track of bills 

class Solution {
    public boolean lemonadeChange(int[] bills) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int bill : bills) {
            if (bill == 5) {
                map.put(5, map.getOrDefault(5, 0) + 1);
            } else if (bill == 10) {
                if (map.getOrDefault(5, 0) <= 0) return false;
                map.put(5, map.get(5) - 1);
                map.put(10, map.getOrDefault(10, 0) + 1);
            } else if (bill == 20) {
                if (map.getOrDefault(5, 0) >= 1 && map.getOrDefault(10, 0) >= 1) {
                    map.put(5, map.get(5) - 1);
                    map.put(10, map.get(10) - 1);
                } else if (map.getOrDefault(5, 0) >= 3) {
                    map.put(5, map.get(5) - 3);
                } else {
                    return false;
                }
            }
        }

        return true;
    }
}
*/