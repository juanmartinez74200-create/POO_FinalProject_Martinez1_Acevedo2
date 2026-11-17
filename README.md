2# POO_FinalProject_Martinez1_Acevedo2

Integrantes del grupo:
Juan Andrés Martínez Gutierrez(74200)
Yarany Acevedo (74012)

INFORMACION ACERCA DE EL PROYECTO

DIAGRAMA DE CLASES

```mermaid
classDiagram
  direction LR
  class Store
  class VideoGame{
        -int id;
        -String title;
        -float developer;
        -int releaseYear;
        -float basePrice;
        -boolean activate;
        -Plataform plataform
  }

  class Inventary
  class Category
  class Sale
  class Employee
  class Customer
  class Receipt
  class PhysicalGame
  class DigitalGame

  Store "1" --> "0..*" VideoGame 
  Store "1" --> "0..*" Inventary
  Store "1" --> "0..*" Category
  Store "1" --> "0..*" Sale
  Store "1" --> "0..*" Employee
  Store "1" --> "0..*" Customer
  Store "1" --> "0..*" Receipt
  Store "1" --> "0..*" PhysicalGame
  Store "1" --> "0..*" DigitalGame

  VideoGame <|-- DigitalGame
  VideoGame <|-- PhysicalGame
  VideoGame "1" --> "0..*" Sale

  Category "1" --> "0..*" DigitalGame
  Category "1" --> "0..*" PhysicalGame
  Category "1" --> "0..*" Sales

  Inventary "1" --> "0..*" VideoGame
  Inventary "1" --> "0..*" Sale
  Inventary "1" --> "0..*" Receipt

  Sale "1" --> "1" Employee
  Sale "1" --> "1" Customer

  Receipt "1" --> "1" Sale


  





  
  
