<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="Tymoteusz Borkowski" content="events">

    <title>Going events</title>

    <link href="<spring:url value="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />"
          rel="stylesheet" type="text/css"/>

</head>

<body>
<div class="container">

    <form action="<spring:url value="/444134282584226"/>" method="post">
        <h3>Zapisz koncert Melecha do bazy danych: </h3>
        <input type="submit" value="Zapisz Melecha" class="btn btn-default" name="eBtn"/>
    </form>

    <form action="<spring:url value="/144699732700589"/>" method="post">
        <h3>Zapisz koncert Efdemina do bazy danych: </h3>
        <input type="submit" value="Zapisz Efdemina" class="btn btn-default" name="eBtn"/>
    </form>

    <h4>Zapisano</h4>

</div>

</body>

</html>