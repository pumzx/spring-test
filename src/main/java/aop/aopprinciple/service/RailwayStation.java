package aop.aopprinciple.service;

/**
 * @author panzhixiong
 * @date 2018/12/3
 */
public class RailwayStation implements TicketService {
    @Override
    public void sellTicket() {
        System.out.println("售票");
    }

    @Override
    public void inquire() throws Exception {
        System.out.println("查询");
        throw new Exception("ex");
    }

    @Override
    public void withdraw() {
        System.out.println("退票");
    }
}
