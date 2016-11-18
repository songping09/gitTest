package com.bwf.lgqingdan.utils;

import android.content.Context;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by Administrator on 2016/11/14.
 */

public class IO {
    /**
     * 读取Assets中的文本文件
     * @param context
     * @param filePath
     * @return
     */
    public static String readAssetsFile(Context context,String filePath){
        BufferedReader br = null;
        try {
            InputStream inputStream =  context.getAssets().open(filePath);
            br = new BufferedReader(new InputStreamReader(inputStream,"utf-8"));

            StringBuffer sb = new StringBuffer();
            String line;
            while((line = br.readLine()) != null){
                sb.append(line);
                sb.append("\n");
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(br != null){
                try {
                    br.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

}
