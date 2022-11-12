package com.bitcamp.onemoaproject.vo.paging;

import lombok.ToString;
import org.apache.tomcat.util.buf.CharsetCache;

@ToString
public class Criteria {

    private String code;

    private int page;
    private int perPageNum;
    private String categoryCode;

    public int getPageStart() {
        return (this.page-1)*perPageNum;
    }

    public Criteria() {
        this.page = 1;
        this.perPageNum = 3;
        this.categoryCode = null;
    }

    public int getPage() {
        return page;
    }
    public void setPage(int page) {
        if(page <= 0) {
            this.page = 1;
        } else {
            this.page = page;
        }
    }
    public int getPerPageNum() {
        return perPageNum;
    }
    public void setPerPageNum(int pageCount) {
        int cnt = this.perPageNum;
        if(pageCount != cnt) {
            this.perPageNum = cnt;
        } else {
            this.perPageNum = pageCount;
        }
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "Criteria{" +
                "code='" + code + '\'' +
                ", page=" + page +
                ", perPageNum=" + perPageNum +
                '}';
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }
}

