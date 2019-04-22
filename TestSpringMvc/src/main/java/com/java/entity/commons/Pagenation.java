package com.java.entity.commons;
/**
 * @author 倪军
 * @version 0.1
 * @time 2017/3/17 10:19
 */
public class Pagenation {
    /*
    当前页
     */
    private int page;
    /*
    每页多少条
     */
    private int rows;

    public int getPage() {
        if (page == 0){
            return page;
        }else {
            return (page-1)*rows;
        }
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
