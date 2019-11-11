package org.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.List;

public class URLConnectionTest {


    public static void main(String args[]) throws IOException {
        //创建url地址
        URL url = new URL("http://localhost:9090/MyFirstWebService");
        //打开连接
        URLConnection conn = url.openConnection();
        //转换成HttpURL
        HttpURLConnection httpConn = (HttpURLConnection) conn;
        //打开输入输出的开关
        httpConn.setDoInput(true);
        httpConn.setDoOutput(true);
        //设置请求方式
        httpConn.setRequestMethod("POST");
        //设置请求的头信息
        httpConn.setRequestProperty("Content-type", "text/xml;charset=UTF-8");
        //拼接请求消息
        String data = "<soapenv:Envelope xmlns:soapenv=" +
                "\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                "xmlns:q0=\"http://tc.org/\" " +
                "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                +"<soapenv:Body>"
                +"<q0:testWebService>"
                +"<arg0>my name is scw</arg0> "
                +"</q0:testWebService>"
                +"</soapenv:Body>"
                +"</soapenv:Envelope>";
        //获得输出流
        OutputStream out = httpConn.getOutputStream();
        //发送数据
        out.write(data.getBytes());
        //判断请求成功
        if(httpConn.getResponseCode() == 200) {
            //获得输入流
            InputStream in = httpConn.getInputStream();
            //使用输入流的缓冲区
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            StringBuffer sb = new StringBuffer();
            String line = null;
            //读取输入流
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }

            try {
                //创建sax的读取器
                SAXReader saxReader = new SAXReader();
                //创建文档对象
                Document doc = saxReader.read(new StringReader(sb.toString()));
                //获得请求响应return元素
//                Node returnNode = doc.selectSingleNode("S:Envelope/*/*");
//                String res = returnNode.selectSingleNode("return").getStringValue();
//                System.out.println(res);
            List<Element> eles = doc.selectNodes("//return");
            for (Element ele : eles) {
                System.out.println(ele.getText());
            }
            } catch (DocumentException de) {

            }

        }
    }
}

/**
 *
 * java.lang.ClassNotFoundException: org.jaxen.JaxenException；
 * 使用dom4j-1.6.1.jar时，需要另一个包jaxen-1.1-beta-6.jar提供支持
 *
 *
 *
 *
 */










