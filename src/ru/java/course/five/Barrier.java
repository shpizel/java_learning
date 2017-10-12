package ru.java.course.five;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Barrier {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(2);
        // await отработает только если 3 потока подойдут к барьеру
    }

    private static class BarrierThread extends Thread {
        private CyclicBarrier barrier;

        public BarrierThread(CyclicBarrier barrier) {
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                barrier.await();
                System.out.println();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
