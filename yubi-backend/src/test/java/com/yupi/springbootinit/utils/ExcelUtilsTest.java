package com.yupi.springbootinit.utils;

import org.junit.jupiter.api.Test;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

class ExcelUtilsTest {
    @Test
    public void testExcelToCsv() {
        try {
            File file = ResourceUtils.getFile("classpath:test_excel.xlsx");
            FileInputStream input = new FileInputStream(file);
            MockMultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "application/vnd.openxmlformats-officedocument.spreadsheetml.sheet", input);

            String csvContent = ExcelUtils.excelToCsv(multipartFile);
            assertNotNull(csvContent);
            System.out.println(csvContent);
        } catch (IOException e) {
            fail("Exception occurred during test execution: " + e.getMessage());
        }
    }

}