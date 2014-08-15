<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>

        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css">

        <!-- Optional theme -->
        <link rel="stylesheet" href="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

        <!-- Latest compiled and minified JavaScript -->
        <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
        <script src="//code.jquery.com/jquery-migrate-1.2.1.min.js"></script>
        <script src="//maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>


    </head>
    <body>
        <h1>Hello World!</h1>

        <script>

            $.getJSON("http://localhost:8081/ProyectoJava3/servicios/categoria", function(result) {
                $.each(result, function(i, desc) {
                    $("div").append("<li>" + desc.nombre + "</li> ");
                });
                $.ajax({
                    url: "http://localhost:8081/ProyectoJava3/servicios/categoria/refrescos",
                    method: 'GET',
                    succuess: function(mensaje) {
                        alert(mensaje);
                    },
                    failure: function() {
                        alert("algo malo sucedio");
                    }
                });

            });


        </script>

    </body>
</html>
