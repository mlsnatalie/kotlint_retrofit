package com.jindashi.jsdsdkdemo.lhb;

import java.io.Serializable;

/**
 * @author: amos
 * @date: 2021/3/1 18:22
 * @description: 龙虎榜首页咨询实体
 */
public class LongHuBangAdvisoryBean implements Serializable {

    /**
     * id : 30397
     * category_id : 68
     * describe : 公司新闻
     * title : 茅台之后，又一只白酒股划转股权！地方国资接手，“喝酒”行情能否持续？
     * create_time : 2021-01-18 11:23:21
     * go_url : http://hd.get88.cn/test/xigua/?id=30397#/information
     */

    private int id;
    private int category_id;
    private String describe;
    private String title;
    private String create_time;
    private String go_url;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getDescribe() {
        return describe;
    }

    public void setDescribe(String describe) {
        this.describe = describe;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getGo_url() {
        return go_url;
    }

    public void setGo_url(String go_url) {
        this.go_url = go_url;
    }
}
