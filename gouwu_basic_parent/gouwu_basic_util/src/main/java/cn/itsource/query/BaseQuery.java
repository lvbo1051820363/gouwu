package cn.itsource.query;

public class BaseQuery {
    private String keyword; //关键字查询

    private Integer page=1;
    private Integer rows=10;

    private Integer start=0;

    public Integer getStart() {
        return (this.page-1)*this.rows;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getRows() {
        return rows;
    }

    public void setRows(Integer rows) {
        this.rows = rows;
    }
}
