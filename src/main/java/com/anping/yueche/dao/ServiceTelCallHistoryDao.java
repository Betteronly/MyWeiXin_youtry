package com.anping.yueche.dao;

import com.anping.yueche.pojo.CarOrderInfo;
import com.anping.yueche.pojo.ServiceTelCallHistory;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;

/**
 * 约车信息
 * 
 * @author Better
 *
 */
@MapperScan
public interface ServiceTelCallHistoryDao {
    public List<ServiceTelCallHistory> selectServiceTelCallHistory(ServiceTelCallHistory serviceTelCallHistory);

    public int insertServiceTelCallHistory(ServiceTelCallHistory serviceTelCallHistory);

    public int updateServiceTelCallHistory(ServiceTelCallHistory serviceTelCallHistory);

    public String getCountOfServiceTelCall(ServiceTelCallHistory serviceTelCallHistory);
}