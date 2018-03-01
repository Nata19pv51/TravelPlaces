$("document").ready(function () {
    var options = {
        // http://jquery.malsup.com/form/#ajaxForm
        beforeSubmit: preSubmitCallback,  // pre-submit callback
        success: showResponse  // post-submit callback

        // other available options:
        //url:       url         // override for form's 'action' attribute
        //type:      type        // 'get' or 'post', override for form's 'method' attribute
        //dataType:  null        // 'xml', 'script', or 'json' (expected server response type)
        //clearForm: true        // clear all form fields after successful submit
        //resetForm: true        // reset the form after successful submit

        // $.ajax options can be used here too, for example:
        //timeout:   3000
    };

    // bind form using 'ajaxForm'
    $('#upload_form').ajaxForm(options);

    $("#input_box").change(selectImage);
});

// pre-submit callback
function preSubmitCallback(formData, jqForm, options) {
    $("#submit_button").hide();
    return true;
}

// post-submit callback
function showResponse(responseText, statusText, xhr, $form) {
    // for normal html responses, the first argument to the success callback
    // is the XMLHttpRequest object's responseText property

    // if the ajaxForm method was passed an Options Object with the dataType
    // property set to 'xml' then the first argument to the success callback
    // is the XMLHttpRequest object's responseXML property

    // if the ajaxForm method was passed an Options Object with the dataType
    // property set to 'json' then the first argument to the success callback
    // is the json data object returned by the server
    $("#input_box").val("")
    image = '<img src="' + responseText + '"\>';
    $("#images_box").append(image)
}

function selectImage() {
    $("#submit_button").show();
}