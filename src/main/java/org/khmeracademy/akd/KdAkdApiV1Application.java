package org.khmeracademy.akd;

import org.apache.tomcat.util.descriptor.web.ErrorPage;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.support.ErrorPageFilter;
import org.springframework.context.annotation.Bean;
import  org.springframework.boot.web.*;

@SpringBootApplication
public class KdAkdApiV1Application {

	public static void main(String[] args) {
		SpringApplication.run(KdAkdApiV1Application.class, args);
	}


//	@Bean
//	public ErrorPageFilter errorPageFilter(){
//		return new ErrorPageFilter();
//	}
//
//	@Bean
//	public FilterRegistrationBean disableSpringBootErrorFilter(ErrorPageFilter filter){
//		FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
//		filterRegistrationBean.setFilter(filter);
//		filterRegistrationBean.setEnabled(false);
//		return filterRegistrationBean;
//
//	}
}
