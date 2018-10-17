package serviceimpl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author panzhixiong
 * @date 2018/10/16
 */
@Service
public class ElFunctionService {
    @Value("other class properties")
    private String another;

    public String getAnother() {
        return another;
    }

    public void setAnother(String another) {
        this.another = another;
    }
}
