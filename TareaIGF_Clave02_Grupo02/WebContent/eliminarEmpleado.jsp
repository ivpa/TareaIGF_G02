<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sv.edu.ues.igf115.clave02.negocio.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %> 
<%@ page import="java.text.SimpleDateFormat" %>

<%

String id = request.getParameter("id") ;
      

	
      CtrlEmpleado ctrlEmpleado = new CtrlEmpleado() ;
      boolean exito = ctrlEmpleado.eliminarEmpleado(id);
      
      String mensaje ;
      if (exito)
      	 mensaje = "El Empleado fue eliminado correctamente" ;
      else
    	  mensaje = "El id de empleado no existe. intente de nuevo.";
 %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Eliminar empleado</title>
</head>
<body>
<%=mensaje %>
</body>
</html>