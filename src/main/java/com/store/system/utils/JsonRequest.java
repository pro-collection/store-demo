package com.store.system.utils;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonRequest {

    /**
     * 获取request payload
     * @param request request
     * @return string
     */
    public static String getPayload(HttpServletRequest request) {
        int nRead;
        int nTotalRead;
        byte[] bytes;
        ServletInputStream inputStream;
        try {
            inputStream = request.getInputStream();
            nRead = 1;
            nTotalRead = 0;
            bytes = new byte[1024 * 10];
            while (nRead > 0) {
                nRead = inputStream.read(bytes, nTotalRead, bytes.length - nTotalRead);
                if (nRead > 0) {
                    nTotalRead = nTotalRead + nRead;
                }
            }
            return new String(bytes, 0, nTotalRead, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
            return "";
        }
    }
}
