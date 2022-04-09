package com.xyh.demo.serivce.impl;

import com.xyh.demo.serivce.IJobService;

public class JobService implements IJobService {
    @Override
    public void findJob() {
        System.out.println("认认真真找工作");
    }
}
