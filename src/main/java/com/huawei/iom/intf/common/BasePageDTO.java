package com.huawei.iom.intf.common;

import java.util.List;

public class BasePageDTO {
    private long totalCount;

    private long pageNo;

    private long pageSize;

    private List<?> list;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public long getPageNo() {
        return pageNo;
    }

    public void setPageNo(long pageNo) {
        this.pageNo = pageNo;
    }

    public long getPageSize() {
        return pageSize;
    }

    public void setPageSize(long pageSize) {
        this.pageSize = pageSize;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        final int maxLen = 10;
        StringBuilder builder = new StringBuilder();
        builder.append("BasePageDTO [totalCount=");
        builder.append(totalCount);
        builder.append(", pageNo=");
        builder.append(pageNo);
        builder.append(", pageSize=");
        builder.append(pageSize);
        builder.append(", list=");
        builder.append(list != null ? list.subList(0, Math.min(list.size(), maxLen)) : null);
        builder.append("]");
        return builder.toString();
    }

}
