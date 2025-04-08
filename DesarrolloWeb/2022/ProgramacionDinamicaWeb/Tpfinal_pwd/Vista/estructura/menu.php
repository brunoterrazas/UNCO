<?php 

function imprimirMenu($objSesion,$nombre)
{
    
$objAbmMenu = new AbmMenu();

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
                  //verificamos si es menu padre
				if(count($menusHijos) ==0)
                {
					if($objMenu->getMedeshabilitado() ==null)
						{
					if($objMenu->getMenombre()=="Carrito")
					{
						$str.= "<li class='nav-item'><a  class='nav-link active' aria-current='page' href='" . $objMenu->getMedescripcion() . "'>" . $objMenu->getMenombre() . "";
						$str.='<i class="bi bi-cart4"><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-cart4" viewBox="0 0 16 16">
						<path d="M0 2.5A.5.5 0 0 1 .5 2H2a.5.5 0 0 1 .485.379L2.89 4H14.5a.5.5 0 0 1 .485.621l-1.5 6A.5.5 0 0 1 13 11H4a.5.5 0 0 1-.485-.379L1.61 3H.5a.5.5 0 0 1-.5-.5zM3.14 5l.5 2H5V5H3.14zM6 5v2h2V5H6zm3 0v2h2V5H9zm3 0v2h1.36l.5-2H12zm1.11 3H12v2h.61l.5-2zM11 8H9v2h2V8zM8 8H6v2h2V8zM5 8H3.89l.5 2H5V8zm0 5a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0zm9-1a1 1 0 1 0 0 2 1 1 0 0 0 0-2zm-2 1a2 2 0 1 1 4 0 2 2 0 0 1-4 0z"/>
					  </svg></i>';
						$str.="
						</a>
					  </li>";
					}
					else
					$str.= "<li class='nav-item'><a  class='nav-link active' aria-current='page' href='" . $objMenu->getMedescripcion() . "'>" . $objMenu->getMenombre() . "</a></li>";
				}
                }else{  
					//alimentamos el generador de aleatorios
srand (time());
//generamos un número aleatorio
$i = rand(1,1000);
					$str.= '<li class="nav-item dropdown"><a class="nav-link dropdown-toggle active"  id="navbarDropdown'.$i.'" role="button" data-bs-toggle="dropdown" aria-expanded="false" href="' . $objMenu->getMedescripcion() . '">' . $objMenu->getMenombre() . '</a>';
					
					$str.='<ul class="dropdown-menu" aria-labelledby="navbarDropdown'.$i.'">';
					$i++;   
				   //creamos submenus u objeto menu hijo
                 
					foreach ($menusHijos as $submenu) {
						if($submenu->getMedeshabilitado() ==null)
						{
                        $str.= "<li><a class='dropdown-item' href='" . $submenu->getMedescripcion() . "'>" . $submenu->getMenombre() . "</a></li>";
                       }
				}
					$str.= "</ul>";
					$str.= "</li>";
				
					
				}
              
                
                
            }
            else{
                $str.="";
            }
			
			
        }
		$str.='<li class="nav-item bg-dark"><a  class="nav-link active" aria-current="page"   href="javascript:void(0)" onclick="cerrarSesion()">'.$nombre.'<svg xmlns="http://www.w3.org/2000/svg" width="1em" height="1em" preserveAspectRatio="xMidYMid meet" viewBox="0 0 24 24">
		<path fill="none" stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M9 21H5a2 2 0 0 1-2-2V5a2 2 0 0 1 2-2h4m7 14l5-5l-5-5m5 5H9" />
	</svg>
	Salir
</a></li>';
    }
    return $str;
}


?>