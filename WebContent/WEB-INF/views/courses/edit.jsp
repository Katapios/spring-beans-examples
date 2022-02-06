<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Курс</title>
    <style>
        form fieldset {
            width : 40%;
        }
        form fieldset label {
            display : block;
            /*width : 50%;
            float :left;*/
        }
        form fieldset input, form fieldset textarea {
            width : 100%;
        }
    </style>
    <s:authorize access="isAnonymous()">
        <script>
            const disableForm = true;
            window.addEventListener("load", function () {
                const inputs = document.querySelectorAll("form fieldset input, form fieldset textarea")
                // for (let i = 0; i < inputs.length; i++){
                //     inputs[i].disabled = true
                // }
                Object.keys(inputs).forEach(key => inputs[key].disabled = true)
            });
        </script>
    </s:authorize>
</head>
<body>
<h1>Курс</h1>
<form method="POST">
    <fieldset>
        <div>
            <label>Название: </label>
            <input  type="text" name="title" value="${course.title}">
        </div>
        <div>
            <label>Длительность: </label>
            <input  type="number" name="length" value="${course.length}">
        </div>
        <div>
            <label>Описание: </label>
            <textarea name="description" rows="7">${course.description}</textarea>
        </div>
        <div>
            <input type="submit" value="Сохранить">
        </div>
    </fieldset>

</form>

</body>
</html>