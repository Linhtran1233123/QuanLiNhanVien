<%--
  Created by IntelliJ IDEA.
  User: linh
  Date: 2/16/2023
  Time: 10:58 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Title</title>
</head>
<style>
    td.Name:hover {
        background-color: burlywood;
    }
</style>
<body>
<table>
    <tr>
        <th>Index</th>
        <th>Name</th>
    </tr>
    <c:forEach items="${requestScope.employees}" var="e" varStatus="s">
    <tr>
        <td>${s.index+1}</td>
        <td class="Name" id="${e.id}" onmouseover="getValue('${e.id}')">${e.name}</td>
    </tr>
    </c:forEach>
</table>
<form action="/create" method="post">
<button id="createButton" type="button" onclick="showCreateForm()">Create</button>
<div  id="createForm" style="display: none">
    <label for="name" >Input name of new employee</label>
    <input id="name" value="" name="name" type="text" onchange="changeType()">
</div>
</form>
<br>
<form id="deleteAction" action="/delete" method="post">
    <button id="deleteButton" type="button" onclick="showDeleteForm()">Delete</button>
    <div  id="deleteForm" style="display: none"><label for="deleteName" > name of delete employee</label>
        <input id="deleteName" type="text" >
    </div>
</form>
<br>
<form id="updateAction" action="/update" method="post">
    <button id="updateButton" type="button" onclick="showUpdateForm()">Update</button>
    <div  id="updateForm" style="display: none"><label for="updateName" > name of update employee</label>
        <input id="updateName" type="text" name="name" oninput="changeTypeUpdate()">
    </div>
</form>
<script>
    function showCreateForm(){
        document.getElementById("createForm").style.display="block";
    }
    function changeType(){
        if (document.getElementById("name").value!=="") {
            document.getElementById("createButton").type = "submit";
        } else{
            document.getElementById("createButton").type = "button";
        }
    }
    function changeTypeUpdate(){
        if (document.getElementById("updateName").value!=="") {
            document.getElementById("updateButton").type = "submit";
        } else{
            document.getElementById("updateButton").type = "button";
        }
    }
    function getValue(a){
        getDeleteValue(a)
        getUpdateValue(a)
    }
    function showDeleteForm(){
        document.getElementById("deleteForm").style.display="block";
    }
    function getDeleteValue(a){
        if (document.getElementById("deleteForm").style.display==="block"){
        document.getElementById("deleteButton").type = "submit";
        document.getElementById("deleteName").value =document.getElementById(a).innerHTML;
        document.getElementById("deleteAction").action="/delete"+"?id="+a;
        }
    }
    function showUpdateForm(){
        document.getElementById("updateForm").style.display="block";
    }
    function getUpdateValue(a){
        if (document.getElementById("updateForm").style.display==="block"){
            document.getElementById("updateName").focus()
            document.getElementById("updateName").value =document.getElementById(a).innerHTML;
            document.getElementById("updateAction").action="/update"+"?id="+a;
        }
    }
</script>
</body>
</html>
