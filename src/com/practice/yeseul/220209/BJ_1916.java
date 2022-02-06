import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class BJ_1916 {
    //Comparable : 정렬 수행 시 기본적으로 적용되는 정렬 기준이 되는 메서드를 정의
    static class Node implements Comparable<Node> {
        int end;
        int price;

        public Node(int end, int price) {
            this.end = end;
            this.price = price;
        }

        @Override
        public int compareTo(Node node) {
            return price - node.price;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        ArrayList<Node>[] nodes = new ArrayList[N + 1];
        for (int i = 0; i <= N; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int from = sc.nextInt();
            int to = sc.nextInt();
            int price = sc.nextInt();
            nodes[from].add(new Node(to, price));
        }

        int start = sc.nextInt();
        int end = sc.nextInt();
        System.out.println(dijkstra(nodes, N, start, end));
    }

    private static int dijkstra(ArrayList<Node>[] nodes, int N, int start, int end) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        int dist[] = new int[N + 1];
        boolean visit[] = new boolean[N + 1];

        Arrays.fill(dist, Integer.MAX_VALUE);
        pq.offer(new Node(start, 0));
        dist[start] = 0;

        while (!pq.isEmpty()) {
            Node nowNode = pq.poll();
            int now = nowNode.end;
            if (!visit[now]) {
                visit[now] = true;
                for (Node n : nodes[now]) {
                    if (!visit[n.end] && dist[n.end] > dist[now] + n.price) {
                        dist[n.end] = dist[now] + n.price;
                        pq.add(new Node(n.end, dist[n.end]));
                    }
                }
            }
        }
        return dist[end];
    }
}
