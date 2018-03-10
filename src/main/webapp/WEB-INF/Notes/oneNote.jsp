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
    <style>
        img {
            padding: 4px;
            background-color: #fff;
            border: 1px solid #ddd;
            border-radius: 4px;
        }

        img:hover {
            opacity: 0.6;
            filter: alpha(opacity=60);
        }
    </style>

    <title>Travel Places</title>
    <link rel="icon" href="resources/images/3.png" type="image/x-icon">
</head>
<body style="background-image":"#FFF5EE",
            "background-repeat":"no-repeat",
            "background-size":"cover">

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


<div id="insert_div">
    <div class="container center-block" id="div">
        <div class="divNotes mb-2">
            <input type="hidden" class="idNote" name="idNote" value="<%= request.getParameter("idNote") %>"/>
            
        </div>

        <!-- <div class="row gallery">

        </div> -->

        <!-- <div class="clearfix mosaicflow gallery"> 
        
        </div> -->

        <div class="container gallery">
            <div id="subGallery" class="grid">
            </div>
        </div>

        <!-- <p>Dynamic page</p>
        <p>Time <%= new java.util.Date() %></p>
        <p>JSP Scriptlets <% for(int i = 0; i<6; i++){out.println("<br/> Number: " + i);}%></p>
        <p>Value from request: <%= request.getHeader("User-Agent") %></p>
        <p>Value from servlet: <%= request.getAttribute("name") %></p> -->
    </div>
</div>

<!-- <div id="landon" class="modal fade" tabindex="-1">
    <div class="modal-dialog">
        <div class="modal-header">
            <button type="button" class="close glyphicon glyphicon-remove" 
            data-dismiss="modal"></button>
            <h3>Dahlia Landon</h3>
        </div>
        <div>
            <p>
                <img src="" alt="Dahlia Landon." class="img-responsive pull-left">
                Text Text Text Text Text Text Text Text Text Text Text Text
            </p>
        </div>
        <div class="modal-footer">
            <button class="btn btn-primary" data-dismiss="modal">Close</button>
        </div>
    </div>
</div> -->

<!-- <div class="card-deck">
    <div class="card text-white">
        <div class="card-body">
            <img
        </div>
    </div>
</div> -->

<script src="resources/js/jquery-3.3.1.min.js"></script>
<!-- <script src="resources/js/jmosaicflow/jquery.mosaicflow.min.js"></script>
<script type="text/javascript" src="resources/js/jfancybox/fancybox/jquery.fancybox.pack.js"></script> -->
<script src="resources/js/tether.min.js"></script>

<!-- https://github.com/FezVrasta/popper.js#installation -->
<!-- <script src="https://unpkg.com/popper.js/dist/umd/popper.min.js"></script> -->
<script src="resources/js/bootstrap.min.js"></script>

<!-- http://fancyapps.com/fancybox/3/ -->
<script src="resources/js/fancybox-master/dist/jquery.fancybox.min.js"></script>

<!-- http://hongkhanh.github.io/gridify/ -->
<script src="resources/js/jgridify/jquery/gridify.js"></script>
<script src="resources/js/loadOneNote.js"></script>
<!-- <script src="resources/js/gallery.js"></script> -->

<!-- <script>
    $("document").ready(function loadNote() {
        $(function() {
            var options = {
                srcNode: 'img',             // grid items
                margin: '15px',             // margin in pixel
                width: '240px',             // grid item width in pixel
                max_width: '',              // dynamic gird item width
                resizable: true,            // re-layout if window resize
                transition: 'all 0.5s ease' // support transition for CSS3
            };
            $('.grid').gridify(options);
        });
    })
        </script> -->
</body>
</html>