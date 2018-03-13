$("document").ready(function() {
  $.ajax("showAllPhotosServlet",
    {
      success: showAllPhotos,
      type: "GET",
      dataType: "text",
    })
});

function createGrid() {
  $(".subGallery").css("width","100%");
  var options = {
      srcNode: 'img',             // grid items
      margin: '15px',             // margin in pixel
      width: '240px',             // grid item width in pixel
      max_width: '',              // dynamic gird item width
      resizable: true,            // re-layout if window resize
      transition: 'all 0.5s ease' // support transition for CSS3
  };
  $('.grid').gridify(options);
}

function showAllPhotos(data) {
  var gallery = $("#subGallery");
  console.log(data);
  data = JSON.parse(data);
  data.forEach(function (item, i, data) {
    gallery.append("<a data-fancybox=\"gallery\" href=\"" + item.url + "\"><img class=\"img-fluid\" src=\"" + item.url + "\" /></a>");
  });
  createGrid();
}