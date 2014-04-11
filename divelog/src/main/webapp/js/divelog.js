$(function() {

    $(".dropdown-menu li a").click(function() {

        $("#spotname").text($(this).text());
        $("#spotname").val($(this).text());

    });

});


