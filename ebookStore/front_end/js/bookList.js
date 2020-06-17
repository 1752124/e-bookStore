//首页展示book list
var xmlhttp;
if (window.XMLHttpRequest) {
    //  IE7+, Firefox, Chrome, Opera, Safari 浏览器执行代码
    xmlhttp = new XMLHttpRequest();
} else {
    // IE6, IE5 浏览器执行代码
    xmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
}

xmlhttp.onreadystatechange = function() {
    if (xmlhttp.readyState == 4 && xmlhttp.status == 200) {
        var text = xmlhttp.responseText; //使用接口返回内容，响应内容
        var resultJson = eval("(" + text + ")"); //把响应内容对象转成javascript对象
        console.log(resultJson);
        for (var i = 0; i < resultJson.length; i++) {
            var str="<li><dl><dd>";
        str+="<a onclick='toBookDetail("+resultJson[i].id+")'> <img src=" + (hosturl+resultJson[i].cover) + "></a></dd>";
        str+="<dt>"
            str+="<p class=\"book_title\"><a>"+ resultJson[i].title +"</a></p>";
        str+="<p class=\"book_inline\">"+ resultJson[i].price +"</p>";
        str+="<a class=\"book_buy\" onclick='toBookDetail("+resultJson[i].id+")'>BUY</a>";
        str+="</dt></dl></li>";
            var dot=document.createElement("ADDBOOK");
            dot.innerHTML=str;
            document.getElementById("book-list").appendChild(dot);
        }
    }
}
xmlhttp.open("GET", "http://47.101.56.99:8080/demoproject/v1/book-management/booklists", true);
xmlhttp.send();