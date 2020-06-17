let userInfoStr = localStorage.getItem('userInfo')
let resJson = JSON.parse(userInfoStr);// 获取用户ID

//创建核心对象
xmlhttp = null;
if (window.XMLHttpRequest) {// code for Firefox, Opera, IE7, etc.
    xmlhttp = new XMLHttpRequest();
} else if (window.ActiveXObject) {// code for IE6, IE5
    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
}
//编写回调函数
xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var text = xmlhttp.responseText; //使用接口返回内容，响应内容
        var resultJson = eval("(" + text + ")"); //把响应内容对象转成javascript对象
        console.log(resultJson);
        for (var i = 0; i < resultJson.length; i++) {
            // var str='<td>';
            // str+="<a onclick='toBookDetail("+resultJson[i].book.id+")'> <img src=" + resultJson[i].cover + " ></a>";
            // str+= "<div><span>书名:"+ resultJson[i].book.title +"</span><br/>";
            // str+= "<span>售价:"+ resultJson[i].book.price +"</span><br/>";
            // str+= "<span>数量:"+ resultJson[i].number +"</span><br/>";
            // str+= "<span>实付款:"+ resultJson[i].book.price *resultJson[i].number+"</span><br/>";
            // str+= "</div></td>";
            var str="<li><dl><dd>";
            str+="<a onclick='toBookDetail("+resultJson[i].book.id+")'> <img src=" + (hosturl+resultJson[i].book.cover) + "></a></dd>";
            str+="<dt>"
            str+="<p class=\"book_title\"><a>"+ resultJson[i].book.title +"</a></p>";
            str+="<p class=\"book_inline\">$ "+ resultJson[i].book.price +"</p>";
            str+="<p class=\"book_inline\">数量："+ resultJson[i].number +"</p><br/>";
            str+="<p class=\"book_inline\">实付款：$ "+ resultJson[i].book.price *resultJson[i].number+"</p><br/>";
            str+="</dt></dl></li>";
            var dot=document.createElement("ADDBOOK");
            dot.innerHTML=str;
            document.getElementById("order-list").appendChild(dot);
        }
    }
}
//open设置请求方式和请求路径
xmlhttp.open("get", "http://47.101.56.99:8080/demoproject//v1/order-management/orderlists?userid=" + resJson.id);//一个servlet，后面还可以写是否同步
//send 发送
xmlhttp.send();