class Solution {
    public int reverseBits(int n) {
        int r = 0,b=0;
        for (int i = 0; i < 32; i++) {
            b = ((n >>> i) & 1) << (31-i);
            r |= b;
        }
        return r;
    }
}
