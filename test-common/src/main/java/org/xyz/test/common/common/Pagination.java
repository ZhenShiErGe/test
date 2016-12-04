
package org.xyz.test.common.common;


import org.apache.commons.lang3.builder.ToStringBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yizhenn on 2016/12/4.
 */
public class Pagination<T> implements Serializable {

    private static final long serialVersionUID = -7427571376449725731L;

    private static final int DEFAULT_PAGE_SIZE = 10;

    private int totalCount;
    private int pageNo;
    private int pageSize;
    private int totalPage;

    private List<T> list;

    public Pagination() {
    }

    public Pagination(int offset, int limit, int totalCount, List<T> list) {
        if (limit <= 0) {
            this.pageSize = DEFAULT_PAGE_SIZE;
        } else {
            this.pageSize = limit;
        }

        if (offset <= 0) {
            this.pageNo = 1;
        } else {
            this.pageNo = offset / this.pageSize + 1;
        }

        if (totalCount < 0) {
            this.totalCount = 0;
        } else {
            this.totalCount = totalCount;
        }

        totalPage = (this.totalCount % this.pageSize == 0) ? this.totalCount / this.pageSize : this.totalCount
                / this.pageSize + 1;

        this.list = list;

    }


    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

}
