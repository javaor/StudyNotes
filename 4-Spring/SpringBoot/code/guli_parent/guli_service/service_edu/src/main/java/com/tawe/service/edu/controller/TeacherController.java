package com.tawe.service.edu.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.tawe.common.service.base.exception.ResourceNotFoundException;
import com.tawe.common.utils.ResultCode;
import com.tawe.common.utils.ResultEntity;
import com.tawe.common.utils.ResultMsg;
import com.tawe.service.edu.entity.Teacher;
import com.tawe.service.edu.query.TeacherQuery;
import com.tawe.service.edu.service.TeacherService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.sql.Timestamp;
import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author tawe
 * @since 2020-10-29
 */
@Api("讲师管理")
@RestController
@RequestMapping("/edu/teacher")
// 已用配置类实现
// @CrossOrigin
public class TeacherController {

    @Resource
    private TeacherService teacherService;

    @ApiOperation("新增讲师")
    @PostMapping("save")
    public ResultEntity save(
            @ApiParam(name = "Teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher
    ) {
        boolean save = teacherService.save(teacher);
        return save ? ResultEntity.ok() : ResultEntity.error();
    }


    @ApiOperation("查询所有讲师信息")
    @GetMapping("select-all")
    public ResultEntity selectAll() {

        List<Teacher> teachers = teacherService.selectAll();
        if (teachers.isEmpty()) {
            return ResultEntity.error();
        } else {
            return ResultEntity.ok().data("items", teachers);
        }
    }

    @ApiOperation("查询所有讲师信息 - 分页展示")
    @PostMapping("select-all")
    public ResultEntity selectAll(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @RequestParam(value = "page") Integer page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @RequestParam(value = "limit") Integer limit,
            @ApiParam(name = "teacherQuery", value = "查询对象")
            @RequestBody TeacherQuery teacherQuery
    ) {
        Page<Teacher> pageParam = new Page<>(page, limit);
        teacherService.pageQuery(pageParam, teacherQuery);
        // teacherService.page(pageParam, null);
        List<Teacher> teachers = pageParam.getRecords();
        long total = pageParam.getTotal();
        if (teachers.isEmpty()) {
            return ResultEntity.ok().message(ResultMsg.NO_DATA);
        } else {
            // return ResultEntity.ok().data("items", pageParam);
            return ResultEntity.ok().data("total", total).data("rows", teachers);
        }
    }

    @ApiOperation("查询所有讲师信息 - 分页展示")
    @PostMapping("select-all/{page}/{limit}")
    public ResultEntity selectAllWithPage(
            @ApiParam(name = "page", value = "当前页码", required = true)
            @PathVariable(value = "page") Integer page,
            @ApiParam(name = "limit", value = "每页记录数", required = true)
            @PathVariable(value = "limit") Integer limit,
            @ApiParam(name = "teacherQuery", value = "查询对象")
            @RequestBody TeacherQuery teacherQuery
    ) {
        return selectAll(page, limit, teacherQuery);
    }

    @ApiOperation("根据 ID 查询讲师信息")
    @GetMapping("select/{id}")
    public ResultEntity selectById(
            @ApiParam(name = "id", value = "讲师 ID", required = true)
            @PathVariable("id")String id) {

        Teacher teacher = teacherService.getById(id);
        if (teacher == null) {
            throw new ResourceNotFoundException(ResultCode.NO_DATA.getCode(), ResultMsg.NO_DATA);
            // return ResultEntity.error().message(ResultMsg.NO_DATA);
        } else {
            return ResultEntity.ok("item", teacher);
        }
    }

    @ApiOperation("根据 ID 修改讲师")
    @PutMapping("update")
    public ResultEntity updateById(
            // @ApiParam(name = "id", value = "讲师 ID", required = true)
            // @RequestParam("id") String id,
            @ApiParam(name = "teacher", value = "讲师对象", required = true)
            @RequestBody Teacher teacher
    ) {
        // teacher.setId(id);
        teacher.setGmtModified(new Timestamp(System.currentTimeMillis()));
        boolean result = teacherService.updateById(teacher);
        return result ? ResultEntity.ok() : ResultEntity.error();
    }

    @ApiOperation("根据 ID 删除讲师")
    @DeleteMapping("delete/{id}")
    public ResultEntity deleteById(@PathVariable("id") String id) {
        boolean status = teacherService.deleteById(id);
        if (status) {
            return ResultEntity.ok();
        } else
        {
            return ResultEntity.error();
        }
    }
}

