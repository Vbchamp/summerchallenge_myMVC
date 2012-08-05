<%-- 
    Document   : index
    Created on : Aug 5, 2012, 1:12:08 PM
    Author     : Vaibhav
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <style>
        table{
            border-style: groove;
            border-width: 5px;
            border-color: greenyellow;
            background-color: bisque;
        }
        td{
            text-align: center;
        }
    </style>
    <body>
    <center>

        <form action="LoginController" method="post">
            <table>
                <tr>
                    <td>User ID:</td>
                    <td>
                        <input type="text" name="userIdTxt">

                    </td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td>
                        <input type="password" name="pwdTxt">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Submit">
                        <input type="reset" value="Reset">
                    </td>
                </tr>
            </table>
        </form>
    </center>
</body>
</html>
