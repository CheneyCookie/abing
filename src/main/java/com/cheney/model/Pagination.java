package com.cheney.model;

import java.util.ArrayList;
import java.util.List;

public class Pagination<T> {

    //每页记录数
    private int pageSize = 10;
    //当前页
    private int currentPage = 1;
    //总页数
    private int total;
    //总记录数
    private int totalCount;
    //数据集合
    private List<T> list = new ArrayList<T>();
    //排序方式
    private String sort;
    //查询关键字
    private String searchKey = "";

    private String tagName = "";

    public Pagination() {
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public String getTagName() {
        return tagName;
    }

    public void setTagName(String tagName) {
        this.tagName = tagName;
    }


}
