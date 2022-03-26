package com.blueskytelco.customerservice.config;

import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.ws.config.annotation.EnableWs;
import org.springframework.ws.config.annotation.WsConfigurerAdapter;
import org.springframework.ws.transport.http.MessageDispatcherServlet;
import org.springframework.ws.wsdl.wsdl11.DefaultWsdl11Definition;
import org.springframework.xml.xsd.SimpleXsdSchema;
import org.springframework.xml.xsd.XsdSchema;

@EnableWs
@Configuration
public class SoapWsConfig extends WsConfigurerAdapter {

    @Bean
    public ServletRegistrationBean messageDispatcherServlet(ApplicationContext context) {
        MessageDispatcherServlet servlet = new MessageDispatcherServlet();
        servlet.setApplicationContext(context);
        servlet.setTransformWsdlLocations(true);
        return new ServletRegistrationBean(servlet, "/service/*");
    }

    @Bean
    public XsdSchema compliantSchema() {
        return new SimpleXsdSchema(new ClassPathResource("complaint.xsd"));
    }

    @Bean(name = "complaintDetailsWsdl")
    public DefaultWsdl11Definition defaultWsdl11Definition(XsdSchema compliantSchema) {
        DefaultWsdl11Definition definition = new DefaultWsdl11Definition();
        definition.setSchema(compliantSchema);
        definition.setPortTypeName("CompliantServicePort");
        definition.setLocationUri("/service/complaint-service");
        definition.setTargetNamespace("http://blueskytelco.com/customerservice/complaint");
        return definition;
    }
}
