<%--
  Created by IntelliJ IDEA.
  User: MSI GTX
  Date: 15/12/2023
  Time: 8:29 SA
  To change this template use File | Settings | File Templates.
--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
    <div class="container">
    <div class="row">
        <div class="col-md-8 justify-content-center mt-4 mx-auto">
            <form action="./upload" method="post" enctype="multipart/form-data">
                <h3 class="text-center text-primary">Upload</h3>
                <!-- Email input -->
                <div class="form-outline mb-4">
                    <input type="file" name="up" id="uploadFile" class="form-control mb-4">
                </div>
                <!-- Submit button -->
                <button id="btn-login" type="submit" class="btn btn-primary btn-block mb-4 w-100">Upload</button>
            </form>
        </div>
    </div>
</div>
</body>
</html>
