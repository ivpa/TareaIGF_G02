<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sv.edu.ues.igf115.clave02.negocio.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %> 
<%@ page import="java.text.SimpleDateFormat" %>

<%

String id = request.getParameter("id") ;
String nit = request.getParameter("nit") ;
String dui = request.getParameter("dui") ;
String nombres = request.getParameter("nombres") ;
String apellido_paterno = request.getParameter("apellido_paterno") ;
String apellido_materno = request.getParameter("apellido_materno") ;
String fecha_nacimiento = request.getParameter("fecha_nacimiento") ;
String fecha_ingreso = request.getParameter("fecha_ingreso") ;
BigDecimal sueldo = new BigDecimal(request.getParameter("sueldo"));
String e_mail = request.getParameter("e_mail") ;
String telefono = request.getParameter("telefono") ;
String activo = request.getParameter("activo") ;
Short id_puesto =  new Short(request.getParameter("id_puesto"));
String id_genero = request.getParameter("id_genero") ;
String id_oficina = request.getParameter("id_oficina") ;
String id_jefe = request.getParameter("id_jefe") ;

      
      CtrlEmpleado ctrlEmpleado = new CtrlEmpleado() ;
      boolean exito = ctrlEmpleado.modificarEmpleado(id, nit, dui, nombres, apellido_paterno, apellido_materno, fecha_nacimiento, fecha_ingreso, sueldo, e_mail, telefono, activo, id_puesto, id_genero, id_oficina, id_jefe);
      
      String mensaje ;
      if (exito)
      	 mensaje = "Empleado modificardo" ;
      else
    	  mensaje = "No se puede modificar el empleado porque no existe.";
 %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%=mensaje %>


</body>
</html>