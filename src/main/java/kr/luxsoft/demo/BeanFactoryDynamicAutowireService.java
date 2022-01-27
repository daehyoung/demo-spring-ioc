package kr.luxsoft.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.Region;
import java.util.Map;

@Slf4j
//@Service
public class BeanFactoryDynamicAutowireService {
//    ApplicationContext context;
    private static final String SERVICE_NAME_SUFFIX = "regionService";
//    private final BeanFactory beanFactory;
    private final Map<String,RegionService> context;

    @Autowired
    public BeanFactoryDynamicAutowireService(ApplicationContext context) {
        this.context = context.getBeansOfType(RegionService.class);
    }

    public boolean isServerActive(String isoCountryCode, int serverId) {
        log.info("isoCountryCode = {}",isoCountryCode);
        RegionService service = context.get(isoCountryCode+"RegionService");
        return service.isServerActive(serverId);
    }

    private String getRegionServiceBeanName(String isoCountryCode) {
        return isoCountryCode + SERVICE_NAME_SUFFIX;
    }
}