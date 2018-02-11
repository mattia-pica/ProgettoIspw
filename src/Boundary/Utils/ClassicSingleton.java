package Boundary.Utils;

import Entity.Professore;

public class ClassicSingleton {
   private static ClassicSingleton instance = null;
   private Professore professore;

   protected ClassicSingleton() {
      // Exists only to defeat instantiation.
   }
   public static ClassicSingleton getInstance() {
      if(instance == null) {
         instance = new ClassicSingleton();
      }
      return instance;
   }

   public Professore getProfessore() {
      return professore;
   }

   public void setProfessore(Professore p){
      professore = p;
   }

}