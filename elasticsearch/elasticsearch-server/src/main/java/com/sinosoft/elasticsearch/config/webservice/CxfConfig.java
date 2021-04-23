package com.sinosoft.elasticsearch.config.webservice;

import org.apache.cxf.Bus;
import org.apache.cxf.jaxws.EndpointImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.xml.ws.Endpoint;

/**
 * cxf配置
 */
@Configuration
public class CxfConfig {
    @Autowired
    private Bus bus;
    @Autowired
    private TestService testService;

    @Bean
    public Endpoint testEndpoint(){
        EndpointImpl endpoint = new EndpointImpl(bus, testService);
        endpoint.publish("/TestService");
        return endpoint;
    }

    /**
     * 配置ServletRegistrationBean时，需要注意设置方法的名称或者bean的名称时，
     * 不要和默认的DispatcherServlet类重名了，会导致原先的mvc接口无法使用，因为被覆盖了
     * 修改访问的路径可以通过设置ServletRegistrationBean来修改，但同时，要注意需要设置bean的名称为cxfServletRegistration，
     * 不然会造成注册多个CXFServlet的。具体原因可查看自动配置类：org.apache.cxf.spring.boot.autoconfigure.CxfAutoConfiguration。
     * @return
     */
//    @Bean("cxfServletRegistration")
//    public ServletRegistrationBean dispatcherServlet() {
//        //注册servlet 拦截/ws 开头的请求 不设置 默认为：/services/*
//        return new ServletRegistrationBean(new CXFServlet(), "/ws/*");
//    }

}
