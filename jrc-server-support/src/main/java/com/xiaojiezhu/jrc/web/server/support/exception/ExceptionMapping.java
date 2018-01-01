package com.xiaojiezhu.jrc.web.server.support.exception;

import com.xiaojiezhu.jrc.web.server.support.exception.ex.NoticeException;

/**
 * @author xiaojie.zhu
 */
public class ExceptionMapping {

    public static boolean isPrintError(Throwable t){
        if(t instanceof NoticeException){
            return false;
        }else {
            return true;
        }
    }

    public static int getErrorCode(Throwable t){
        return 500;
    }
}
