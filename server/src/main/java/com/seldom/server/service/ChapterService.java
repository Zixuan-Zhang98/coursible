package com.seldom.server.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.seldom.server.domain.Chapter;
import com.seldom.server.domain.ChapterExample;
import com.seldom.server.dto.ChapterDto;
import com.seldom.server.dto.PageDto;
import com.seldom.server.mapper.ChapterMapper;
import com.seldom.server.util.CopyUtil;
import com.seldom.server.util.UuidUtil;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class ChapterService {

    @Resource
    private ChapterMapper chapterMapper;

    public void list(PageDto pageDto) {
        PageHelper.startPage(pageDto.getPage(), pageDto.getSize());
        ChapterExample chapterExample = new ChapterExample();
        List<Chapter> chapterList = chapterMapper.selectByExample(chapterExample);
        PageInfo<Chapter> pageInfo = new PageInfo<>(chapterList);
        pageDto.setTotal(pageInfo.getTotal());
//        List<ChapterDto> chapterDtoList = new ArrayList<>();
//        for (int i = 0, l = chapterList.size(); i < l; i++) {
//            Chapter chapter = chapterList.get(i);
//            ChapterDto chapterDto = new ChapterDto();
//            BeanUtils.copyProperties(chapter, chapterDto);
//            chapterDtoList.add(chapterDto);
//        }
        List<ChapterDto> chapterDtoList = CopyUtil.copyList(chapterList, ChapterDto.class);
        pageDto.setList(chapterDtoList);
//        return chapterMapper.selectByExample(null);  // select * from chapter;
    }

    public void save(ChapterDto chapterDto) {
        chapterDto.setId(UuidUtil.getShortUuid());
//        Chapter chapter = new Chapter();
//        BeanUtils.copyProperties(chapterDto, chapter);
        Chapter chapter = CopyUtil.copy(chapterDto, Chapter.class);
        chapterMapper.insert(chapter);
    }

}
