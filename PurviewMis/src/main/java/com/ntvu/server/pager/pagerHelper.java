package com.ntvu.server.pager;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class pagerHelper<T> {
    /**
     * 存放查询条件
     */
    private HashMap<String,String> queryParams = new HashMap<>();
    /**
     *存放查询返回的记录列表
     */
    private List<T> data = new ArrayList<>();
    /**
     * 分页显示：当前显示第几页
     */
    private int pageIndex = 1;
    /**
     *分页显示：每页显示多少条
     */
    private int pageSize = 3;
    /**
     *分页显示：总记录条数
     */
    private int recordCount = 0;
    /**
     *分页显示：总页数
     */
    private int pageCount = 1;

    /**
     *
     *              定义每页数据的 页索引 和  页尺寸
     */
    public pagerHelper(HttpServletRequest request)
    {
        String pageIndex = request.getParameter("pageIndex");
        String pageSize = request.getParameter("pageSize");

        if(pageIndex == null || pageIndex.trim().equals(""))
            pageIndex = "1";
        if(pageSize == null || pageSize.trim().equals(""))
            pageSize = "3";
        this.setPageIndex(Integer.parseInt(pageIndex));
        this.setPageSize(Integer.parseInt(pageSize));
    }
    public HashMap<String, String> getQueryParams() {
        return queryParams;
    }

    public void setQueryParams(HashMap<String, String> queryParams) {
        this.queryParams = queryParams;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getRecordCount() {
        return recordCount;
    }

    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
        //同时，计算出当前的的总页数
        this.pageCount = (int)Math.ceil((double)this.recordCount / this.pageSize);
    }

    public int getPageCount() {
        return pageCount;
    }

    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }
}


