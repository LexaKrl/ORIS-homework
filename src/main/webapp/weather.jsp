<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Weather</title>
</head>
<body>

<h1>Weather in your city</h1>

<form method="get" action="/weather">

    Choose your city: <input name="city" type="text">
    <br>
    <input type="submit">
</form>

<div>
    <h2>Weather Data:</h2>
    <pre>
            ${weatherData != null ? weatherData : "Enter a city to view weather information."}
        </pre>
</div>

</body>
</html>