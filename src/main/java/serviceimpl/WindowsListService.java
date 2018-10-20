package serviceimpl;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */
public class WindowsListService implements ListService {
    @Override
    public String showListCmd() {
        return "dir";
    }
}
