package com.mm.demo.disruptor;

import com.lmax.disruptor.BlockingWaitStrategy;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;
import com.lmax.disruptor.dsl.ProducerType;
import com.mm.demo.disruptor.entity.Data;
import com.mm.demo.disruptor.handler.D1DataEventHandler;
import com.mm.demo.disruptor.process.Parallel;
import com.mm.demo.disruptor.process.Serial;
import com.mm.demo.disruptor.translator.DataEventTranslator;

import javax.swing.plaf.synth.SynthTextAreaUI;
import java.nio.ByteBuffer;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-07
 */
public class Main {

    private static final int NUMS = 10;

    private static final int SUM = 1000000;

    private static final int BUFFER = 1024 * 1024;

    public static void main(String[] args) {

//       long start = System.currentTimeMillis();
//
//       DataFactory factory = new DataFactory();
//
//       int buffer = 1024;
//        Disruptor<Data> disruptor = new Disruptor<Data>(factory, buffer, new ThreadFactory() {
//            @Override
//            public Thread newThread(Runnable r) {
//                return new Thread(r);
//            }
//        });
//
//        //创建10个消费者
//        Consumer[] consumers = new Consumer[NUMS];
//        for (int i = 0; i < NUMS; i++) {
//            consumers[i] = new Consumer();
//        }
//
//        disruptor.handleEventsWithWorkerPool(consumers);
//        disruptor.start();
//
//        RingBuffer<Data> ringBuffer = disruptor.getRingBuffer();
//        Producer producer = new Producer(ringBuffer);
//
//        //创建一个新的缓存区
//        ByteBuffer bf = ByteBuffer.allocate(8);
//        //生产数据
//        for (int i = 0; i < SUM; i++) {
//            bf.putLong(0, i);
//            producer.push(bf);
//            System.out.println("success producer data : " + i);
//        }
//        long end = System.currentTimeMillis();
//        disruptor.shutdown();
//        System.out.println("total time : " + (end - start));

//        try {
//            Thread.sleep(10000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        DataFactory factory = new DataFactory();

        Disruptor<Data> disruptor = new Disruptor<Data>(factory, BUFFER, Executors.defaultThreadFactory(), ProducerType.MULTI, new BlockingWaitStrategy());

        Serial.serial(disruptor);
//        Parallel.parallel(disruptor);

        RingBuffer<Data> ringBuffer = disruptor.getRingBuffer();
        for (int i = 0; i < 2; i++) {
            ringBuffer.publishEvent(new DataEventTranslator(), (long)i);
        }
        disruptor.shutdown();
//        ringBuffer.publishEvent(new DataEventTranslator(), 10L);

    }
}
