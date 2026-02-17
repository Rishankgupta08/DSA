import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.*;
import java.util.Queue;
public class Main1 {
    static class Pair {
        int u;
        long cost;

        public Pair(int u, long cost) {
            this.u = u;
            this.cost = cost;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st =new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] roads = new int[m][2];
        long[] weight = new long[m];
        
        long[][] trains = new long[k][2];

        for (int i = 0; i < m; i++) {
            st =new StringTokenizer(br.readLine());
            roads[i][0] = Integer.parseInt(st.nextToken());
            roads[i][1] = Integer.parseInt(st.nextToken());
            weight[i] = Long.parseLong(st.nextToken());
        }

        for (int i = 1; i < k; i++) {
            st =new StringTokenizer(br.readLine());
            trains[i][0] = Long.parseLong(st.nextToken());
            trains[i][1] = Long.parseLong(st.nextToken());
        }

        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();

        for (int i = 0; i <= n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {
            int u = roads[i][0];
            int v = roads[i][1];

            adj.get(u).add(new Pair(v, weight[i]));
            adj.get(v).add(new Pair(u, weight[i]));
        }

        Queue<Pair> q = new LinkedList<>();

        long[] distR = new long[n + 1];
        Arrays.fill(distR, Long.MAX_VALUE);

        boolean[] vis = new boolean[n + 1];

        distR[1] = 0;
        q.offer(new Pair(1, 0));
        vis[1] = true;

        while (!q.isEmpty()) {
            int node = q.peek().u;
            long cost = q.peek().cost;
            q.poll();

            for (Pair p : adj.get(node)) {
                int it = p.u;
                long c = p.cost;

                if (!vis[it] && distR[it] > c + distR[node]) {
                    vis[it] = true;
                    distR[it] = c + distR[node];
                    q.offer(new Pair(it, distR[it]));
                }
            }
        }

        long[] disT = new long[n + 1];
        Arrays.fill(disT, Long.MAX_VALUE);

        Arrays.sort(trains, (a, b) -> {
          if (a[0] != b[0]) {
              return Long.compare(a[0], b[0]);   // node ascending
          } else {
              return Long.compare(b[1], a[1]);   // cost descending
          }});

        disT[1] = 0;
        long train = 0;

        for (int i = 0; i < k; i++) {
          int node = (int) trains[i][0];
          long curr = disT[node];
      
          if (trains[i][1] < curr && curr != Long.MAX_VALUE) {
              disT[node] = trains[i][1];
              train++;
          } else if (trains[i][1] < curr) {
              disT[node] = trains[i][1];
          }
      }


        for (int i = 1; i <= n; i++) {
            if (distR[i] <= disT[i] && disT[i] != Long.MAX_VALUE) {
                train = train + 1;
            }
        }
        BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(String.valueOf(train));
        bw.flush();
    }
}