package com.example.model;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @program: SpringBootDemo
 * @description:
 * @author: May
 * @create: 2019-10-25 09:44
 */
public class Test1 {
  public void log4j2_test() {
    Logger logger = LogManager.getLogger(Test1.class.getName());
    logger.debug("使用log4j2打印日志");
  }

}
