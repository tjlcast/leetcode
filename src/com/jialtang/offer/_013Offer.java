package com.jialtang.offer;

import java.util.LinkedList;

public class _013Offer {

    public static void main(String[] args) {
        int i = new Solution().movingCount(36,11, 15);
        System.out.println(i);
    }

    static class Solution {
        int rows;
        int cols;
        int k;

        boolean[][] can;

        int[][] directions = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        public int movingCount(int m, int n, int k) {
            this.rows = m;
            this.cols = n;
            this.k = k;
            this.can = new boolean[rows][cols];

            LinkedList<Node> queue = new LinkedList<>();
            queue.addLast(new Node(0, 0));
            while (!queue.isEmpty()) {
                Node node = queue.removeFirst();
                //System.out.println(node.r + " " + node.c);
                can[node.r][node.c] = true;
                for (int d=0; d<4; d++) {
                    int nr = node.r + directions[d][0];
                    int nc = node.c + directions[d][1];
                    if (nr<0 || nr>=rows || nc<0 || nc>=cols || can[nr][nc] || !check(nr, nc)) continue;
                    queue.addLast(new Node(nr, nc));
                }
            }

            int count = 0;
            for (int i=0; i<rows; i++)
                for (int j=0; j<cols; j++)
                    if (can[i][j])
                        count += 1;

            return count;
        }

        private boolean check(int i, int j) {
            int total = 0;
            while (i != 0) {
                total += (i % 10);
                i = i / 10;
            }

            while (j != 0) {
                total += (j % 10);
                j = j / 10;
            }
            return total <= this.k;
        }

        private class Node{
            int r, c;
            public Node(int r, int c) {
                this.r = r;
                this.c = c;
            }
        }
    }
}
