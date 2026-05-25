import java.io.*;
import java.util.*;
public class Towers {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<Integer> towers = new ArrayList<>();
        //! O(n log n)
        for (int i = 0; i < n; i++) {
            int x = Integer.parseInt(st.nextToken());
            int idx = upperBound(towers, x);
            if (idx == towers.size()) {
                towers.add(x);
            }
            else {
                towers.set(idx, x);
            }
        }
        System.out.println(towers.size());
    }
    //! log(n)
    static int upperBound(ArrayList<Integer> arr, int target) {
        int low = 0;
        int high = arr.size();
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr.get(mid) > target) {
                high = mid;
            }
            else {
                low = mid + 1;
            }
        }
        return low;
    }
}