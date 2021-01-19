package com.nchu.countryside;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author Potter
 */
@SpringBootApplication
@MapperScan({"com.nchu.countryside.dao"})
public class CountrysideApplication {

    public static void main(String[] args) {
        SpringApplication.run(CountrysideApplication.class, args);
    }

}
