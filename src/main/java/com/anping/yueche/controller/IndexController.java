package com.anping.yueche.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/")
public class IndexController {

    public IndexController() {
        super();
    }

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String mainIndex() {
        return "index";
    }

    /*
     * ########################################################
     * ############## 原 助学辅助 逻辑，暂留 ##################
     * ########################################################
     */
    @RequestMapping({ "/ex", "/extrathyme" })
    public String show() {
        return "extrathyme";
    }

    @RequestMapping(value = "/model", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("recipient", "World");
        return "index";
    }

    @RequestMapping(value = "/bootstrap", method = RequestMethod.GET)
    public String bootstrap(Model model) {
        model.addAttribute("recipient", "World");
        return "bootstrap";
    }

    @RequestMapping(value = "/teachtools", method = RequestMethod.GET)
    public String teachtools(Model model) {
        List<Object> tasks = new ArrayList<>();

        Map<String, String> mapTasks = new HashMap<>();
        mapTasks.put("school", "霍营小学");
        mapTasks.put("grade", "一年级");
        mapTasks.put("class", "一班");
        tasks.add(mapTasks);

        Map<String, String> mapTasks2 = new HashMap<>();
        mapTasks2.put("school", "霍营小学");
        mapTasks2.put("grade", "二年级");
        mapTasks2.put("class", "二班");
        tasks.add(mapTasks2);

        model.addAttribute("classes", tasks);
        model.addAttribute("tStat.count", 10);
        return "teachtools";
    }

    @RequestMapping(value = "/json/datagriddataA", method = RequestMethod.GET)
    @ResponseBody
    public Object datagrid() {
        // model.addAttribute("recipient", "World");

        // TeachToolsEntity teachToolsEntity = new TeachToolsEntity();
        // teachToolsEntity.setTotal("1");

        Map<String, Object> result = new HashMap<String, Object>();
        result.put("total", "1");

        List<Map<String, String>> rows = new ArrayList<>();
        Map<String, String> row1 = new HashMap<String, String>();
        row1.put("itemid", "EST-1");
        row1.put("productid", "FI-SW-01");
        row1.put("unitcost", "11.00");
        row1.put("listprice", "11.00");
        row1.put("attr1", "Large");
        row1.put("status", "P");
        rows.add(row1);

        Map<String, String> row2 = new HashMap<String, String>();
        row2.put("itemid", "EST-2");
        row2.put("productid", "FI-SW-02");
        row2.put("unitcost", "22.00");
        row2.put("listprice", "22.00");
        row2.put("attr1", "Spotted Adult Female");
        row2.put("status", "S");
        rows.add(row2);

        Map<String, String> row3 = new HashMap<String, String>();
        row3.put("itemid", "EST-3");
        row3.put("productid", "FI-SW-03");
        row3.put("unitcost", "33.00");
        row3.put("listprice", "33.00");
        row3.put("attr1", "Venomless");
        row3.put("status", "E");
        rows.add(row3);

        result.put("rows", rows);

        return result;
    }
}
