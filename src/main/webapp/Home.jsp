<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>

    <h2 align="center">Welcome!!</h2>
    <br />
    <table align="center">

        <tr>
            <td>To insert your details into the Database:</td>
            <td><input type="button" value="Insert data"
                onclick="window.location.href='CreateCustomer.jsp'" /></td>
        </tr>
        <tr>
            <td>To delete your details from the Database:</td>
            <td><input type="button" value="Delete data"
                onclick="window.location.href='DeleteCustomer.jsp'" /></td>
        </tr>
        <tr>
            <td>View all customers in database:</td>
            <td><input type="button" value="View data"
                onclick="window.location.href='ViewAllCustomer'" /></td>
        </tr>
        <tr>
            <td>To view your details from the Database:</td>
            <td><input type="button" value="Select data"
                onclick="window.location.href='ViewCustomer.jsp'" /></td>
        </tr>
    </table>

</body>


</html>