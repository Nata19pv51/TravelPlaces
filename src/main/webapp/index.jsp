<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="UTF-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta http-equiv="x-ua-compatible" content="ie=edge">

  <link rel="stylesheet" href="resources/css/bootstrap.min.css">
  <link rel="stylesheet" href="resources/css/style.css">

  <title>Sign in</title>
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

        <a class="nav-item nav-link" href="#">Map</a>
        <div class="dropdown">
            <a class="nav-item nav-link dropdown-toggle" href="#"
              data-toggle="dropdown" id="servicesDropdown"
              aria-haspopup="true" aria-expanded="false"
              >Services</a>
            <div class="dropdown-menu">
                <a class="dropdown-item" href="#" aria-labelledby="servicesDropdown">Grooming</a>
                <a class="dropdown-item" href="#">General Health</a>
                <a class="dropdown-item" href="#">Nutrition</a>
                <a class="dropdown-item" href="#">Pest Control</a>
                <a class="dropdown-item" href="#">Vaccinations</a>
            </div>
        </div>
        <a class="nav-item nav-link" href="#">Staff</a>
        <a class="nav-item nav-link" href="#">Testimonials</a>
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
  <form class="mt-5" method="POST" action="signIn">

      <fieldset class="form-group">
    <!--    <legend>Sign in</legend>-->

        <div class="form-group row ">
          <label class="form-control-label text-md-right col-md-2 col-form-label" for="ownername">Login</label>
          <div class="col-md-10">
              <input class="form-control" type="text" id="login" placeholder="Login">
          </div>
        </div><!-- form-group -->

        <div class="form-group row">
          <label class="form-control-label col-md-2 text-md-right col-form-label" for="owneremail">Password</label>
          <div class="col-md-10">
              <input class="form-control" type="text" id="password" placeholder="Password">
          </div>
        </div><!-- form-group -->

        <div class="form-group row" id="btnSign">
            <div class="offset-md-2 col-md-10">
                <button class="btn btn-primary" type="submit">Sign in</button>
            </div>
        </div>
      </fieldset><!-- fieldset -->
    </form>
</div><!-- content container -->

<script src="resources/js/jquery.slim.min.js"></script>
<script src="resources/js/tether.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script src="resources/js/script.js"></script>


</body>
</html>