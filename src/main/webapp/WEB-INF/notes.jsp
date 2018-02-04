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
        <a class="nav-item nav-link active" href="#">Home</a>
        <a class="nav-item nav-link" href="#">Routes</a>
        <a class="nav-item nav-link" id = "notes" href="#">Notes</a>
        <a class="nav-item nav-link" href="#">Gallery</a>
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


    <button id="load_data">Load data</button>
    <div id="insert_div"></div>

<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/tether.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/note.js"></script>


</body>
</html>