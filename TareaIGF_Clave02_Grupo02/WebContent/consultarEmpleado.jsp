<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="sv.edu.ues.igf115.clave02.negocio.*" %>
<%@ page import="sv.edu.ues.igf115.clave02.dominio.*" %>
<%@ page import="java.util.*" %>
<%@ page import="java.math.BigDecimal" %> 
<%@ page import="java.text.SimpleDateFormat" %>

<%

String id = request.getParameter("id") ;
      

	
      CtrlEmpleado ctrlEmpleado = new CtrlEmpleado() ;
      Empleado empleado = ctrlEmpleado.consultarEmpleado(id);
      
      boolean exito=false;
      
      if(empleado!=null)
    	  exito = true;
      
      String mensaje ;
      if (exito)
    	  
      mensaje = "Datos del empleado"+
      " <br> id empleado: "+empleado.getId()+
      " <br> nit: "+empleado.getNit()+
      " <br> dui: "+empleado.getDui()+
      " <br> nombres: "+empleado.getNombres()+
      " <br> apellido paterno: "+empleado.getApellido_paterno()+
      " <br> apellido materno: "+empleado.getApellido_materno()+
      " <br> fecha de nacimiento: "+empleado.getFecha_nacimiento()+
      " <br> fecha de ingreso: "+empleado.getFecha_ingreso()+
      " <br> sueldo: "+empleado.getSueldo()+
      " <br> e_mail: "+empleado.getE_mail()+
      " <br> telefono: "+empleado.getTelefono()+
      " <br> activo: "+empleado.getActivo()+
      " <br> id de puesto: "+empleado.getId_puesto()+
      " <br> id de genero: "+empleado.getId_genero()+
      " <br> id de oficina: "+empleado.getId_oficina()+
      " <br> id de jefe: "+empleado.getId_jefe();
      
      else
    	  mensaje = "El id de empleado no existe. intente de nuevo.";
 %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consultar empleado</title>
</head>
<body>
<%=mensaje %>
</body>
</html>