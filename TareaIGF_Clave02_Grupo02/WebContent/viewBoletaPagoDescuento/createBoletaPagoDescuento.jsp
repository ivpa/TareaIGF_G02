<%@page import="sv.edu.ues.igf115.clave02.dominio.BoletaPagoDescuento"%>
<%@page import="sv.edu.ues.igf115.clave02.dao.TipoDescuentoDAO"%>
<%@page import="sv.edu.ues.igf115.clave02.dominio.TipoDescuento"%>
<%@page import="sv.edu.ues.igf115.clave02.negocio.CtrlBoletaPagoDescuento"%>
<%@page import="sv.edu.ues.igf115.clave02.dao.BoletaPagoDAO"%>
<%@page import="sv.edu.ues.igf115.clave02.dominio.BoletaPago"%>

<%@page import="java.math.BigDecimal"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%
    	Integer id = Integer.parseInt(request.getParameter("id"));
    	
    	BoletaPago bp = new BoletaPagoDAO().daBoletaPagoById(new Short(request.getParameter("idbp")));
    	TipoDescuento tpd = new TipoDescuentoDAO().daTipoDescuentoById((request.getParameter("idtd")));
    	BigDecimal monto = new BigDecimal(request.getParameter("descuento"));
    	
    	BoletaPagoDescuento bpd= new BoletaPagoDescuento(id,monto,bp,tpd);
    	String mensaje="";
    	 CtrlBoletaPagoDescuento ctrl = new CtrlBoletaPagoDescuento();
    	 
    	 if(ctrl.crearBoletaPagoDescuento(bpd))
    		 mensaje="El registro fue guardado con exito";
    	 else
    		 mensaje = "Ya existe ese registro";
    %>
<!DOCTYPE html>
<html lang="en">

<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Ingenieria de Software </title>

    <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="../css/sb-admin.css" rel="stylesheet">

    <!-- Morris Charts CSS -->
    <link href="../css/plugins/morris.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="../font-awesome-4.1.0/css/font-awesome.min.css" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

    <div id="wrapper">

        <!-- Navigation -->
        <nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="../index.html">Inicio</a>
            </div>
            <!-- Top Menu Items -->
            <ul class="nav navbar-right top-nav">
               
                               <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown"><i class="fa fa-user"></i> Usuario <b class="caret"></b></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="#"><i class="fa fa-fw fa-user"></i> Profile</a>
                        </li>
                       
                        
                        <li class="divider"></li>
                        <li>
                            <a href="#"><i class="fa fa-fw fa-power-off"></i> Salir</a>
                        </li>
                    </ul>
                </li>
            </ul>
            <!-- Sidebar Menu Items - These collapse to the responsive navigation menu on small screens -->
            <div class="collapse navbar-collapse navbar-ex1-collapse">
                <ul class="nav navbar-nav side-nav">
                    <li class="active">
                        <a href="index.html"><i class="fa fa-fw fa-dashboard"></i> Home</a>
                    </li>
                  
                  
                   
                    <li>
                        <a href="javascript:;" data-toggle="collapse" data-target="#demo"><i class="fa fa-fw fa-arrows-v"></i> Mantenimiento PLanilla <i class="fa fa-fw fa-caret-down"></i></a>
                        <ul id="demo" class="collapse">
                                   <li>
                                <a href="../viewEmpleado/Empleados.html">Empleado</a>
                            </li>
                            <li>
                                <a href="../viewPuestos/Puestos.html">Puesto</a>
                            </li>
                            <li>
                                <a href="../viewBoletaPago/BoletaPago.html">Boleta Pago</a>
                            </li>
                            <li>
                                <a href="../viewOficina/oficinas.html">Oficina</a>
                            </li>
                           
                            <li>
                                <a href="../viewBoletaPagoDescuento/BoletaPagoDescuento.html">Boleta pago descuento</a>
                            </li>
                            <li>
                                <a href="../viewTipoDescuento/TipoDescuento.html">Tipos descuentos</a>
                            </li>
							 <li>
                                <a href="../viewDepartamento/Departamento.html">Departamentos</a>
                            </li>
                             <li>
                                <a href="../viewMunicipio/Municipio.html">Municipio</a>
                            </li>
                    </li>
                   
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </nav>

        <div id="page-wrapper">

            <div class="container-fluid">

                <!-- Page Heading -->
                <div class="row">
                    <div class="col-lg-12">
                        <h1 class="page-header">
                            IGF 2014 <small>Grupo 02</small>
                        </h1>
                        <ol class="breadcrumb">
                            <li class="active">
                                <i class="fa fa-dashboard"></i> Crear Boleta Pago descuento
                            </li>
                        </ol>
                    </div>
                </div>
                <!-- /.row -->

                <div class="row">
                    <div class="col-lg-12">
                    <div class="alert alert-success" role="alert">
						 <%=mensaje %>
					</div>
                       
                    </div>
                </div>
                <!-- /.row -->

              
                
                <!-- /.row -->

               
                <!-- /.row -->

            </div>
            <!-- /.container-fluid -->

        </div>
        <!-- /#page-wrapper -->

    </div>
    <!-- /#wrapper -->

    <!-- jQuery Version 1.11.0 -->
    <script src="js/jquery-1.11.0.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

    <!-- Morris Charts JavaScript -->
    <script src="../js/plugins/morris/raphael.min.js"></script>
    <script src="../js/plugins/morris/morris.min.js"></script>
    <script src="../js/plugins/morris/morris-data.js"></script>

</body>

</html>
