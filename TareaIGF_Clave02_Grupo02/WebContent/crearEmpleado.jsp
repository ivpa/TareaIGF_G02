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
String nombres = request.getParameter("codigomunicipio") ;
String apellido_paterno = request.getParameter("apellido_paterno") ;
String apellido_materno = request.getParameter("apellido_materno") ;

SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
String dateInString = request.getParameter("fecha_nacimiento");
Date fecha_nacimiento= new Date();
try {
	fecha_nacimiento = formatter.parse(dateInString);	
}catch(Exception e){	
}

dateInString = request.getParameter("fecha_ingreso");
Date fecha_ingreso= new Date();
try {
	fecha_ingreso = formatter.parse(dateInString);	
}catch(Exception e){
	
}


BigDecimal sueldo =  BigDecimal.valueOf(Double.parseDouble(request.getParameter("sueldo")));
String e_mail = request.getParameter("e_mail") ;
String telefono = request.getParameter("telefono") ;
String activo = request.getParameter("activo") ;
Short id_puesto =  Short.parseShort(request.getParameter("id_puesto")) ;
String id_genero = request.getParameter("id_genero") ;
String id_oficina = request.getParameter("id_oficina") ;
      
      CtrlEmpleado ctrlEmpleado = new CtrlEmpleado() ;
      boolean exito = ctrlEmpleado.crearEmpleado(id, nit, dui, nombres, apellido_paterno, apellido_materno, fecha_nacimiento, fecha_ingreso, sueldo, e_mail, telefono, activo, id_puesto, id_genero, id_oficina);
      
      String mensaje ;
      if (exito)
      	 mensaje = "Empleado creado" ;
      else
    	  mensaje = "ya existe";
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