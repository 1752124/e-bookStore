//显示书籍具体信息
window.onload = function (){
    console.log(window.location)
    let bookId = window.location.search.split("=")[1]
    if (bookId) {
        // //创建核心对象
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
                if (text) {
                    var resultJson = eval("(" + text + ")"); //把响应内容对象转成javascript对象
                    console.log(resultJson);
                    var str="<li><dl><dd>";
                    str+="<a onclick='toBookDetail("+resultJson.id+")'> <img src=" + (hosturl+resultJson.cover) + "></a></dd>";
                    str+="<dt>"
                    str+="<p class=\"book_title\"><a>"+ resultJson.title +"</a></p>";
                    str+="<p class=\"book_inline\">"+ resultJson.author +"</p>";
                    str+="<p class=\"book_inline\">"+ resultJson.publisher +"</p>";
                    str+="<p class=\"book_inline\">"+ resultJson.introduction +"</p>";
                    str+="<p class=\"book_inline\">$ "+ resultJson.price +"</p>";
                    str+="<p class=\"book_inline\">数量：<input id='number-input' value='0' size='1'></p><br/>";
                    str+="<button class=\"book_buy\" onclick='addCart("+resultJson.id+")'>ADD CART</button><br/><br/>";
                    str+="<button class=\"book_buy\" onclick='confirmOrder("+resultJson.id+")'>BUY &nbspNOW</button>";
                    str+="</dt></dl></li>";
                        var dot=document.createElement("SHOWBOOKDETAIL");
                        dot.innerHTML=str;
                        document.getElementById("book-detail").appendChild(dot);
                    // }
                }
            }
        }
        //open设置请求方式和请求路径
        xmlhttp.open("get", "http://47.101.56.99:8080/demoproject/v1/book-management/books?id=" + bookId);//一个servlet，后面还可以写是否同步
        //send 发送
        xmlhttp.send();

    }
    // window.location ="bookDetail.html?id="+point
    // console.log(1);
    
}