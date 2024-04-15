<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="com.ugurukku.itmtor.model.entity.custom.RawIncomesData" %>
<%@ page import="java.util.List" %>
<html lang="az">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Gəlirlər</title>
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
<h1>A Bölməsi. Gəlirlər</h1>

<div class="container">
    <table>
        <thead>
        <tr>
            <th rowspan="3">
                Göstəricilərin adı
            </th>
            <th rowspan="3">
                Müəssisə üzrə cəmi
            </th>
            <th colspan="4">
                o cümlədən:
            </th>
        </tr>
        <tr>
            <th rowspan="2">
                əsas fəaliyyət növü üzre
            </th>
            <th colspan="3">
                qeyri-əsas fəaliyyət növləri üzrə (fəaliyyət kodu göstərilməklə)
            </th>
        </tr>
        <tr>
            <th>
                kod 3
            </th>
            <th>
                kod 4
            </th>
            <th>
                kod 5
            </th>
        </tr>
        </thead>
        <tbody>
        <%
            for (RawIncomesData row : (List<RawIncomesData>) request.getAttribute("rows")) {
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
            <td>
                <%=row.getD3()%>
            </td>
            <td>
                <%=row.getD4()%>
            </td>
            <td>
                <%=row.getD5()%>
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