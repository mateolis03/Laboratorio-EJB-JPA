<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Student Information</title>
    </head>
    <body>
        <h1>Student Information</h1>
        <form action="./StudentServlet" method="POST">
            <table>
                <tr>
                    <td>Student Id</td>
                    <td><input type="text" name="studentId" value="${student.studentId}" /></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" name="firstname" value="${student.firstname}" /></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" name="lastname" value="${student.lastname}" /></td>
                </tr>
                <tr>
                    <td>Year Level</td>
                    <td><input type="text" name="yearLevel" value="${student.yearLevel}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Year Level</th>
                <c:forEach items="${allStudents}" var="stud">
                <tr>
                    <td>${stud.studentId}</td>
                    <td>${stud.firstname}</td>
                    <td>${stud.lastname}</td>
                    <td>${stud.yearLevel}</td>
                </tr>
            </c:forEach> 
        </table>
            <h1>Curso Information</h1>
        <form action="./CurseServlet" method="POST">
            <table>
                <tr>
                    <td>Id Curso</td>
                    <td><input type="text" name="codigoCurso" value="${curso.codigoCurso}" /></td>
                </tr>
                <tr>
                    <td>Nombre Curso</td>
                    <td><input type="text" name="nombreCurso" value="${curso.nombreCurso}" /></td>
                </tr>
                <tr>
                    <td>Créditos</td>
                    <td><input type="text" name="creditos" value="${curse.creditos}" /></td>
                </tr>
                <tr>
                    <td>Semestre</td>
                    <td><input type="text" name="semestre" value="${curse.semestre}" /></td>
                </tr>
                 <tr>
                    <td>Número de Estudiantes</td>
                    <td><input type="text" name="numeroEstudiantes" value="${curse.numeroEstudiantes}" /></td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" name="action" value="Add" />
                        <input type="submit" name="action" value="Edit" />
                        <input type="submit" name="action" value="Delete" />
                        <input type="submit" name="action" value="Search" />
                    </td>
                </tr>
            </table>
        </form>
        <br>
        <table border="1">
            <th>ID</th>
            <th>Nombre Curso</th>
            <th>Créditos</th>
            <th>Semestre</th>
            <th>Número estudiantes</th>
                <c:forEach items="${allCursos}" var="curse">
                <tr>
                    <td>${curse.codigoCurso}</td>
                    <td>${curse.nombreCurso}</td>
                    <td>${curse.creditos}</td>
                    <td>${curse.semestre}</td>
                    <td>${curse.numeroEstudiantes}</td>
                </tr>
            </c:forEach> 
        </table>
    </body>
</html>