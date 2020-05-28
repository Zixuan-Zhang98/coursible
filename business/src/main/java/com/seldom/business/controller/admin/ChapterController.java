package com.seldom.business.controller.admin;

import com.github.pagehelper.PageInfo;
import com.seldom.server.domain.Chapter;
import com.seldom.server.dto.ChapterDto;
import com.seldom.server.dto.PageDto;
import com.seldom.server.service.ChapterService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/chapter")
public class ChapterController {

    @Resource
    private ChapterService chapterService;

    @RequestMapping("/list")
    public PageDto list(@RequestBody PageDto pageDto) {
//    public PageDto list(PageDto pageDto) { 这种写法只能接受表单form方式的参数，而不能接受json参数
        chapterService.list(pageDto);
        return pageDto;
    }

}
