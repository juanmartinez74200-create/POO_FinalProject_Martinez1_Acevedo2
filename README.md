# POO_FinalProject_Martinez1_Acevedo2

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

  Store "1" --> "" VideoGame
  Store "1" --> "" Inventary
  Store "1" --> "" Category
  Store "1" --> "" Sale
  Store "1" --> "" Employee
  Store "1" --> "" Customer
  Store "1" --> "" Receipt
  Store "1" --> "" PhysicalGame
  Store "1" --> "" DigitalGame


  
  
