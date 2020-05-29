package com.seldom.business.controller.admin;

import com.github.pagehelper.PageInfo;
import com.seldom.server.domain.Chapter;
import com.seldom.server.dto.ChapterDto;
import com.seldom.server.dto.PageDto;
import com.seldom.server.dto.ResponseDto;
import com.seldom.server.exception.ValidatorException;
import com.seldom.server.service.ChapterService;
import com.seldom.server.util.ValidatorUtil;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    private static final Logger LOG = LoggerFactory.getLogger(ChapterController.class);
    public static final String BUSINESS_NAME = "Chapter";

    @Resource
    private ChapterService chapterService;

    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
//    public PageDto list(PageDto pageDto) { 这种写法只能接受表单form方式的参数，而不能接受json参数
        LOG.info("pageDto: {}", pageDto);
        ResponseDto responseDto = new ResponseDto();
        chapterService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    @PostMapping("/save")
    public ResponseDto save(@RequestBody ChapterDto chapterDto ) {
        LOG.info("chapterDto: {}", chapterDto);

        // 保存校验
        ValidatorUtil.require(chapterDto.getName(), "Name");
        ValidatorUtil.require(chapterDto.getCourseId(), "Course ID");
        ValidatorUtil.length(chapterDto.getCourseId(), "Course ID", 1, 8);

        ResponseDto responseDto = new ResponseDto();
        chapterService.save(chapterDto);
        responseDto.setContent(chapterDto);
        return responseDto;
    }

    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        LOG.info("id: {}", id);
        ResponseDto responseDto = new ResponseDto();
        chapterService.delete(id);
        return responseDto;
    }

}
