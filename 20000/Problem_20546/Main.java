package Problem_20546;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws NumberFormatException, IOException {
        // 준현 : 매수 가능하면 최대한으로 산다.
        // 성민 : 33 매수매도법 (3일연속 하락시 매수, 3일연속 상승시 매도)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int account_ = Integer.parseInt(br.readLine());
        int[] prices = new int[14];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i<14; i++) prices[i] = Integer.parseInt(st.nextToken());
        Ant jun = new Ant(account_);
        Ant sungmin = new Ant(account_);

        int lastPrice = 0;
        int isAscent = 0; // 0 : null, 1 : 상승, 2 : 하락
        int conti = 0; // 계속된 일 수
        for(int i = 0; i<14;i++) {
            jun.buyStock(prices[i]);
            
            if(lastPrice > prices[i]) { // 전날에 비해 하락
                if(isAscent == 2) {
                    conti++;
                } else {
                    conti = 1;
                    isAscent = 2;
                }
            } else if(lastPrice < prices[i]) {
                if(isAscent == 1) {
                    conti++;
                } else {
                    conti = 1;
                    isAscent = 1;
                }
            }

            if(conti >= 3 && isAscent == 1) {// 3일연속 상승 : 매도
                sungmin.sellStock(prices[i]);
            }
            if(conti >= 3 && isAscent == 2) { // 3일연속 하락 : 매수
                sungmin.buyStock(prices[i]);
            }
            lastPrice = prices[i];
        }

        int junsAccount = jun.getTotalAccount(prices[13]);
        int sungAccount = sungmin.getTotalAccount(prices[13]);

        if(junsAccount > sungAccount) {
            System.out.println("BNP");
        } else if(junsAccount < sungAccount) {
            System.out.println("TIMING");
        } else {
            System.out.println("SAMESAME");
        }
    }

    public static class Ant {
        private int account = 0;
        private int stocks = 0;

        public Ant(int account_) {
            this.account = account_;
        }

        public int getTotalAccount(int lastPrice) {
            return account + stocks * lastPrice;
        }

        public void buyStock(int price) {
            if(account < price) return;
            stocks += (account / price);
            account = account % price;
        }

        public void sellStock(int price) {
            account = account + (price * stocks);
            stocks = 0;
        }
    }
}
