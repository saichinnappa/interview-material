package com.practice.java.features.concurrency;

import java.time.Instant;
import java.util.Deque;
import java.util.LinkedList;
import java.util.concurrent.*;

public class ExecutorServiceDemo {
    public static void main(String[] args) throws InterruptedException {
        // Executor Service with Fixed Thread pool
        executorServiceFixedThreadPool();

        // executor service with scheduled delay
        executorServiceWithScheduledDelay();

        // executor service with future task
        executorServiceWithFutureTask();

        // Callable FutureTask to return result
        callableFutureTask();

        // Count down latch
        countdownlatch();

        // Semaphore
        semaphore();

        // Thread joining
        joinThreads();



    }

    private static void executorServiceWithFutureTask() {
        System.out.println("\n############ EXECUTOR SERVICE WITH FUTURE TASK ###############");
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        Future<String> futureTask =  executorService.submit(() -> {
//            Thread.sleep(300);
            return "Hello World";
        });

        while(true){
            try{
                if(futureTask.isDone()){
                    System.out.println(futureTask.get());
                    executorService.shutdown();
                    return;
                } else{
                    System.out.println("Waiting for task to complete...");
                }
            } catch (ExecutionException | InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    private static void executorServiceWithScheduledDelay() {
        System.out.println("\n############ EXECUTOR SERVICE WITH SCHEDULED THREAD POOL ###############");
        ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
        scheduledExecutorService.schedule(new RunnableTask(), 2, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new RunnableTask(), 2, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new RunnableTask(), 2, TimeUnit.SECONDS);
        scheduledExecutorService.schedule(new RunnableTask(), 5, TimeUnit.SECONDS);
        //Stops executing other tasks after shutdown is called
        scheduledExecutorService.shutdown();
        try {
            //waits for X period of time to see if all the scheduled tasks are completed.
            //If not, force shutdown
            if (!scheduledExecutorService.awaitTermination(10, TimeUnit.SECONDS)) {
                System.out.println("Shutting down now!");
                scheduledExecutorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            scheduledExecutorService.shutdownNow();
        }
    }
    private static void executorServiceFixedThreadPool(){
        System.out.println("\n############ EXECUTOR SERVICE WITH FIXED THREAD POOL ###############");
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        executorService.submit(new RunnableTask());
        executorService.submit(new RunnableTask());
        executorService.submit(new RunnableTask());
        executorService.submit(new RunnableTask());
        executorService.submit(new RunnableTask());
        executorService.submit(new RunnableTask());
        executorService.submit(new RunnableTask());
        executorService.shutdown();
        try {
            if(!executorService.awaitTermination(1, TimeUnit.SECONDS)){
                executorService.shutdownNow();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void callableFutureTask() {
        System.out.println("\n############ CALLABLE FUTURE TASK TO RETURN RESULT ###############");
        FutureTask<String> futureTask = new FutureTask<String>(new CallableTask());
        Thread callableThread = new Thread(futureTask);
        callableThread.start();
        while(true){
            if(futureTask.isDone()){
                try {
                    System.out.println(futureTask.get());
                    return;
                } catch (InterruptedException | ExecutionException e) {
                    throw new RuntimeException(e);
                }
            } else{
                System.out.println("Waiting for Future to complete...");
            }
        }

    }

    private static void countdownlatch(){
        System.out.println("\n############# COUNT DOWN LATCH ###############");
        CountDownLatch countDownLatch = new CountDownLatch(3);
        ExecutorService executorService
                 = Executors.newFixedThreadPool(3);

        for(int i = 0; i < 3; i++){
            executorService
                    .submit(new Worker(countDownLatch, "worker - "+ i, i * 1000));
        }
//        Worker w1 = new Worker(countDownLatch, "Worker - 1", 1000);
//        Worker w2 = new Worker(countDownLatch, "Worker - 2", 2000);
//        Worker w3 = new Worker(countDownLatch, "Worker - 3", 3000);
//
//        Thread t1 = new Thread(w1);
//        Thread t2 = new Thread(w2);
//        Thread t3 = new Thread(w3);
//
//        t1.start();
//        t2.start();
//        t3.start();

        try {
            countDownLatch.await();
            executorService.shutdown();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Finished processing: "+ Thread.currentThread().getName());
    }


    private static void semaphore() {
        System.out.println("\n############# SEMAPHORE ###############");
        Semaphore semaphore = new Semaphore(1);
        SemaphoreExample s1 = new SemaphoreExample(semaphore, "Thread - 1");
        SemaphoreExample s2 = new SemaphoreExample(semaphore, "Thread - 2");
        Thread threadOne = new Thread(s1);
        Thread threadTwo = new Thread(s2);

        threadOne.start();
        threadTwo.start();

        try {
            threadOne.join();
            threadTwo.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void joinThreads(){
        Runnable runnable = new Runnable(){
            @Override
            public void run() {
                try {
                    if(Thread.currentThread().getName().equals("Thread-0")){
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(1000);
                    } else {
                        System.out.println(Thread.currentThread().getName());
                        Thread.sleep(2000);
                    }

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        };
        Thread testThread = new Thread(runnable);
        Thread testThread1 = new Thread(runnable);
        testThread.start();
        testThread1.start();
        try {
            testThread.join();
            testThread1.join(); //Waits for Thread - 0 to complete
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("--finish---"); //Waits for Thread -0 && Thread-1 to complete before finishing main thread.
    }


}
class RunnableTask implements Runnable{
    @Override
    public void run(){
        System.out.println("Thread Name: "+ Thread
                .currentThread().getName() +" TIME: "+ Instant.now());
    }
}

class CallableTask implements Callable<String>{
    @Override
    public String call() throws Exception {
        return "Invoked Call!";
    }
}

class Worker implements Runnable{

    CountDownLatch latch;
    String name;
    int delay;

    Worker(CountDownLatch latch, String name, int delay){
        this.name = name;
        this.latch = latch;
        this.delay = delay;
    }

    @Override
    public void run() {
        try {
            Thread.sleep(delay);
            latch.countDown();
            System.out.println("Processing Thread: "+ name);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

class Shared
{
    static int count = 0;
}


class SemaphoreExample implements Runnable{
    Semaphore semaphore;
    String name;

    SemaphoreExample(Semaphore semaphore, String name){
        this.semaphore = semaphore;
        this.name = name;
    }

    @Override
    public void run(){
        try {
            System.out.println("Processing Thread: "+ name);
            System.out.println("Available permits: "+ semaphore.availablePermits());
            semaphore.acquire();
            for(int i=0; i < 5; i++)
            {
                Shared.count--;
                System.out.println(name + ": " + Shared.count);
                Thread.sleep(100);
            }
            System.out.println("Lock released by: "+name);
            semaphore.release();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}