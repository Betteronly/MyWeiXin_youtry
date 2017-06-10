package com.anping.yueche.dao;

import com.anping.yueche.pojo.CarOrderInfo;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 约车信息
 * 
 * @author Better
 *
 */
@MapperScan
public interface CarOrderInfoDao {
    public List<CarOrderInfo> selectCarOrderInfo(CarOrderInfo carOrderInfo);

    public int insertCarOrderInfo(CarOrderInfo carOrderInfo);

    public int updateCarOrderInfo(CarOrderInfo carOrderInfo);
}