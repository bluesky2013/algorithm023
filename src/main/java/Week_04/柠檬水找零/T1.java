package Week_04.柠檬水找零;

/**
 *
 * 柠檬水找零
 */
public class T1 {
    public boolean lemonadeChange(int[] bills) {

        int five = 0;
        int ten = 0;
        int twenty = 0;
        for(int index = 0 ; index<bills.length ; index++){
            int coin = bills[index];
            if(coin == 5){
                five++;
            }else if(coin == 10){
                if(five>=1){
                    five--;
                    ten++;
                }else{
                    return false;
                }
            }else{
                if((five>=1 && ten>=1)){
                    five--;
                    ten--;
                    twenty++;
                }else if(five>=3){
                    five -=3;
                }else{
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
//        int[] bills = {5,5,5,10,20};
//        int[] bills = {5,5,10};
//        int[] bills = {10,10};
        int[] bills = {5,5,10,10,20};
        System.out.println(new T1().lemonadeChange(bills));

    }

}
