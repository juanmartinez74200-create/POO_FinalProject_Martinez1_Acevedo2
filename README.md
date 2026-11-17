2# POO_FinalProject_Martinez1_Acevedo2

Integrantes del grupo:
Juan Andrés Martínez Gutierrez(74200)
Yarany Acevedo (74012)

INFORMACION ACERCA DE EL PROYECTO

En la información a continuación se dará una explicación  acerca de el proyecto de programación orientada a objetos en donde nuestro objetivos es llevar a cabo un sistema de gestión de una tienda de videojuegos (VideoGame Store),en donde tiene ciertos requisitos mínimos que incluyen a el paradigma orientado a objetos con conceptos como la herencia, él polimorfismo, las relaciones entre otras y un sistema de carpetas encargado de distribuir responsabilidades.

En este este proyecto se ha tenido como requisito tener por lo menos nueve clases de las cuales se conocerán a continuación :

Store : esta es la clase que dirigirá específicamente la tienda, esta clase es la encargada de listar las demás clases, aquí se implementó un sistema de CRUDs para las clases necesaria completo y para otras parciales en donde solo se buscara y añadirá, esta clase básicamente la encargada de todo el sistema de gestión.

VideoGame: la clase VideoGame es la clase encargada de crear los videojuegos por plataforma, además de eso es una clase de gran importancia ya que a partir de esta se estarán inclinando las demás clase porque la tienda gira al rededor de los videojuegos, esta clase traja con 4 plataformas las cuales están trabajadas por medio un (enum) la cuales son las siguiente :pc, Nintendo, PlayStation, Xbox todavía no es definitivo pero tal vez en un futuro cercano o lejano se tenga planeado elegir o poner juegos de consolas especificas como (PS5, Xbox one, Nintendo swich) como lo es realmente en una tienda de videojuegos real, por ende cada una de estas consolas especificas tendrán precios muy variables y no serán una generalidad como se tiene actualmente en el sistema.

PhysicalGame : Esta clase es una clase que hereda de la clase Videogame en donde lo que se quiere con esta clase es catalogar tal y como se hace en la vida real que existen videojuegos físicos en donde tendran cierto valor dependendiento también del estado en el cual se encuentre el videojuego para esto se ha implementado un sistema de dos estados uno donde el juego esta nuevo y otro donde esta usado, pará el videojuego usado se planteo dar un pequeño descuento entre el 5-10% para los juegos usados.

DigitalGame: al igual es herencia de la clase VideoGame donde se tendrá un mismo sistema de venta aquí como las licencias no son usadas sino completamente nuevas se tendrá un valor fijo tal vez se implemente a futuro para esta clase un tipo de descuento estilo steam donde aveces hay jeugos que se ponen en descuento.

Sale : Esta clase es uno de los pilares para la tienda ya que es aquí en donde se realiza la venta de los productos en este caso los videojuegos, en esta va a estar incluida el precio total a pagar por el cliente, la cantidad de juegos llevados, él costo de juegos individuales, entré otras cosas.

Receipt: El recibo o comprobante es lo que se lleva el cliente y va a estar relacionado con la venta básicamente aquí es donde se muestra toda la información antes mencionada.

Customer: Aquí es donde se posa la información básica de un cliente como lo es el numero de teléfono, el nombre entre otras.

Category: Esta clase tiene una responsabilidad muy importante la cual es categorizar los videojuegos para esto se ha escogido un sistema de constantes (enum) donde podemos poner fácilmente las categorías obvio no se a poder abarcar todas pero poco a poco se abarcara una selección considerable de las mismas, implementando esta clase se vino un idea la cual se tendrá en cuenta para la realización de este proyecto la cual es poner un tipo de recargo para ciertas categorías este recargo será entre el 5-10% sobre el videojuego.

Employee : Esta simplemente es la clase de un empleado.

Inventary: En esta clase es donde se demostraran la cantidad de videojuegos separados por categoría y plataforma, la cantidad disponible de cada uno y tal vez el precio base se incluya en este, también se pueden separar en plataforma, usados o nuevos.

DIAGRAMA DE CLASES

```mermaid
classDiagram
  direction LR
  class Store{
        -int id;
        -List <Sale> sales;
        -List <Receipt> receipts;
        -List <Inventary> inventaries;
        -List <Employee> employees;
        -List <Customer> customers;
        -List <Category> category;
        -List <VideoGame> videoGames;
        -VideoGame videoGame;
        -Employee employee;
        -Sale sale;
        -Customer customer;
        -Receipt receipt;
        -Inventary inventary;

        +registerVideoGame () void;
        +searchVideoGame () VideoGame;
        +modifyVideoGame () void;
        +deleteVideoGame () void;
        +registerEmployee () void;
        +searchEmployee () Employee;
        +modifyEmployee () void;
        +deleteEmployee () void;
        +registerSale () void;
        +searchSale () Sale;
        +registerCostumer () void
        +searchCustomer () Customer;
        +modifyCustomer () void;
        +deleteCustomer () void;
        +registerReceipt () void
        +searchReceipt () Receipt;
        }
  class VideoGame{
         <<abstract>> 
        -int id;
        -String title;
        -float developer;
        -int releaseYear;
        -float basePrice;
        -boolean activate;
        -Plataform plataform;

        +calculateSellingPrice () float*
        +calculateBasePrice () int
        +gameFormat () String*       
  }

  class Inventary{
        -List<VideoGame>videogames;
        }
  class Category{
        -int categoryId;
        -String description;
        -TipeGender tipeGender;
        }
  class Sale{
        -int saleId;
        -int amount;
        -Employee employee;
        -Customer customer;

        +totalPurchase () float;
      }
  class Employee{
        -int employeeId;
        -String employeeName;
      }
  class Customer{
        -int customerId;
        -String name;
        -String phoneNumber;
        -String email;
      }
  class Receipt{
        -int receiptId;
        -Sale sale;
        }
  class PhysicalGame{
        -int stock;
        -Condition condition;

        +increaseStock () void;
        +decreaseStock () void
        }
  class DigitalGame{
        -float downloadSize,
        -int availableLicenses;

        +increaseLicenses () void
        +decreaseLicenses () void
        }

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


  





  
  
