package com.anping.yueche.entity;

import java.util.List;

/**
 * 家庭作业一览
 * 
 * @author Better
 *
 */
public class HomeWorks {
    // 作业一览
    // @Autowired
    private String homeWorkDate;
    private List<HomeWork> listHomeWork;

    // public HomeWorks(HomeWork homeWork) {
    // this.listHomeWorks.add(homeWork);
    // }

    public String getHomeWorkDate() {
        return homeWorkDate;
    }

    public void setHomeWorkDate(String homeWorkDate) {
        this.homeWorkDate = homeWorkDate;
    }

    public List<HomeWork> getListHomeWork() {
        return listHomeWork;
    }

    public void setListHomeWork(List<HomeWork> listHomeWork) {
        this.listHomeWork = listHomeWork;
    }

}
