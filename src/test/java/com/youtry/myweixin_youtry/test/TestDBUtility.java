package com.youtry.myweixin_youtry.test;

import com.youtry.myweixin_youtry.util.DBUtility;
import org.junit.Test;

import java.sql.SQLException;

/**
 * Created by liulong on 2017/6/13.
 */
public class TestDBUtility {

    /**
     * 方法名：testgetConnection</br>
     * 详述：测试是否连接</br>
     * 开发人员：souvc </br>
     * 创建时间：2015-10-5  </br>
     * @throws SQLException
     * @throws
     */
    @Test
    public void testgetConnection() throws SQLException {
        DBUtility db = new DBUtility();
        System.out.println(db.getConnection());
    }


}
