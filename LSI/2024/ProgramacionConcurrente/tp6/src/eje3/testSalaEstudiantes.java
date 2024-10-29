/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package eje3;


/**
 *
 * @author Brunot
 */
public class testSalaEstudiantes {
  public static void main(String[] args)
  {
      int cantEstudiantes=30;
      Sala sala=new Sala(20);
      Estudiante[] hilosEstudiante=new Estudiante[cantEstudiantes];
      for (int i = 0; i < cantEstudiantes; i++) {
          hilosEstudiante[i]=new Estudiante("Estudiante"+(i+1),sala);
          hilosEstudiante[i].start();
      }
  }
}
