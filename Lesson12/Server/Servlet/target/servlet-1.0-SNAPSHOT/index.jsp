
<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="com.testHotel.controller.IHotelController" %>
<%@ page import="com.dependencyService.DependencyService" %>
<%@ page import="com.entity.Guest" %>
<%@ page import="com.dao.IRoomDAO" %>
<%@ page import="com.serverQueryService.ClientQueryService.ClientQueryService" %>

<head>

    <meta charset="utf-8">

    <title>Заголовок</title>
    <meta name="description" content="">

    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">

    <link rel="stylesheet" href="libs/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/fonts.css">
    <link rel="stylesheet"  href="css/css.css">


</head>

<body>


<%

    //  Object response1=ClientQueryService.queryHandler("{\"someMethod\":\"addRoom\",\"allParamList\":[{\"type\":\"room\",\"id\":12,\"number\":22,\"cost\":33,\"capacity\":123,\"stars\":55,\"status\":\"FREE\"}]}");

%>



<div id="wrap">
    <nav class="navbar navbar-inverse bg-inverse">
        <nav class="navbar navbar-light bg-faded">
            <h1 class="navbar-brand mb-0">Senla</h1>
        </nav>
    </nav>

    <div class="container">

        <div class="col-xs-12">
            <h1>Пример json</h1>
            <div> <p>{"someMethod":"addRoom","allParamList":[{"type":"room","id":1,"number":2,"cost":35,"capacity":4,"stars":5,"status":"FREE"}]}</p></div>


            <br>
            <div class="row">
                <div class="col-xs-6">

                    <label for="json">Json:</label>
                    <textarea class="form-control" rows="5" placeholder="some Json" id="json"></textarea>
                </div>

                <div class="col-xs-4">
                    <button type="button" class="btn btn-success" id="button" class="pushQuery">PushQuery</button>
                </div>
            </div>


            <div class="row">
                <div class="col-xs-6">
                    <label for="response">Response:</label>
                    <textarea class="form-control" rows="5"  placeholder="response"  id="response"></textarea>
                </div>


            </div>








        </div>






    </div>





    <script src="libs/jquery/jquery-3.2.1.min.js"></script>
    <script src="libs/bootstrap/js/bootstrap.min.js"></script>
    <script src="js/common.js"></script>

</body>
</html>






