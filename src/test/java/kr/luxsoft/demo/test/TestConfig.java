package kr.luxsoft.demo.test;

import kr.luxsoft.demo.*;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class TestConfig {

    @Bean("USRegionService")
    public USRegionService getUSRegionService(){
        return new USRegionService();
    }

    @Bean("GBRegionService")
    public GBRegionService getGBRegionService(){
        return new GBRegionService();
    }

    @Bean
    public BeanFactoryDynamicAutowireService getBeanFactoryDynamicAutowireService(ApplicationContext context){
        return new BeanFactoryDynamicAutowireService(context);
    }

    @Bean
    public CustomMapFromListDynamicAutowireService getCustomMapFromListDynamicAutowireService(List<RegionService> regionServices){
        return new CustomMapFromListDynamicAutowireService(regionServices);
    }
}
