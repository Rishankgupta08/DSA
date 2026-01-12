// static class FastScanner {
//         BufferedReader br;
//         StringTokenizer st;

//         FastScanner(InputStream is) {
//             br = new BufferedReader(new InputStreamReader(is));
//         }

//         String next() {
//             while (st == null || !st.hasMoreElements()) {
//                 try {
//                     String line = br.readLine();
//                     if (line == null) return null;
//                     st = new StringTokenizer(line);
//                 } catch (IOException e) {
//                     return null;
//                 }
//             }
//             return st.nextToken();
//         }

//         long nextLong() {
//             return Long.parseLong(next());
//         }

//         int nextInt() {
//             return Integer.parseInt(next());
//         }
// }
