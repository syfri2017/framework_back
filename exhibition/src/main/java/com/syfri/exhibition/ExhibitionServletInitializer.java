package com.syfri.exhibition;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;

/**
 * Exhibition程序启动类
 *
 * @author lixiaoyang
 * @date 2017年9月29日09:00:42
 */
public class ExhibitionServletInitializer extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
        return builder.sources(ExhibitionApplication.class);
    }

}
