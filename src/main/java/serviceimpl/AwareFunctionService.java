package serviceimpl;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ResourceLoaderAware;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Service;

import java.io.IOException;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */
@Service
public class AwareFunctionService implements BeanNameAware, ResourceLoaderAware {

    private String beanName;
    private ResourceLoader resourceLoader;

    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        this.resourceLoader = resourceLoader;
    }

    /**
     * aware相关功能就是使用spring容器相关服务功能，比如：
     * BeanNameAware:获得容器中Bean的名字
     * BeanFactoryAware:获得当前Bean工厂，可以调用容器的服务
     * ApplicationContextAware:获取Application context,它集成了其他所有服务。all
     * ApplicationEventPublisherAware:应用事件发布器，可以发布事件
     * ResourceLoaderAware:资源加载器，加载外部资源文件
     *
     */
    public void outPutInfo() {
        System.out.println("bean name:" + beanName);
        Resource resource = resourceLoader.getResource("classpath:el/test.txt");
        try {
            System.out.println("test.txt:" + IOUtils.toString(resource.getInputStream()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
