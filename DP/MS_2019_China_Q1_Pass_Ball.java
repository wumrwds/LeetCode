package top.wumrwds.microsoft;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 1. 击鼓传花
 *
 * N个人每个人编号1-N，编号能整除的两个人互相连通，从编号为i的人开始传，最后要传回i手上，要在T次之内传完，问最多有几种传法？
 *
 * 测试
 * 参数：N=3, i=2, T=2
 * 路径：2-1-2
 * 返回：1
 *
 *
 * 参数：N=3, i=2, T=4
 * 2-1-2
 * 2-1-3-1-2
 * 2-1-2-1-2
 * 返回：3
 *
 */
public class Q1 {

    private int count;
    private int origin;
    private long[][] memo;

    /**
     * Memoization version.
     * @param N
     * @param i
     * @param T
     * @return
     */
    public long maximumPathMemo(int N, int i, int T) {
        origin = i;
        memo = new long[N+1][T+1];
        for (long[] a : memo) {
            Arrays.fill(a, -1);
        }

        List<List<Integer>> graph = constructGraph(N);

        long cnt = dfs(graph, i, T);

        return cnt < 0 ? 0 : cnt - 1;
    }

    private List<List<Integer>> constructGraph(int N) {
        List<List<Integer>> graph = new ArrayList<>(N+1);
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 2; i*j <= N; j++) {
                graph.get(i).add(i*j);
                graph.get(i*j).add(i);
            }
        }

        return graph;
    }

    private long dfs(List<List<Integer>> graph, int i, int T) {
        if (memo[i][T] >= 0) {
            return memo[i][T];
        }

        long cnt = 0;
        if (i == origin) {
            cnt++;
        }

        if (T == 0) {
            return cnt;
        }

        for (Integer neighbor : graph.get(i)) {
            cnt += dfs(graph, neighbor, T-1);
        }

        memo[i][T] = cnt;

        return cnt;
    }


    /**
     * DFS version
     * @param N
     * @param i
     * @param T
     * @return
     */
    public int maximumPath(int N, int i, int T) {
        origin = i;
        count = 0;

        List<List<Integer>> graph = constructGraph(N);

        helper(graph, i, T);

        return count - 1;
    }

    private void helper(List<List<Integer>> graph, int i, int T) {

        if (i == origin) {
            count++;
        }

        if (T == 0) {
            return;
        }

        for (Integer neighbor : graph.get(i)) {
            helper(graph, neighbor, T-1);
        }
    }

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.maximumPathMemo(3,2,1) + ", " + q1.maximumPath(3,2,1));
        System.out.println(q1.maximumPathMemo(3,3,1) + ", " + q1.maximumPath(3,3,1));
        System.out.println(q1.maximumPathMemo(3,2,2) + ", " + q1.maximumPath(3,2,2));
        System.out.println(q1.maximumPathMemo(50,2,20) );
        System.out.println(q1.maximumPathMemo(10,1,3) + ", " + q1.maximumPath(10, 1,3));
        System.out.println(q1.maximumPathMemo(10,1,14) + ", " + q1.maximumPath(10, 1,14));
    }
}
