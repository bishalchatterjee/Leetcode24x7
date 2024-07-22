class Pair{
    String name;
    int height;

    Pair(String name, int height){
        this.name = name;
        this.height = height;
    }
}

class Solution {
    public String[] sortPeople(String[] names, int[] heights) {
        Pair[] people = new Pair[names.length];

        for(int i = 0; i < names.length; i++){
            people[i] = new Pair(names[i] , heights[i]);
        }

        Arrays.sort(people, (x, y) -> y.height - x.height);

        String[] res = new String[names.length];
        int index = 0;
        for(Pair curr : people){
            res[index] = curr.name;
            index++;
        }

        return res;
    }
}