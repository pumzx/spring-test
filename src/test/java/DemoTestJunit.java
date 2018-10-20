import config.TestFunConfig;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import serviceimpl.TestFunctionService;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestFunConfig.class})
@ActiveProfiles("dev")
public class DemoTestJunit {
    @Autowired
    private TestFunctionService testFunctionService;

    @Test
    public void prdBeanTest() {
        String expected = "from dev";
        String actual = testFunctionService.getContent();
        Assert.assertEquals(expected, actual);
    }
}
