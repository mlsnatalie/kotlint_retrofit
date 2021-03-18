package com.jindashi.jsdsdkdemo.http;

import java.io.Serializable;
import java.util.List;

/**
 * @author: mlsnatalie
 * @date: 2021/3/18 3:21 PM
 * @UpdateDate: 2021/3/18 3:21 PM
 * email：mlsnatalie@163.com
 * description：
 */
public class DataDemoList implements Serializable {
    private List<DataDemo> dataDemoList1;
    private List<DataDemo> dataDemoList2;

    public List<DataDemo> getDataDemoList1() {
        return dataDemoList1;
    }

    public void setDataDemoList1(List<DataDemo> dataDemoList1) {
        this.dataDemoList1 = dataDemoList1;
    }

    public List<DataDemo> getDataDemoList2() {
        return dataDemoList2;
    }

    public void setDataDemoList2(List<DataDemo> dataDemoList2) {
        this.dataDemoList2 = dataDemoList2;
    }
}
