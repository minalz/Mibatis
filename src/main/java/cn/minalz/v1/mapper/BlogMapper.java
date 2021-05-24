package cn.minalz.v1.mapper;

import cn.minalz.v1.domain.Blog;

/**
 * @description:
 * @author: minalz
 * @date: 2021-05-24 21:59
 **/
public interface BlogMapper {

    public Blog selectBlogById(Integer bid);
}
