/**
 * Created by sameerarora on 4/30/15.
 */
public class Candi {

    public static int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) {
            return 0;
        }

        int[] candies = new int[ratings.length];
        candies[0] = 1;

        //from let to right
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candies[i] = candies[i - 1] + 1;
            } else {
                // if not ascending, assign 1
                candies[i] = 1;
            }
        }

        int result = candies[ratings.length - 1];

        //from right to left
        for (int i = ratings.length - 2; i >= 0; i--) {
            int cur = 1;
            if (ratings[i] > ratings[i + 1]) {
                cur = candies[i + 1] + 1;
            }

            result += Math.max(cur, candies[i]);
            candies[i] = cur;
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println("Candies Required "+candy(new int[]{1, 3, 25, 4, 5, 6, 8, 17, 100, 17, 9, 50}));
        //Candies.candies()
    }
}
