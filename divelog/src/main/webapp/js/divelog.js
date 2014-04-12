$(function() {

    $(".dropdown-menu li a").click(function() {

        $("#spotSelect").text($(this).text());
        $("#spotSelect").val($(this).text());

    });

});


