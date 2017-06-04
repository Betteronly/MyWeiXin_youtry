package com.anping.yueche.dao;

import java.util.List;

import org.mybatis.spring.annotation.MapperScan;

import com.anping.yueche.pojo.CarOrderInfo;

/**
 * 约车信息
 * 
 * @author Better
 *
 */
@MapperScan
public interface CarOrderInfoDao {
    public List<CarOrderInfo> selectCarOrderInfo(String open_id);

    public int insertCarOrderInfo(CarOrderInfo carOrderInfo);

    public int updateCarOrderInfo(CarOrderInfo carOrderInfo);
}