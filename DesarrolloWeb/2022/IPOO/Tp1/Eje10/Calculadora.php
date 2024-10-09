<?php
class Calculadora{
private $num1;
private $num2;

public function  __construct($num1,$num2){
    // Metodo constructor de la clase Calculadora
    $this->num1 = $num1;
    $this->num2 = $num2;
            
}
public function getNum1(){
    return $this->num1;
}

public function getNum2(){
    return $this->num2;
}

public function sumar()
{
    $res=$this->getNum1()+$this->getNum2();
    return $res;  
}
public function restar()
{
    $res=$this->getNum1()-$this->getNum2();
    return $res;  
}
public function multiplicar()
{
    $res=$this->getNum1()*$this->getNum2();
    return $res;  
}
public function dividir($otraCalcu)
{
    $res=$this->getNum1()/$this->getNum2();
    return $res;  
}
public function __toString(){
    return "num1:".$this->getNum1()." num2:".$this->getNum1()."\n";
}    
}

 ?>