<%--
  Created by IntelliJ IDEA.
  User: 83470
  Date: 2018/6/4
  Time: 20:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>显示商品</title>
</head>
<body>
<a href="javascript:void(0)" id="add">添加商品</a>
<a href="javascript:void(0)" id="show">显示商品</a>
<div id="showProduct"></div>
<form id="addForm">
    商品编号:<input name="product.id"/>
    商品名称:<input name="product.name"/>
    商品数量:<input name="product.count"/>
    商品价格:<input name="product.price"/>
</form>
</body>
<script type="text/javascript" src="/js/jquery-1.8.3.js"></script>
<script type="text/javascript">
    var i = 1;
    $("#show").bind("click", function () {
        if (i == 1) {
            $.post("${ pageContext.request.contextPath }/showProduct", function (data) {
                var jsonObj = eval(data);
                if (jsonObj.type == 1) {
                    var html = "";
                    html += "<table border='1'><tr><td>商品编号</td><td>商品名称</td><td>商品数量</td><td>商品价格</td></tr>";
                    var jsonObj = eval(data);


                    $(jsonObj.content).each(function () {
                        html += "<tr><td>" + this.id + "</td><td>" + this.name + "</td><td>" + this.count + "</td><td>" + this.price + "</td></tr>"
                    })
                    html += "</table>";
                    $("#showProduct").html(html);
                    i = 0;
                } else {
                    $("#showProduct").html(jsonObj.message);
                }
            }, "json");
        } else {
            $("#showProduct").html("");
            i = 1;
        }
    })

    $("#add").bind("click", function () {
        var product = $("#addForm").serialize();
        $.post("${ pageContext.request.contextPath }/addProduct?"+product,function (data) {
            var jsonObj = eval(data);
            if (jsonObj.type == 1) {
                $("#showProduct").html(jsonObj.message);
            } else {
                $("#showProduct").html(jsonObj.message);
            }
        }, "json");

    })

    // 自定义的jquery函数
    $.fn.extend({
        serializeJson : function() {
            var json = {}; // 就是一个javascript的对象.
            // 1.通过jquery提供的serializeArray方法得到不符合要求的json串
            var msg = this.serializeArray();
            // console.info(msg);
            // [Object { name="username", value="tom"}, Object { name="password",
            // value="123"}, Object { name="hobby", value="eat"}, Object {
            // name="hobby", value="drink"}, Object { name="hobby", value="play"}]
            $(msg).each(function() {
                if (json[this.name]) { // 在json对象中没有this.name对应的值
                    // 有,需要考虑一个名称对应多个值，而这些值应该放入到数组中
                    if (!json[this.name].push) { // 如果为true,代表是数组,如果为false，代表不是数组
                        json[this.name] = [ json[this.name] ];
                    }
                    json[this.name].push(this.value || ''); // 装入到数组

                } else {
                    // 没有
                    json[this.name] = this.value || '';
                }
            });

            return json
        }
    });
</script>
</html>
