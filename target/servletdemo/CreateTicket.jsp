<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Create Ticket</title>
</head>
<body>

    <h2>Fill in the details</h2>

    <form action="./CreateTicket" method="post">
        <table>
            <tr>
                <td>Title:</td>
                <td><input type="text" name="title" maxlength="30" size="25" /></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><input type="text" name="description" maxlength="40" size="35" /></td>
            </tr>
            <tr>
                <td>Customer Id:</td>
                <td><input type="text" name="customer_id" maxlength="40" size="35" /></td>
            </tr>
            <tr />
        </table>
        <br /> <input type="submit" value="Create Ticket" />

    </form>
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />


</body>

</html>