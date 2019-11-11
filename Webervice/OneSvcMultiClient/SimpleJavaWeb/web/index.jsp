<%--
  Created by IntelliJ IDEA.
  User: w24982
  Date: 2019/11/11
  Time: 18:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
    <script type="text/javascript">
        /*
            思路：
            1.创建一个XMLHTTP对象
            2.打开链接open("POST",url)
            3.设置请求头Content-Type
            4.设置回调函数，处理返回值
            5.从返回的XML中解析我们要的内容
        */

        // var xmlHttpReqquest = new ActiveXObject("Microsoft.XMLHTTP");
        var xmlHttpReqquest = new XMLHttpRequest("Microsoft.XMLHTTP");
        //alert(xmlHttpReqquest);

        //发送SOAP请求
        function sendMsg() {
            //获取用户输入的内容
            var name = document.getElementById("name").value;
            var url = "http://localhost:9090/MyFirstWebService";
            //下面的这种格式主要是通过Eclipse下载了一个webservice调式工具，这样就可以看到对应的xml格式内容
            // var requestBody = "<soapenv:Envelope xmlns:soapenv=\"http://schemas.xmlsoap.org/soap/envelope/\" xmlns:q0=\"http://tc.org/\" xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
            <%--    + "<soapenv:Body><q0:testWebService><arg0>" + name + "</arg0></q0:testWebService></soapenv:Body></soapenv:Envelope>";--%>
            var requestBody = "<soapenv:Envelope xmlns:soapenv=" +
                    "\"http://schemas.xmlsoap.org/soap/envelope/\" " +
                    "xmlns:q0=\"http://tc.org/\" " +
                    "xmlns:xsd=\"http://www.w3.org/2001/XMLSchema\" " +
                    "xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\">"
                    +"<soapenv:Body>"
                    +"<q0:testWebService>"
                    +"<arg0>my name is " + name + "</arg0> "
                    +"</q0:testWebService>"
                    +"</soapenv:Body>"
                    +"</soapenv:Envelope>";
          xmlHttpReqquest.open("POST", url);
            xmlHttpReqquest.setRequestHeader("Content-Type", "text/xml;charset=utf-8");
            xmlHttpReqquest.onreadystatechange = _back;
            xmlHttpReqquest.send(requestBody);
        }

        //接收SOAP返回，从返回XML中解析
        function _back() {
            //处理完毕，处理成功
            if (xmlHttpReqquest.readystate == 4) {		//处理完
                if (xmlHttpReqquest.status == 200) {	//成功
                    var xml = xmlHttpReqquest.responseXML;
                    //alert(xml);

                    //获取return标签的第一个
                    var ele = xml.getElementsByTagName("return")[0];
                    alert(ele.text);
                } else {
                    alert(0);
                }
            }
        }

    </script>
</head>
<body>
<input type="text" id="name" name="name" value=""/>
<input type="button" name="send" value="send" onclick="sendMsg()"/>
</body>
</html>
