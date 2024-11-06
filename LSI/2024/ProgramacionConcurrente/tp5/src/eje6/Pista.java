/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eje6;

import java.util.concurrent.Semaphore;

/**
 *
 * @author Brunot
 */
public class Pista {
  private Semaphore semAterrizando;
  private Semaphore semDespegando;
  private int maximoAviones;  
  public Pista(int max)
  {
  
    semAterrizando=new Semaphore(0,true);
    semDespegando=new Semaphore(0,true);
    maximoAviones=max; 
  }
  public void solicitarAterrizar()
  { 
  
  }  
  public void despegar()
  {
  
  }
}
