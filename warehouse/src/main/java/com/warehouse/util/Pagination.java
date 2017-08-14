package com.warehouse.util;

/**
 * Created by kone on 2017-08-12.
 */
public class Pagination<T> {
    private Integer pageSize;

    private Integer currentPage;

    private Integer total;

    private T data;

    public Pagination() {
    }

    public Pagination(Integer pageSize, Integer currentPage, Integer total, T data) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.total = total;
        this.data = data;
    }

    public Pagination(Integer pageSize, Integer currentPage, Integer total) {
        this.pageSize = pageSize;
        this.currentPage = currentPage;
        this.total = total;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
