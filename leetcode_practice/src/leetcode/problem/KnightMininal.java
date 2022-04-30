package leetcode.problem;


import javax.xml.crypto.NodeSetData;
import java.security.KeyStore;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class KnightMininal {

    static class Node {
        int x;
        int y;
        int distance;
        Node (int x, int y, int distance){
            this.x = x;
            this.y = y;
            this.distance = distance;
        }

//        public void setPassed(boolean passed) {
//            this.passed = passed;
//        }
//
//        public void setValid(boolean valid){
//            this.valid = valid;
//        }
    }

    static int xMove[] = {2,2,1,1,-1,-1,-2,-2};
    static int yMove[] = {-1,1,2,-2,2,-2,1,-1};
    static Queue <Node> queue = new LinkedList<>();
    static HashSet<Integer> vistedPosition = new HashSet<>();
    static HashSet<Integer> distablePosition = new HashSet<>();

    static int BFS(Node source, Node dest, int N) {
        queue.add(source);
        while (!queue.isEmpty()) {
            Node inQueue = queue.poll();
            vistedPosition.add(inQueue.x*N + inQueue.y);
//            System.out.println(inQueue.x + " " + inQueue.y);

            if (inQueue.x == dest.x && inQueue.y == dest.y) {
                return inQueue.distance;
            }

            for (int i = 0; i < xMove.length; i++) {
                int nextNodex = inQueue.x + xMove[i];
                int nextNodey = inQueue.y + yMove[i];

                Integer nodePosition = nextNodex*N + nextNodey;
                boolean passed = vistedPosition.contains(nodePosition);

//                System.out.println(vistedPosition);

                if (!passed && nextNodex >= 0 && nextNodey >= 0 && nextNodex < N && nextNodey < N) {
                    queue.add(new Node(nextNodex, nextNodey, inQueue.distance + 1));
                    vistedPosition.add(nextNodex*N + nextNodey);
                }
            }
        }
        return Integer.MAX_VALUE;
    }




    static int BFSDisable(Node source, Node dest, int[] x, int[] y, int N) {
        queue.add(source);

        for (int i = 0; i < x.length ; i++ ) {
            distablePosition.add(x[i]*N + y[i]);
        }

        while (!queue.isEmpty()) {
            Node inQueue = queue.poll();
            vistedPosition.add(inQueue.x*N + inQueue.y);
            System.out.println(inQueue.x + " " + inQueue.y);

            if (inQueue.x == dest.x && inQueue.y == dest.y) {
                return inQueue.distance;
            }

            for (int i = 0; i < xMove.length; i++) {
                int nextNodex = inQueue.x + xMove[i];
                int nextNodey = inQueue.y + yMove[i];

                Integer nodePosition = nextNodex*N + nextNodey;
                boolean isPassed = vistedPosition.contains(nodePosition);
                boolean isValid = nextNodex >= 0 && nextNodey >= 0 && nextNodex < N && nextNodey < N;
                boolean isBlocked = distablePosition.contains(nodePosition);

                if (!isPassed && isValid && !isBlocked) {
                    queue.add(new Node(nextNodex, nextNodey, inQueue.distance + 1));
                    vistedPosition.add(nextNodex*N + nextNodey);
                }
            }
        }
        return Integer.MAX_VALUE;
    }


    public static void main(String [] args) {
        int N = 8;
        Node src = new Node(0, 7, 0);
        Node dest = new Node(7, 0, Integer.MAX_VALUE);
        int disablex[] = {0,2, 4,1, 2, 6};
        int disabley[] = {6,6, 2,3, 0, 0};
        int minDistance = BFSDisable(src, dest, disablex, disabley, N);
        System.out.println("This is the min number " + minDistance);
    }

}
