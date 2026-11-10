2# POO_FinalProject_Martinez1_Acevedo2

DIAGRAMA DE CLASES
```mermaid
classDiagram
  direction LR
  class Store
  class VideoGame
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







  
  
