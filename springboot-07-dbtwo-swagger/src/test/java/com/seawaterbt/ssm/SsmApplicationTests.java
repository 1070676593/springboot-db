package com.seawaterbt.ssm;

import com.seawaterbt.ssm.service.StudentService;
import com.seawaterbt.ssm.service.TeacherService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SsmApplicationTests {

    @Autowired
    private StudentService studentService;
    @Autowired
    private TeacherService teacherService;

    @Test
    public void contextLoads() {
        System.out.println(studentService.selectById(1));
        System.out.println(teacherService.selectById(1));
    }

}
