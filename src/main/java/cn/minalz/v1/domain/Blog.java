package cn.minalz.v1.domain;

import java.io.Serializable;

/**
 * @description: Blog实体类
 * @author: minalz
 * @date: 2021-05-24 21:56
 **/
public class Blog implements Serializable {

    private Integer bid;
    private String name;
    private Integer authorId;

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    @Override
    public String toString() {
        return "Blog{" +
                "bid=" + bid +
                ", name='" + name + '\'' +
                ", authorId=" + authorId +
                '}';
    }
}
