package com.omega.demo08.component3;

import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * Class AdminController
 *
 * @author KennySo
 * @date 2024/5/29
 */
@Controller
public class AdminController {

    // @Autowired  // 由于实现类有两个, 所以需要借助 @Resource 进行识别; 或者将其中一个实现类的 id 指定为 adminService
    @Resource(type = AdminServiceImpl2.class)
    private AdminService adminService;

    public void say() {
        System.out.println("AdminService.adminService = " + adminService);
        adminService.hi();
    }
}
