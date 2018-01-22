package com.xiaojiezhu.jrc.common.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author xiaojie.zhu
 */
public class IOUtil {

    public static String toString(InputStream inputStream) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
        String line;
        StringBuffer sb = new StringBuffer();
        while ((line = reader.readLine()) != null){
            sb.append(line).append("\n");
        }
        return sb.toString();
    }
}
