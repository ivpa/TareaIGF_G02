<%@ page import="net.sf.jasperreports.engine.export.*"%>
<%@ page import="net.sf.jasperreports.engine.*"%>
<%@ page import="java.util.*" %>
<%@ page import="java.io.*" %>
<%@ page import="javax.sql.*" %>
<%@ page import="java.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ page import=" net.sf.jasperreports.view.*"%>
<%@ page contentType="application/vnd.ms-excel" language="java" %>

<%
Connection conexion;
Class.forName("com.mysql.jdbc.Driver").newInstance();
conexion = DriverManager.getConnection("jdbc:mysql://localhost:3306/clave2","root","root");

File reporteFile = new File(application.getRealPath("viewOficina/reportes/oficina.jasper"));

Map parameter = new  HashMap();
parameter.put("Nombre_parametro", "Valor_parametro");

byte[] bytes = JasperRunManager.runReportToPdf(reporteFile.getPath(), parameter,conexion);

response.setContentType("application/pdf");
response.setContentLength(bytes.length);
ServletOutputStream outputstream = response.getOutputStream();
outputstream.write(bytes,0,bytes.length);
outputstream.flush();
outputstream.close();


%>