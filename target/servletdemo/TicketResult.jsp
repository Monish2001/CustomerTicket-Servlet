<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Ticket Details - Result</title>
</head>
<body>

    <h2>Ticket Details</h2>

    <form>
        <input type="hidden" name="id"
            value="<%=request.getParameter("id")%>">

        <table>
            <tr>
                <td>ID:</td>
                <td><%=request.getParameter("id")%></td>
            </tr>
            <tr>
                <td>Title:</td>
                <td><%=request.getParameter("title")%></td>
            </tr>
            <tr>
                <td>Description:</td>
                <td><%=request.getParameter("description")%></td>
            </tr>
            <tr>
                <td>Status:</td>
                <td><%=request.getParameter("status")%></td>
            </tr>
            <tr>
                <td>Customer Id:</td>
                <td><%=request.getParameter("customer_id")%></td>
            </tr>
            <tr />
        </table>
        <br />
    </form>
    <br />
    <input type="button" value="Update Ticket" onclick="update()" />
    <br />
    <input type="button" value="Return to Home"
        onclick="window.location.href='Home.jsp'" />

</body>

<script language="javascript" type="text/javascript">
    function update() {
        var id = document.forms[0].elements['id'].value;
        window.location.href = "UpdateTicket.jsp?id=" + id;
    }
</script>
</html>