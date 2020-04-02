package com.mm.demo.common_disruptor.translator;

import com.lmax.disruptor.EventTranslator;
import com.mm.demo.common_disruptor.entity.DataBean;
import com.mm.demo.common_disruptor.entity.Student;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据转换
 * @auther: fujie.feng
 * @DateT: 2020-01-08
 */
public class DataBeanEventTranslator implements EventTranslator<DataBean> {

    private static final int count = 1000000;

    @Override
    public void translateTo(DataBean event, long sequence) {


        List<Student> list = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Student student = new Student();
            student.setAge(10 + i);
            student.setName("test:" + i);
            list.add(student);
        }
        event.setDataList(list);


        System.out.println("create 10 ge  data");
    }

}
