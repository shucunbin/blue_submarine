package io.blue.submarine.xia.abc;

import ch.qos.logback.classic.gaffer.GafferUtil;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;

/**
 * @author shucunbin
 * @date 2022-02-14 14:46
 */
public class ForkJoinDemo {
//    private static final class AccTask extends RecursiveTask<Integer> {
//        private final int start;
//        private final int end;
//
//        AccTask(int start, int end) {
//            this.start = start;
//            this.end = end;
//        }
//
//
//        @Override
//        protected Integer compute() {
//            if (end - start < 1000) {
//                System.out.println(Thread.currentThread().getName() + " 开始执行: " + start + "-" + end);
//                int sum = 0;
//                for(int i = start; i <= end; i++) {
//                    sum += i;
//                }
//                return sum;
//            }
//
//            AccTask accTask1 = new AccTask(start, (start + end) / 2);
//            AccTask accTask2 = new AccTask((start + end) / 2 + 1, end);
//            accTask1.fork();
//            accTask2.fork();
//
//            return accTask1.join() + accTask2.join();
//        }
//    }

    public static void main(String[] args) throws Exception {

        GuideActivity guideActivity= new GuideActivity();
        guideActivity.setType("guide");
        guideActivity.setId(1);
        guideActivity.setGuideInfo("guider info");

        BaseActivity activity = guideActivity;

    }
}
