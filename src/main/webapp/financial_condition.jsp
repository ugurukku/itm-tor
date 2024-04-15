<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ugurukku.itmtor.model.entity.custom.RawFinancialConditionData" %>
<html lang="az">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Maliyyə vəziyyəti</title>
    <style>

        * {
            font-family: arial, sans-serif;
        }

        h1 {
            text-align: center;
        }

        table {
            font-family: arial, sans-serif;
            border-collapse: collapse;
            width: 50%;
        }

        td,
        th {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }

        .container {
            display: flex;
            justify-content: center;
        }
    </style>
</head>

<body>
<h1>Maliyyə vəziyyəti</h1>

<div class="container">
    <table>
        <thead>
        <tr>
            <th>
                Göstəricilərin adı
            </th>
            <th>
                Hesabat ilinin əvvəlinə
            </th>
            <th>
                Hesabat ilinin sonuna
            </th>
        </tr>
        </thead>
        <tbody>
        <%
            for (RawFinancialConditionData row : (List<RawFinancialConditionData>) request.getAttribute("rows")) {
        %>
        <tr>

            <%
                if (row.getKsetir().equals("0")) {
            %>
            <td colspan="6">
                <b>
                    <%=row.getAd()%>
                </b>
            </td>
            <%
            } else {
            %>
            <td>
                <%=row.getAd()%>
            </td>
            <td>
                <%=row.getD1()%>
            </td>
            <td>
                <%=row.getD2()%>
            </td>
            <%
                }
            %>
        </tr>

        <%
            }
        %>

        </tbody>
    </table>
</div>

</body>

</html>