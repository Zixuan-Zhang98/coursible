package com.seldom.${module}.controller.admin;

import com.github.pagehelper.PageInfo;
import com.seldom.server.domain.${Domain};
import com.seldom.server.dto.${Domain}Dto;
import com.seldom.server.dto.PageDto;
import com.seldom.server.dto.ResponseDto;
import com.seldom.server.exception.ValidatorException;
import com.seldom.server.service.${Domain}Service;
import com.seldom.server.util.ValidatorUtil;
import org.apache.ibatis.annotations.Delete;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/admin/${domain}")
public class ${Domain}Controller {

    private static final Logger LOG = LoggerFactory.getLogger(${Domain}Controller.class);
    public static final String BUSINESS_NAME = "${tableName}";

    @Resource
    private ${Domain}Service ${domain}Service;

    /**
     * 列表查询
     */
    @PostMapping("/list")
    public ResponseDto list(@RequestBody PageDto pageDto) {
//    public PageDto list(PageDto pageDto) { 这种写法只能接受表单form方式的参数，而不能接受json参数
        LOG.info("pageDto: {}", pageDto);
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.list(pageDto);
        responseDto.setContent(pageDto);
        return responseDto;
    }

    /**
     * 保存，id有值时更新，无值时新增
     */
    @PostMapping("/save")
    public ResponseDto save(@RequestBody ${Domain}Dto ${domain}Dto ) {
        LOG.info("${domain}Dto: {}", ${domain}Dto);

        // 保存校验
        ValidatorUtil.require(${domain}Dto.getName(), "Name");
        ValidatorUtil.require(${domain}Dto.getCourseId(), "Course ID");
        ValidatorUtil.length(${domain}Dto.getCourseId(), "Course ID", 1, 8);

        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.save(${domain}Dto);
        responseDto.setContent(${domain}Dto);
        return responseDto;
    }

    /**
     * 删除
     */
    @DeleteMapping("/delete/{id}")
    public ResponseDto delete(@PathVariable String id) {
        LOG.info("id: {}", id);
        ResponseDto responseDto = new ResponseDto();
        ${domain}Service.delete(id);
        return responseDto;
    }

}
