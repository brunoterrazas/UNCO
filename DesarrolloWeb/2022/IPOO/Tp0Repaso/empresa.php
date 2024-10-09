<?php 
 $arre_recaudacion = array();
 $arre_recaudacion[0] = ["cant_recaudada" => 75, "costo_total" => 45];
 $arre_recaudacion[1] = [ "cant_recaudada" => 110.5, "costo_total" => 30];
 $arre_recaudacion[2] = [ "cant_recaudada" => 65, "costo_total" => 25];

 $arre_recaudacion[3] = ["cant_recaudada" => 95, "costo_total" => 25];
 $arre_recaudacion[4] = [ "cant_recaudada" => 120, "costo_total" => 70];
 $arre_recaudacion[5] = [ "cant_recaudada" => 165, "costo_total" => 125];

 $arre_recaudacion[6] = ["cant_recaudada" => 175, "costo_total" => 115];
 $arre_recaudacion[7] = [ "cant_recaudada" => 120, "costo_total" => 80];
 $arre_recaudacion[8] = [ "cant_recaudada" => 145, "costo_total" => 75];

 $arre_recaudacion[9] = ["cant_recaudada" => 155, "costo_total" => 95];
 $arre_recaudacion[10] = [ "cant_recaudada" => 270, "costo_total" => 100];
 $arre_recaudacion[11] = [ "cant_recaudada" => 180, "costo_total" => 110];

 echo "El mes con que obtuvo mayor ganancia es :".mesEnTexto(mayorRecaudacion($arre_recaudacion));
 ///////////////////////////////////////////////////////////////////////////////
 
 function mayorRecaudacion($arre_recaudacion)
{
    $mayor=0;
    $pos_mayor=-1;
    
    foreach ($arre_recaudacion as $mes => $value)
     {
    
       $ganancia =($value["cant_recaudada"] - $value["costo_total"]);
      
       echo "la ganancia es $ganancia \n";
       if($ganancia>=$mayor)
       {
          $mayor=$ganancia;
          $pos_mayor=$mes;
       }
     }

    return $pos_mayor;
}
/** 
     * Retorna el mes como texto
     * STRING $mes
     * @param Int $indice
     * @return String 
     */
    function mesEnTexto($indice)
    {
        $mes = "";
        switch ($indice) {
            case 0:
                $mes = "Enero";
                break;
            case 1:
                $mes = "Febrero";
                break;
            case 2:
                $mes = "Marzo";
                break;
            case 3:
                $mes = "Abril";
                break;
            case 4:
                $mes = "Mayo";
                break;
            case 5:
                $mes = "Junio";
                break;
            case 6:
                $mes = "Julio";
                break;
            case 7:
                $mes = "Agosto";
                break;
            case 8:
                $mes = "Septiembre";
                break;
            case 9:
                $mes = "Octubre";
                break;
            case 10:
                $mes = "Noviembre";
                break;
            case 11:
                $mes = "Diciembre";
                break;
        }
        return $mes;
    }



?>