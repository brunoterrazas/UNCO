<?php
include_once("../../configuracion.php");
function imprimirMenu()
{
    
$objAbmMenu = new AbmMenu();
$objSesion= new Session();

//Buscamos los menus segun cada rol del usuario si lo tiene asignado
$menus = $objAbmMenu->generarMenus($objSesion);
    
    $menuOriginal = $menus;
 $str="";
    if (count($menus) > 0) {

        foreach ($menus as $objMenu) {
            $idmenu = $objMenu->getIdmenu();
            //verificamos si es un submenu

            $res = $objAbmMenu->esSubMenu($menuOriginal, $idmenu);

            $val['idpadre'] = $idmenu;

            if (!$res) {
                $menusHijos = $objAbmMenu->buscar($val);
                
                
                $str.= "<a href='" . $objMenu->getMedescripcion() . "'>" . $objMenu->getMenombre() . "</a><br>";
                $str. "<ul>";
                //verificamos si es menu padre
                if (count($menusHijos) > 0) {
                    //creamos submenus u objeto menu hijo
                    foreach ($menusHijos as $submenu) {
                        $str.= "<li><a href='" . $submenu->getMedescripcion() . "'>" . $submenu->getMenombre() . "</a></li>";
                    }
                }
                $str.= "</ul>";
            }
            else{
                $str.="";
            }
            
        }
    }
    return $str;
}
echo imprimirMenu();
