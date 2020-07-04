<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Main DR page</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet"
          href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>

    <script	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <style>
      body {
        background-color: #f8f1ec
      }
      div.text-container {
        margin-top: 15px;
      }
      p {
        margin: 0 0 5px;
      }
      img {
        border-radius: 10px;
        box-shadow: 2px 2px 3px gray;
      }
    </style>
  </head>
  <body>
  <div class="container">
    <h2 class="text-center">С Днем Рождения, милашик!</h2>
    <img src="https://sun9-53.userapi.com/qzmDIRZBpZLHZj9z-NsMEp7Quyud6nquZ5UQiw/6sL_-R3gWS4.jpg" class="img-responsive">
    <div class="text-container">
      <p class="text-justify">
        Some text with congratulations
      </p>
      <p>
        Теперь давай попробуем узнать, насколько хорошо ты помнишь прошедшие два года наших с тобой отношений:Р
      </p>
    </div>
    <div style="padding-top: 5px">
      <a class="btn btn-success" href="/showForm" role="button">Давай начнем!</a>
    </div>
    <div style="height: 5%"></div>
  </div>
  </body>
</html>
