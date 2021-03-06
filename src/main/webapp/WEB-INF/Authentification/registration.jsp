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
    <nav class="navbar navbar-inverse navbar-toggleable-sm" id="navigate" style="background-color: #C71585">

    </nav>
<div class="container">
  <div class="mt-5" id="registerForm" >

      <fieldset class="form-group">
    <!--    <legend>Sign in</legend>-->

        <div class="form-group row">
          <label class="form-control-label col-md-2 text-md-right col-form-label" for="owneremail">Email</label>
          <div class="col-md-10">
              <input class="form-control" type="text" id="emailReg" name="emailReg" placeholder="Email">
          </div>
        </div><!-- form-group -->

        <div class="form-group row ">
          <label class="form-control-label text-md-right col-md-2 col-form-label" for="ownerlogin">Login</label>
          <div class="col-md-10">
              <input class="form-control" type="text" id="loginReg" name="loginReg" placeholder="Login">
          </div>
        </div><!-- form-group -->
        <div id="otherLogin"></div>
        <div class="form-group row">
          <label class="form-control-label col-md-2 text-md-right col-form-label" for="ownerpassword">Password</label>
          <div class="col-md-10">
              <input class="form-control" type="password" id="passwordReg" name="passwordReg" placeholder="Password">
          </div>
        </div><!-- form-group -->

        <div class="form-group row" id="btnSign">
            <div class="offset-md-2 col-md-10">
                <button class="btn btn-primary" id="register">Registrate</button>
            </div>
        </div>
      </fieldset><!-- fieldset -->
    </div>
</div><!-- content container -->


<script src="resources/js/jquery-3.3.1.min.js"></script>
<script src="resources/js/tether.min.js"></script>
<script src="resources/js/bootstrap.min.js"></script>
<script id="registerScript" src="resources/js/registration.js"></script>


</body>
</html>