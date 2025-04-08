<?php 
function data_submitted()
{   //creamos un array vacio
    $_AAux = array();
    //verificamos que $_POST no este vacio
    if (!empty($_POST))
    {
        //les asignamos a _AAux los valores de $_POST
        $_AAux = $_POST;
    }
    else{
    //Sino verificamos que $_GET no este vacio
       if (!empty($_GET))
      {
        //les asignamos a _AAux los valores de $_GET
        $_AAux = $_GET;
      }
    }
    //comprobamos si el array $_AAux existe
    if(array_key_exists('coordenadas',$_AAux))
    {
    if (count($_AAux["coordenadas"])>0) {

      for($i=0;$i<count($_AAux["coordenadas"]);$i++)
      {
         $lat=$_AAux["coordenadas"][$i]["latitud"];
         $lon=$_AAux["coordenadas"][$i]["longitud"];
         if($lat=="")
         {
            $_AAux["coordenadas"][$i]["latitud"]=0;   
         }
         if($lon=="")
         {
            $_AAux["coordenadas"][$i]["longitud"]=0;  
         }
      }
    }
    }
    return $_AAux;
}
// para la version de PHP 7 usar este autoload
/* 
function __autoload($class_name){
    //echo "class ".$class_name ;
    $directorys = array(
        $_SESSION['ROOT'].'Modelo/',
        $_SESSION['ROOT'].'Modelo/conector/',
        $_SESSION['ROOT'].'Control/',
      //  $GLOBALS['ROOT'].'util/class/',
    );
    //print_object($directorys) ;
    foreach($directorys as $directory){
        if(file_exists($directory.$class_name . '.php')){
            // echo "se incluyo".$directory.$class_name . '.php';
            require_once($directory.$class_name . '.php');
            return;
        }
    }
}*/
// para la version de PHP 8 usar este autoload

spl_autoload_register(function ($clase) {
    // echo "Cargamos la clase  ".$clase."<br>" ;
     $directorys = array(
         $GLOBALS['ROOT'].'modelo/',
         $GLOBALS['ROOT'].'control/',
         $GLOBALS['ROOT'].'modelo/conector/',
         $GLOBALS['ROOT'].'modelo/otrasclases/',
     );
     // print_r($directorys) ;
     foreach($directorys as $directory){
         if(file_exists($directory.$clase . '.php')){
             // echo "se incluyo".$directory.$class_name . '.php';
             require_once($directory.$clase . '.php');
             return;
         }
     }
 
 
 });
