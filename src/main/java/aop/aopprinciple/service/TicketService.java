package aop.aopprinciple.service;

/**
 * @author panzhixiong
 * @date 2018/12/3
 */
public interface TicketService {
    /**
     * 售票
     */
    public void sellTicket();

    /**
     * 问询查票
     */
    public void inquire() throws Exception;

    /**
     * 退票
     */
    public void withdraw();
}
