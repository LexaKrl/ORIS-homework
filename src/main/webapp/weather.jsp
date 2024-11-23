<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather</title>
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>

<script>
    $(document).on("click", "#ajax-button", function() {
            console.log("Get temperature")

            $.get("/get-weather?city=" + $('#city').val(), function (response){
                $("#weatherData-response").text(response)
            })
        }
    )
</script>

<body>

<h1>Weather in your city</h1>

<form>
    Choose your city: <input id="city" name="city" type="text">
    <br>
    <input type="button" id="ajax-button" value="Update data">
</form>

<div>
    <h2>Weather Data:</h2>

    <div id="weatherData-response">

    </div>

    <%--<pre>
            ${weatherData != null ? weatherData : "Enter a city to view weather information."}
        </pre>--%>
</div>

</body>
</html>