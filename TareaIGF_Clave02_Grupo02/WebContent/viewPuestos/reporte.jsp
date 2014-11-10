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
Context initContext = new InitialContext();
Context envContext = (Context)initContext.lookup("java:/comp/env");
DataSource ds = (DataSource)envContext.lookup("jdbc/MySQLDataSource");
Connection conn = ds.getConnection();

String filejasper = "puestos.jasper";
String JasperFilesSource = "";

//Cargamos la definicion del reporte *.jasper
File reportFile = new File(application.getRealPath("puestos.jasper"));

//cargamos parametros del reporte (si tiene).
Map parametros = new HashMap();

//Generar XLS.
//Preparacion del reporte (en esta etapa se inserta el valor del query en el reporte).

JasperPrint jasperPrint=JasperFillManager.fillReport(reportFile.getPath(), parametros, conn);

//Nombre archivo resultado.
String xlsFilesSource = "/reportes/puestos.xls";

//Creacion del XLS
JRXlsExporter exporter = new JRXlsExporter();
exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
exporter.setParameter(JRExporterParameter.OUTPUT_FILE_NAME,application.getRealPath(xlsFilesSource));
exporter.setParameter(JRXlsExporterParameter.IS_ONE_PAGE_PER_SHEET, Boolean.TRUE);
exporter.exportReport();

//En este punto ya esta Creado el XLS

//Ahora lo Voy a Leer Y A forzar al Navegador Muestre Dialogo Para descargar el archivo
//Funciona En IE y Firefox

//Leer el archivo.
File f = new File (application.getRealPath(xlsFilesSource));

//Obtener el Nombre del archivo.
String name = f.getName().substring(f.getName().lastIndexOf("/") + 1,f.getName().length());

//Configurar cabecera y nombre de archivo a desplegar en DialogBox.
response.setHeader("Content-Disposition", "attachment; filename=" + "" + name + "" );

InputStream in = new FileInputStream(f);
ServletOutputStream outs = response.getOutputStream();

int bit = 256;
int i = 0;

while ((bit) >= 0) {
bit = in.read();
outs.write(bit);
}

outs.flush();
outs.close();
in.close();
%>