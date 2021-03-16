package com.jindashi.jsdsdkdemo.http;

import java.io.Serializable;

/**
 * @author: mlsnatalie
 * @date: 2021/3/16 7:34 PM
 * @UpdateDate: 2021/3/16 7:34 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class DataDemo implements Serializable {
    private String image;
    private String path;
    private String passtime;
    private String title;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getPasstime() {
        return passtime;
    }

    public void setPasstime(String passtime) {
        this.passtime = passtime;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
