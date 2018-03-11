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

<header class="jumbotron jumbotron-fluid mb-0 img-fluid" style="background-image: url(resources/images/logo1_4.png); background-repeat: no-repeat; background-size: cover;">
   <div class="container container-fluid">
       <div class="row mb-4">
           <div class="col-md-7 vcenter display-2 font-weight-bold text-white">Travel Places</div>
       </div>
       <p class="lead text-white">Follow the assigned route on the way to your goal</p>
   </div>
</header>

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

<div class="container" >
    <h2 class="mt-5">Routes</h2>
    <div id="insert_div" class="row">
        <div class="col-sm-4" >
            <button class="btn m-2 btn-primary" id="add">Add new</button>
            <div class="anyClass" id="allRoutes" style="height: auto; overflow-y: scroll"></div>
        </div>
        <div class="col-sm-4" id="oneRoute">
            <div id="divNotes" class="mb-2">
                 <!-- <input type="hidden" class="idRoute" name="idRoute" value="<%= request.getParameter("idRoute") %>"/> -->
            </div>
        </div>
    </div>
</div>

<div>

</div>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="http://malsup.github.com/jquery.form.js"></script>
<script src="resources/js/tether.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/loadRoutes.js"></script>
<!-- <script src="resources/js/setNotesContent.js"></script> -->
<script src="resources/js/addNoteClick.js"></script>
<script src="resources/js/oneRouteShow.js"></script>


</body>
</html>