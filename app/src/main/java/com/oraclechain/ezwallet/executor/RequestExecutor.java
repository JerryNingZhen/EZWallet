package com.oraclechain.pocketeos.executor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 请求工具类
 * <p>
 * <br> Author: 谭俊
 * <br> Version: 1.0.0
 * <br> Date: 2016年5月19日
 * <br> Copyright: Copyright © 2016 xTeam Technology. All rights reserved.
 */
public class RequestExecutor {

    /** 请求线程池队列，同时允许5个线程操作 */
    private static ExecutorService executorService = Executors.newFixedThreadPool(5);

/*    public static void addTask(RequestTask task) {
        executorService.submit(task);
    }

    public static void addTask(BaseTask task) {
        executorService.submit(task);
    }*/

    public static void addTask(Runnable task) {
        executorService.submit(task);
    }

    /**
     * 关闭线程池
     * <p>
     * <br> Version: 1.0.0
     * <br> CreateTime: 2016-10-25,下午4:58:51
     * <br> UpdateTime: 2016-10-25,下午4:58:51
     * <br> CreateAuthor: 叶青
     * <br> UpdateAuthor: 叶青
     * <br> UpdateInfo: (此处输入修改内容,若无修改可不写.)
     */
    public static void shutdown() {
        executorService.shutdown();
    }

}