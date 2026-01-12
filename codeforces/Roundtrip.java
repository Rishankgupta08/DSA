import java.util.Scanner;
public class Roundtrip {
    public static void main(String[] args){
        Scanner fs = new Scanner(System.in);
        int tc = fs.nextInt();
        while (tc-- > 0) {
            long initRating = fs.nextLong();
            long targetRating = fs.nextLong();
            long chngAmt = fs.nextLong();

            String matchRes = fs.next();

            long minRating = initRating;
            long maxRating = initRating;
            int count = 0;

            for (int i = 0; i < matchRes.length(); i++) {
                char result = matchRes.charAt(i);
                if (result == '1') {
                    count++;
                    minRating = minRating - chngAmt;
                    if (minRating < 0) minRating = 0;
                    maxRating = maxRating + chngAmt;
                } else {
                    if (minRating < targetRating) {
                        count++;
                        long newMin = minRating - chngAmt;
                        if (newMin < 0) newMin = 0;

                        long chosenMax = Math.min(maxRating, targetRating - 1);
                        long newMax = chosenMax + chngAmt;

                        minRating = newMin;
                        maxRating = newMax;
                    }
                }
            }
            System.out.println(count);
        }
        fs.close();
    }
    
}
