<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Best-result</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Reference Bootstrap files -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
          integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
            integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
            crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
            integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
            crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
            integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
            crossorigin="anonymous"></script>

    <style>
        body {
            background-color: #f8f1ec
        }
        p {
            margin: 0 0 5px;
        }
        .container-fluid {
            max-width: 80%;
        }
        .carousel-inner {
            max-height: 90%;
        }
        .carousel-inner img {
            transform: translateY(-10%);
            max-height: 100%;
            width: auto;
        }
    </style>
</head>
<body>
<div>
    <div class="container-fluid text-justify" style="padding-bottom: 5px">
        <h4>Отлично справилась!</h4>
        <p>Заслужила высшую похвалу)</p>
        <p>
            Some text with congratulations
        </p>
        <p>
            Если повернешь экран, то сможешь рассмотреть фото лучше, хотя в таком случае они будут немного обрезаны.
        </p>
    </div>
    <div class="container-fluid">
        <div id="mySlider" class="carousel slide" data-ride="carousel" data-interval="3000">
            <div class="carousel-inner">
                <div class="carousel-item active">
                    <img class="d-block w-100" src="url_photo" alt="1 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="2 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="3 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="4 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="5 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="6 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="7 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="8 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="9 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="10 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="11 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="12 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="13 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="14 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="15 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="16 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="17 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="18 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="19 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="20 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="21 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="22 слайд">
                </div>
                <div class="carousel-item">
                    <img class="d-block w-100" src="url_photo" alt="23 слайд">
                </div>
            </div>
            <a class="carousel-control-prev" href="#mySlider" role="button" data-slide="prev">
                <span class="carousel-control-prev-icon" aria-hidden="true"></span>
                <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#mySlider" role="button" data-slide="next">
                <span class="carousel-control-next-icon" aria-hidden="true"></span>
                <span class="sr-only">Next</span>
            </a>
        </div>
    </div>
    <div class="container-fluid text-justify" style="padding-bottom: 5px">
        <p>Если досмотрела фотки, можешь вернуться к боту и написать ему команду "идеально",
            чтобы двигаться дальше.</p>
    </div>
</div>
</body>
</html>
