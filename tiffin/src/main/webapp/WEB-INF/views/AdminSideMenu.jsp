<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

  <!-- Main Sidebar Container -->
  <aside class="main-sidebar sidebar-dark-primary elevation-4">
    <!-- Brand Logo -->
    <a href="index3.html" class="brand-link">
      <img src="resources/dist/img/AdminLTELogo.png" alt="AdminLTE Logo" class="brand-image img-circle elevation-3" style="opacity: .8">
      <span class="brand-text font-weight-light">Praharsh Dave</span>
    </a>

    <!-- Sidebar -->
    <div class="sidebar os-host os-theme-light os-host-resize-disabled os-host-scrollbar-horizontal-hidden os-host-transition os-host-scrollbar-vertical-hidden"><div class="os-resize-observer-host observed"><div class="os-resize-observer" style="left: 0px; right: auto;"></div></div><div class="os-size-auto-observer observed" style="height: calc(100% + 1px); float: left;"><div class="os-resize-observer"></div></div><div class="os-content-glue" style="margin: 0px -8px;"></div><div class="os-padding"><div class="os-viewport os-viewport-native-scrollbars-invisible" style=""><div class="os-content" style="padding: 0px 8px; height: 100%; width: 100%;">
      <!-- Sidebar user panel (optional) -->
      

      <!-- Sidebar Menu -->
      <nav class="mt-2">
        <ul class="nav nav-pills nav-sidebar flex-column" data-widget="treeview" role="menu" data-accordion="false">
          <!-- Add icons to the links using the .nav-icon class
               with font-awesome or any other icon font library -->
          
          <li class="nav-item">
            <a href="newrole" class="nav-link">
              <i class="nav-icon fas fa-th"></i>
              <p>
                Add Role
              </p>
            </a>
          </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Role
                <i class="fas fa-angle-left right"></i>
               </p>
            </a>
            <ul class="nav nav-treeview" style="display: none;">
              <li class="nav-item">
                <a href="newrole" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Role</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listrole" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List Role</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Category
                <i class="fas fa-angle-left right"></i>
               </p>
            </a>
            <ul class="nav nav-treeview" style="display: none;">
              <li class="nav-item">
                <a href="newcategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Category</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listcategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List Category</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Subcategory
                <i class="fas fa-angle-left right"></i>
               </p>
            </a>
            <ul class="nav nav-treeview" style="display: none;">
              <li class="nav-item">
                <a href="newsubcategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Subcategory</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listsubcategory" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>List Subcategory</p>
                </a>
              </li>
            </ul>
          </li>
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Dish
                <i class="fas fa-angle-left right"></i>
               </p>
            </a>
            <ul class="nav nav-treeview" style="display: none;">
              <li class="nav-item">
                <a href="newdish" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Dish</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listdish" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Dish List</p>
                </a>
              </li>
            </ul>
          </li>
          
          
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Order
                <i class="fas fa-angle-left right"></i>
               </p>
            </a>
          
            <ul class="nav nav-treeview" style="display: none;">
              <li class="nav-item">
                <a href="neworder" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Add Order</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listorder" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Order List</p>
                </a>
              </li>
            </ul>
          </li>
          
          
          
          
          
          
          <li class="nav-item has-treeview">
            <a href="#" class="nav-link">
              <i class="nav-icon fas fa-copy"></i>
              <p>
                Reports
                <i class="fas fa-angle-left right"></i>
               </p>
            </a>
          
            <ul class="nav nav-treeview" style="display: none;">
              <li class="nav-item">
                <a href="neworder" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Past Order</p>
                </a>
              </li>
              <li class="nav-item">
                <a href="listorder" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Orders</p>
                </a>
              </li>
            
            <li class="nav-item">
                <a href="listtiffins" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Tifins</p>
                </a>
              </li>
              
              
              <li class="nav-item">
                <a href="listorder" class="nav-link">
                  <i class="far fa-circle nav-icon"></i>
                  <p>Users</p>
                </a>
              </li>
              
              
            </ul>
          </li>
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          
          <li class="nav-item">
            <a href="#" class="nav-link">
              <i class="nav-icon far fa-circle text-info"></i>
              <p>Informational</p>
            </a>
          </li>
        </ul>
      </nav>
      <!-- /.sidebar-menu -->
    </div></div></div><div class="os-scrollbar os-scrollbar-horizontal os-scrollbar-unusable os-scrollbar-auto-hidden"><div class="os-scrollbar-track"><div class="os-scrollbar-handle" style="width: 100%; transform: translate(0px, 0px);"></div></div></div><div class="os-scrollbar os-scrollbar-vertical os-scrollbar-unusable os-scrollbar-auto-hidden"><div class="os-scrollbar-track"><div class="os-scrollbar-handle" style="height: 100%; transform: translate(0px, 0px);"></div></div></div><div class="os-scrollbar-corner"></div></div>
    <!-- /.sidebar -->
  </aside>


</body>
</html>