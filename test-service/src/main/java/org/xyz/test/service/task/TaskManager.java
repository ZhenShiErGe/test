package org.xyz.test.service.task;

import org.omg.CORBA.TIMEOUT;
import org.springframework.stereotype.Service;
import org.springframework.util.ErrorHandler;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by yizhenn on 16-12-17.
 */
@Service
public class TaskManager {
    public void print() throws TestException, InterruptedException {
        Random random = new Random(System.currentTimeMillis());
        int tmp = random.nextInt(5);
        System.out.println("random second=" + tmp);
        if (tmp == 1)
            throw new TestException();
        TimeUnit.SECONDS.sleep(tmp);
        System.out.println("执行定时任务");
    }

    public static class TestExceptionHandler implements ErrorHandler {
        @Override
        public void handleError(Throwable t) {
            System.out.println("定时任务发生异常，进行处理");
        }
    }

    private class TestException extends Exception {

    }
}
