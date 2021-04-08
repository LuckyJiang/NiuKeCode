package com.min;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AboutMySQlApplication {

	/**
	 * --mysql创建表的时候，表名和字段名一定要有反向单引号
	 * --mysql插入数据的时候不能有符号
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(AboutMySQlApplication.class, args);
	}

}
