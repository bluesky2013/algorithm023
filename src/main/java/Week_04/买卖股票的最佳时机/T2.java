package Week_04.买卖股票的最佳时机;

/**
 * 买卖股票的最佳时机 II
 */
public class T2 {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0){
            return -1;
        }
        int result = 0;
        for(int index=0 ; index<prices.length-1 ; index++){
            if(prices[index]<prices[index+1]){
                result += (prices[index+1] - prices[index]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
//        int[] prices = {7,1,5,3,6,4};
        int[] prices = {1,2,3,4,5};
        System.out.println(new T2().maxProfit(prices));
    }
}
