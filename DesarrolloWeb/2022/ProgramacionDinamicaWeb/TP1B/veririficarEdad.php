<?php 
if($_GET)
{

  if($_GET["edad"]>18)
  {
      echo "es mayor de edad";
  }
  else
  {
      echo "es menor de edad";
  }

}

?>