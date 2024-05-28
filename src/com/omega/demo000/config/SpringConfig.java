package com.omega.demo000.config;

import com.omega.demo000.annotation.CustomComponentScan;

/**
 * Class SpringConfig
 *    作用类似于beans.xml文件, 用于对spring容器指定配置信息
 *
 * @author KennySo
 * @date 2024/5/27
 */
@CustomComponentScan("com.omega.demo000.component")
public class SpringConfig {
}
