package com.anping.yueche.entity;

import java.util.List;
import java.util.Map;

public class TeachToolsEntity {
    private String total;
    private List<Map<String, String>> rows;

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<Map<String, String>> getRows() {
        return rows;
    }

    public void setRows(List<Map<String, String>> rows) {
        this.rows = rows;
    }
}
