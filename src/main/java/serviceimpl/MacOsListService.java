package serviceimpl;

import service.ListService;

/**
 * @author panzhixiong
 * @date 2018/10/20
 */
public class MacOsListService implements ListService {
    @Override
    public String showListCmd() {
        return "ls";
    }
}
