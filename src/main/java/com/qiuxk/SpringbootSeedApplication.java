package com.qiuxk;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 *
 *
 * @author qiuxk
 * @classes org.springframework.boot.autoconfigure.SpringBootApplication
 * @date 2020-06-22 15:51
 */

@SpringBootApplication(scanBasePackages = "com.qiuxk")
//@MapperScan("com.qiuxk.mapper")
public class SpringbootSeedApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootSeedApplication.class, args);
	}

}
