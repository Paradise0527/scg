package org.scg.pojo;


public class Parames {
    //当前页
    private Integer currentPageNo=1;
    //每页的个数
    private Integer pageSize=5;
//    记录数
    private Integer totalCount=0;
    //总页数
    private Integer totalPageCount=0;

    public Integer getCurrentPageNo() {
        return currentPageNo;
    }

    public void setCurrentPageNo(Integer currentPageNo) {
        this.currentPageNo = currentPageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalPageCount() {
        return totalPageCount;
    }

    public void setTotalPageCount(Integer totalPageCount) {
        this.totalPageCount = totalPageCount;
    }

    public Integer getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(Integer totalCount) {
        if (totalCount>0) {
            this.totalCount=totalCount;
            totalPageCount=totalCount/pageSize;
            if (totalCount%pageSize>0) {
                totalPageCount++;
            }
        } else {
            this.totalCount=0;
        }
    }

    public Parames(Integer currentPageNo, Integer pageSize, Integer totalCount, Integer totalPageCount) {
        this.currentPageNo = currentPageNo;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
        this.totalPageCount = totalPageCount;
    }

    public Parames() {
    }

    @Override
    public String toString() {
        return "Parames{" +
                "currentPageNo=" + currentPageNo +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPageCount=" + totalPageCount +
                '}';
    }
}

