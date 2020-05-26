package com.seldom.server.service;

import com.seldom.server.domain.Chapter;
import com.seldom.server.domain.ChapterExample;
import com.seldom.server.mapper.ChapterMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public List<Chapter> list() {
        ChapterExample chapterExample = new ChapterExample();
        chapterExample.createCriteria().andIdEqualTo("1");
        chapterExample.setOrderByClause("id desc");
        return chapterMapper.selectByExample(chapterExample);
//        return chapterMapper.selectByExample(null);  // select * from chapter;
    }

}
