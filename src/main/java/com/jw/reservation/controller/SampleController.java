package com.jw.reservation.controller;

import java.sql.Connection;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

//@Controller
//public class SampleController {
//	
//	@RequestMapping(value = "/")
//	@ResponseBody
//	public String sample() {
//		
//		return "Hello Gradle!";
//	}
//
//}
@Slf4j
@Component
public class SampleController implements ApplicationRunner {

    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;
    
    @Override
    public void run(ApplicationArguments args) throws Exception {
    	
//    	CodeConst.DOCTOR_TP_CD_MEDICINE.toString();

        // DataSource
        Connection connection = dataSource.getConnection();
        log.info("Url: " + connection.getMetaData().getURL());
        log.info("UserName: " + connection.getMetaData().getUserName());

        // JdbcTemplate
        jdbcTemplate.execute("INSERT INTO Products (prod_name, prod_price) values ('버킷햇', 6900)");
    }
}