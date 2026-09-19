class Solution {
    public int getSum(int a, int b) {
        int carry =0, res =0, mask = 0xFFFFFFF;
        for(int i =0; i<32; i++){
            int aBit = (a>>i) &1;
            int bBit = (b>>i) &1;
            int cur_bit = aBit ^ bBit ^carry;
            carry = (aBit + bBit + carry) >=2?1:0;
            if(cur_bit!=0){
                res |=(1<<i);
            }
        }
        if(res>0xFFFFFFF){
            res = ~(res^mask);
        }
        return res;
    }
}
