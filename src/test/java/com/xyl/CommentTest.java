package com.xyl;

import com.jd.jypt.flow.sku.entity.SkuClient;
import org.junit.Test;

import java.io.InputStream;

/**
 * @Author: xieyinglin
 * @Date: 2019/7/10 上午11:53
 */
public class CommentTest {

    @Test
    public void testFile() throws Exception{
        InputStream  inputStream = CommentTest.class.getClassLoader().getResourceAsStream("banner.txt");

        byte[] buffers = new byte[1024];
        int length = 0;

        while ((length = inputStream.read(buffers)) != -1){
            System.out.print(new String(buffers, 0, length));
        }


    }






    @Test
    public void testEqual(){
        System.out.println("".equals(null));
    }


    @Test
    public void testSku(){

        Long skuId = 1000L;
        SkuClient.getSkuInfo(skuId);//查询 sku 基本信息，先从 jimdb 中查询，没有则从 hbase 中查询并写入 jimdb，有效期 2 天


        SkuClient.querySkuInfoFromHbase(skuId);//直接从 hbase 中查询，不建议直接使用该方法，可优先使用 SkuClient.getSkuInfo(skuId);





    }
}
