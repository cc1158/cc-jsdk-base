package com.cc.jsdk.base;

import java.util.List;

/**
 * 分页类
 *
 * @author cc
 * Create at 2023-08-19
 */
public class PageInfo<T> {

    /**
     * 页码
     */
    private Integer pageNum = 1;

    /**
     * 页大小
     */
    private Integer pageSize = 10;

    /**
     * 总数
     */
    private Integer total = 0;

    /**
     * 列表数据
     */
    private List<T> data;

    public Integer getPageNum() {
        return pageNum;
    }

    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Integer getOffset() {
        return (pageNum - 1) * pageSize;
    }

    public Integer getPages() {
        int div = total / pageSize;
        return total % pageSize > 0 ? div + 1 : div;
    }

    public boolean isLastPage() {
        int pages = getPages();
        return pageNum >= pages;
    }
}
