<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Test form</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
        label {
            font-size: 3vmin;
        }
        .my_radio label{
            display: inline;
            cursor: pointer;
            margin-left: 5px;
            font-size: 2.5vmin;
            vertical-align: middle;
        }

    </style>
</head>
<body>
<div class="container" style="background-color: #f8f1ec">
    <div class="row">
        <div>
            <form:form role="form" action="check" method="post" modelAttribute="test">
                <table class="table table-bordered table-striped">
                    <tr>
                        <td>
                            <div><form:label path="answer_1">${test.question_1}</form:label></div>
                            <div class="my_radio col-md-3 col-xs-6"><form:radiobutton path="answer_1" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio col-md-3 col-xs-6"><form:radiobutton path="answer_1" value="2" label="answer" /></div>
                            <div class="my_radio col-md-3 col-xs-6"><form:radiobutton path="answer_1" value="3" label="answer" /></div>
                            <div class="my_radio col-md-3 col-xs-6"><form:radiobutton path="answer_1" value="4" label="answer" /></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div><form:label path="answer_2">${test.question_2}</form:label></div>
                            <div class="my_radio col-md-3 col-xs-6"><form:radiobutton path="answer_2" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio col-md-3 col-xs-6"><form:radiobutton path="answer_2" value="2" label="answer"/></div>
                            <div class="my_radio col-md-3 col-xs-6"><form:radiobutton path="answer_2" value="3" label="answer"/></div>
                            <div class="my_radio col-md-3 col-xs-6"><form:radiobutton path="answer_2" value="4" label="answer"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div><form:label path="answer_3">${test.question_3}</form:label></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_3" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_3" value="2" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_3" value="3" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_3" value="4" label="answer"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div><form:label path="answer_4">${test.question_4}</form:label></div>
                            <div class="my_radio col-md-3 col-xs-12"><form:radiobutton path="answer_4" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio col-md-3 col-xs-12"><form:radiobutton path="answer_4" value="2" label="answer"/></div>
                            <div class="my_radio col-md-3 col-xs-12"><form:radiobutton path="answer_4" value="3" label="answer"/></div>
                            <div class="my_radio col-md-3 col-xs-12"><form:radiobutton path="answer_4" value="4" label="answer"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div><form:label path="answer_5">${test.question_5}</form:label></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_5" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_5" value="2" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_5" value="3" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_5" value="4" label="answer"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div><form:label path="answer_6">${test.question_6}</form:label></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_6" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_6" value="2" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_6" value="3" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_6" value="4" label="answer"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div><form:label path="answer_7">${test.question_7}</form:label></div>
                            <div class="my_radio" style="float: left; padding-right: 10px; padding-left: 10px"><form:radiobutton path="answer_7" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio" style="float: left; padding-right: 10px; padding-left: 10px"><form:radiobutton path="answer_7" value="2" label="answer"/></div>
                            <div class="my_radio" style="float: left; padding-right: 10px; padding-left: 10px"><form:radiobutton path="answer_7" value="3" label="answer"/></div>
                            <div class="my_radio" style="float: left; padding-right: 10px; padding-left: 10px"><form:radiobutton path="answer_7" value="4" label="answer"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div><form:label path="answer_8">${test.question_8}</form:label></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_8" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_8" value="2" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_8" value="3" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_8" value="4" label="answer"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div><form:label path="answer_9">${test.question_9}</form:label></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_9" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_9" value="2" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_9" value="3" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_9" value="4" label="answer"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div><form:label path="answer_10">${test.question_10}</form:label></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_10" value="1" label="answer" checked="checked"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_10" value="2" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_10" value="3" label="answer"/></div>
                            <div class="my_radio col-md-6 col-xs-12"><form:radiobutton path="answer_10" value="4" label="answer"/></div>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <button type="submit" class="btn btn-success btn-block">Готово!</button>
                        </td>
                    </tr>
                </table>
            </form:form>
        </div>
    </div>
</div>
</body>
</html>
