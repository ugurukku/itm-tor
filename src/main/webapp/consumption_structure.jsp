<%@ taglib uri='http://java.sun.com/jsp/jstl/core' prefix='c' %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.util.List" %>
<%@ page import="com.ugurukku.itmtor.model.entity.custom.RawConsumptionStructureData" %>
<html lang="az">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Aralıq istehlakın strukturu</title>
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
<h1>Aralıq istehlakın strukturu</h1>

<div class="container">
    <table>
        <thead>
        <tr>
            <th>
                Mülkiyyət forması/fəaliyyət növü
            </th>
            <th colspan="4">
                Aralıq istehlak xərclərinin strukturu
            </th>
        </tr>
        <th rowspan="2">
            Aralıq istehlakın elementlərinin adları:
        </th>
        <th colspan="2">Cəmi</th>
        <th colspan="2">Əsas fəaliyyət üzrə</th>
        </tr>
        <tr>
            <th >Aralıq
                istehlakın
                həcmi,
                manat</th>
            <th >Xüsusi
                çəki, faizlə</th>
            <th >Aralıq
                istehlakın
                həcmi,
                manat</th>
            <th >Xüsusi
                çəki,
                faizlə</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (RawConsumptionStructureData row : (List<RawConsumptionStructureData>) request.getAttribute("rows")) {
                if (row.getKsetir().equals("500")) {
            %>
        <tr style="font-weight: bold">
            <td >
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
        </tr>
            <%
            } else {
            %>
        <tr>
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
        </tr>
            <%
                }
            %>

        <%
            }
        %>

        </tbody>
    </table>
</div>

</body>

</html>