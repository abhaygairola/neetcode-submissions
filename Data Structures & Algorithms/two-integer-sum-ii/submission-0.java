class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i =0 , j = numbers.length-1;
        while(i<j){
            int diff = target - (numbers[i]+numbers[j]);
            if(diff ==0){return new int[]{i+1,j+1};}
            else if (diff<0){j--;}
            else {i++;}
        }
        return new int[2];
    }
}
