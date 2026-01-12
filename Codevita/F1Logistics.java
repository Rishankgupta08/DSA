import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

// Class to store race details
class Race implements Comparable<Race> {
    int x, y, day;

    public Race(int x, int y, int day) {
        this.x = x;
        this.y = y;
        this.day = day;
    }
    @Override
    public int compareTo(Race other) {
        return Integer.compare(this.day, other.day);
    }
}

public class F1Logistics {
    static List<List<Integer>> adj;
    static int[] match;
    static boolean[] visited;
    public static int getDist(Race r1, Race r2) {
        return Math.abs(r1.x - r2.x) + Math.abs(r1.y - r2.y);
    }
    public static boolean dfs(int u) {
        if (visited[u]) {
            return false;
        }
        visited[u] = true;
        for (int v : adj.get(u)) { 
            if (match[v] == -1 || dfs(match[v])) {
                match[v] = u;
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Race[] races = new Race[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            races[i] = new Race(x, y, day);
        }
        Arrays.sort(races);
        adj = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) { 
            for (int j = 0; j < n; j++) { 
                if (i == j) continue;
                
                Race r1 = races[i];
                Race r2 = races[j];
                int dayDiff = r2.day - r1.day;
                if (dayDiff > 0) { 
                    int dist = getDist(r1, r2);
                    if (dayDiff >= dist) {
                        adj.get(i).add(j);
                    }
                }
            }
        }
        match = new int[n];
        Arrays.fill(match, -1);

        int matchingCount = 0;
        for (int i = 0; i < n; i++) { 
            visited = new boolean[n]; 
            if (dfs(i)) {
                matchingCount++;
            }
        }
        System.out.println(n - matchingCount);
    }
}