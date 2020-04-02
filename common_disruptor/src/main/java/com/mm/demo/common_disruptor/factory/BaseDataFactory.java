package com.mm.demo.common_disruptor.factory;

import com.lmax.disruptor.EventFactory;
import com.mm.demo.common_disruptor.entity.DataBean;

/**
 * @auther: fujie.feng
 * @DateT: 2020-01-08
 */
public class BaseDataFactory implements EventFactory<DataBean> {

    @Override
    public DataBean newInstance() {
        return new DataBean();
    }


}
