package com.seldom.business.controller.admin;

import com.github.pagehelper.PageInfo;
import com.seldom.server.domain.Section;
import com.seldom.server.dto.SectionDto;
import com.seldom.server.dto.PageDto;
import com.seldom.server.dto.ResponseDto;
import com.seldom.server.exception.ValidatorException;
import com.seldom.server.service.SectionService;
import com.seldom.server.util.ValidatorUtil;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/section")
public class SectionController {

    private static final Logger LOG = LoggerFactory.getLogger(SectionController.class);
    public static final String BUSINESS_NAME = "section";

    @Resource
    private SectionService sectionService;

    /**
     * 列表查询
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
//    public PageDto list(PageDto pageDto) { 这种写法只能接受表单form方式的参数，而不能接受json参数
        LOG.info("pageDto: {}", pageDto);
        ResponseDto responseDto = new ResponseDto();
        sectionService.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody SectionDto sectionDto ) {
        LOG.info("sectionDto: {}", sectionDto);

        // 保存校验

        ResponseDto responseDto = new ResponseDto();
        sectionService.save(sectionDto);
        responseDto.setContent(sectionDto);
        return responseDto;
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        LOG.info("id: {}", id);
        ResponseDto responseDto = new ResponseDto();
        sectionService.delete(id);
        return responseDto;
    }

}
