<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/css/style.css">


  <title>Travel Places</title>
  <link rel="icon" href="resources/images/3.png" type="image/x-icon">
</head>
<body>

<nav class="navbar navbar-inverse navbar-toggleable-sm" style="background-color: #C71585">
    <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse"
    data-target="#myContent" aria-controls="myContent" aria-expanded="false" aria-label="Toggle Navigation">
      <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="myContent">
      <div class="navbar-nav mr-auto">
        <a class="nav-item nav-link active" href="homePageServlet">Home</a>
        <a class="nav-item nav-link" id="routes" href="loadRoutesServlet">Routes</a>
        <a class="nav-item nav-link" id="notes" href="servletInNotes">Notes</a>
        <a class="nav-item nav-link" href="galleryServlet">Gallery</a>
        <a class="nav-item nav-link" href="#">Map</a>
      </div><!-- navbar-nav -->
  </div><!-- collapse -->

  <div>
    <a class="nav-item nav-link" href="signOutServlet"><img id="signout" src="resources/images/sign-out.png"></a>
  </div>
</nav>

<div class="container">
    <!-- <div>
        <h3>Upload</h3>
        <form id="upload_form" class="upload_box" action="uploadPhotoServlet" method="post" enctype="multipart/form-data">
            <input id="input_box" type="file" name="file" />
            <br />
            <br />
            <input hidden="true" id="submit_button" type="submit" value="Upload Image" />
        </form>
    </div>
    <div id="images_box">

    </div> -->

    <h2 class="mt-5">Notes</h2>
    <div id="insert_div">
        <div class="container center-block" id="contener_div"></div>
    </div>

</div>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="https://developers.google.com/maps/documentation/javascript/examples/markerclusterer/markerclusterer.js"></script>
<script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCjjC7v0SfDZg0dquCEIWzqAn_blHu6I7M"></script>
<script src="resources/js/tether.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<!-- <script src="resources/js/uploadPhoto.js"></script> -->
<script src="resources/js/setNotesContent.js"></script>
<script src="resources/js/initMap.js"></script>
<script src="resources/js/addNoteClick.js"></script>
<script src="resources/js/oneRouteShow.js"></script>
<script src="resources/js/loadNotes.js"></script>


</body>
</html>