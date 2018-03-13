<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/js/fancybox-master/dist/jquery.fancybox.min.css">
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

    <form class="form-inline">
        <div class="input-group">
            <label class="form-control-label sr-only" for="search">Search</label>
            <input type="text" id="search" class="form-control" placeholder="Search for...">
            <span class="input-group-btn">
                <button class="btn btn-info">Go</button>
            </span>
        </div>
    </form>
</nav>

<div class="container">
    <h2 class="mt-5">Gallery</h2>
    <div class="container gallery">
        <div id="subGallery" class="grid"></div>
    </div>
</div>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/tether.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<!-- http://fancyapps.com/fancybox/3/ -->
<script src="resources/js/fancybox-master/dist/jquery.fancybox.min.js"></script>
<!-- http://hongkhanh.github.io/gridify/ -->
<script src="resources/js/jgridify/jquery/gridify.js"></script>
<script src="resources/js/gallery.js"></script>


</body>
</html>