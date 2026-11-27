The GamingZone🎮
2# POO_FinalProject_Martinez1_Acevedo2

Integrantes del grupo:
Juan Andrés Martínez Gutierrez(74200)
Yurany Acevedo Duran (74012)

1. Informacion acerca del proyecto

The GamingZone es un sistema de gestión para una tienda de videojuegos, desarrollado en java, que permite administrar videojuegos fisicos y digitales, empleados, clientes,ventas, recibos, generos y plataformas.
El proyecto busca aplicar los principales conceptos de la programación orientada a objetos, mediante una estructura organizada en paquetes, clases, relaciones entre objetos, herencia, abstracción, encapsulamiento y polimorfismo.
Ademas el sistema permite guardar y recuperar la informacion de la tienda mediante la serializacion de objetos.

2. Funcionalidades
   
   VIDEOJUEGOS
   
• Registrar videojuegos fisicos y digitales

• Buscar videojuegos por identificador

• Modificar videojuegos registrados

• Eliminar videojuegos

• Consultar información y precio de venta

• Gestionar el stock de los videojuegos

• Gestionar las licencias disponibles de los videojuegos digitales

• Diferenciar los videojuegos fisicos nuevos y usados

   EMPLEADOS
• Registrar empleados
• Buscar empleados
• Modificar empleados
• Eliminar empleados
   CLIENTES
• Registrar clientes
• Buscar clientes
• Modificar clientes
• Eliminar clientes
   VENTAS
• Registrar ventas asociadas a un empleado, un cliente y un videojuego
• Buscar ventas por identificador
• Calcular el total de una venta segun la cantidad y el precio de venta del videojuego
   RECIBOS
• Registrar recibos asociados a una venta
• Buscar recibos por identificador
• Consultar el total de la venta asociada
   GENEROS
• Registrar generos
• Buscar generos
• Definir porcentajes de recargo asociado a los generos.
   PLATAFORMAS
• Registrar plataformas
• Buscar platafromas
• Modificar plataformas
• Definir porcentaje de recargo asociado a las plataformas

Además de estas funciones tambien se va a permitir guardar la información de la tienda en un archivo, cargar la información previamente almacenada y utilizar la serialización de objetos para conservar los datos. 

3.Organización del proyecto 
El proyecto será organizado en los siguientes paquetes: 
• domain --> Contiene las clases dominantes y la lógica de gestión de la tienda, alli estaran las siguientes clases:
    Person, Employee, Customer, VideoGame, PhysicalGame, DigitalGame, Platform, Gender, Sale, Receipt, Store
•ui --> Contiene la clase que se encarga de la interacción con el usuario mediante el menú de sonsola, alli estara la siguiente clase:
    Main
•data --> Contiene la clase encargada del almacenamiento y recuperación de datos de la tienda, alli estara la siguiente clase:
    StoreStorage 
•utils --> Contiene herramientas auxiliares para la interacción por consola, alli estara la siguiente clase: 
    Console

4. Descripcion de las clases principales

Person --> Clase que contiene los atributos comunes de identificación y nombre
Employee --> Representa a los empleados de la tienda y hereda los atributos de la clase Person
Customer --> Representa a los clientes, hereda tambien de la clase Person pero tiene atributos adicionales (Telefono y correo electronico)
VideoGame --> Clase abstracta que define los atributos y comportamientos comunes de los videojuegos
PhysicalVideoGame --> Representa los videojuegos físicos, hereda de la clase VideoGame con atributos adicionales (stock y condicion (NEW o USED) es decir, si es nuevo o usado)
DigitalVideoGame --> Representa los videojuegos digitales, hereda de la clase videogame con atributos adicionales (tamaño de descarga y licencias disponicles)
Platform --> Representa las plataformas de videojuegos y su porcentaje de recargo
Gender --> Representa los generos de videojuegos y su porcentaje de recargo
Sale --> Representa una vneta asociada a un empleado, un cliente, un videojuego y una cantidad
Receipt --> Representa un recibo asociado a una venta 
Store --> Representa la gestión de la tienda,  es la encargada de listar las demás clases. Se implementará un sistema de CRUDs completos y parciales. 
Main --> Contiene el menú principal y permite al usuario interactuar con el sistema
StoreStorage --> Se encarga de guardar y cargar los datos de la tienda mediante serialización
Console --> Facilita la lectura de datos y la representación de mensajes por consola 

5. Conceptos de programación orientada a objetos aplicados

ABSTRACCIÓN
Se aplica mediante la clase abstracta VideoGame, que define las características y comportamientos comunes de los videojuegos físicos y digitales, sin representar directamente una instancia concreta.

ENCAPSULAMIENTO
Los atributos de las clases se manejan mediante modificadores de acceso y métodos getters y setters, permitiendo controlar el acceso y la modificación de la información.

HERENCIA
Se utiliza para reutilizar atributos y comportamientos entre clases.
•Employee hereda de Person.
•Customer hereda de Person.
•PhysicalGame hereda de VideoGame.
•DigitalGame hereda de VideoGame.

Polimorfismo
Se aplica mediante el método calculateSellingPrice(), definido de manera abstracta en VideoGame y sobrescrito en PhysicalGame y DigitalGame, permitiendo calcular el precio de venta según el tipo de videojuego.

Relaciones entre clases
El sistema utiliza relaciones entre objetos para asociar videojuegos con plataformas y géneros, ventas con clientes, empleados y videojuegos, y recibos con ventas.

Colecciones
La clase Store utiliza listas de tipo List implementadas mediante LinkedList para almacenar y administrar los registros de las diferentes entidades.

Serialización
Se implementa mediante ObjectOutputStream y ObjectInputStream, permitiendo almacenar y recuperar el objeto Store y su información asociada.


   






PhysicalGame : Esta clase es una clase que hereda de la clase Videogame en donde lo que se quiere con esta clase es catalogar tal y como se hace en la vida real que existen videojuegos físicos en donde tendran cierto valor dependendiento también del estado en el cual se encuentre el videojuego para esto se ha implementado un sistema de dos estados uno donde el juego esta nuevo y otro donde esta usado, pará el videojuego usado se planteo dar un pequeño descuento entre el 5-10% para los juegos usados.

DigitalGame: Al igual es herencia de la clase VideoGame donde se tendrá un mismo sistema de venta aquí como las licencias no son usadas sino completamente nuevas se tendrá un valor fijo tal vez se implemente a futuro para esta clase un tipo de descuento estilo steam donde aveces hay juegos que se ponen en descuento.

Sale : Esta clase es uno de los pilares para la tienda ya que es aquí en donde se realiza la venta de los productos en este caso los videojuegos, en esta va a estar incluida el precio total a pagar por el cliente, la cantidad de juegos llevados, él costo de juegos individuales, entré otras cosas.

Receipt: El recibo o comprobante es lo que se lleva el cliente y va a estar relacionado con la venta básicamente aquí es donde se muestra toda la información antes mencionada.

Customer: Aquí es donde se posa la información básica de un cliente como lo es el numero de teléfono, el nombre entre otras.

Category: Esta clase tiene una responsabilidad muy importante la cual es categorizar los videojuegos para esto se ha escogido un sistema de constantes (enum) donde podemos poner fácilmente las categorías obvio no se a poder abarcar todas pero poco a poco se abarcara una selección considerable de las mismas, implementando esta clase se vino un idea la cual se tendrá en cuenta para la realización de este proyecto la cual es poner un tipo de recargo para ciertas categorías este recargo será entre el 5-10% sobre el videojuego.

Employee : Esta simplemente es la clase de un empleado.

Inventary: En esta clase es donde se demostraran la cantidad de videojuegos separados por categoría y plataforma, la cantidad disponible de cada uno y tal vez el precio base se incluya en este, también se pueden separar en plataforma, usados o nuevos.

Person : Esta clase se hizo con el objetivo de hacer herencia entre clases las cuales fueron la clase Employee y Customer ya que se leen "una persona es un empleado","una persona es un cliente" respectivamente.

Platform :Esta clase se hizo para evitar y facilitar el proceso de agregación de plataformas en la tienda ya que esta función estaba dada por un enum porque los enums al ser constantes no deberían de cambiar pero en la vida real las plataformas avanzan y salen nuevas ,lo cual dificultaba esta función, por lo cual se decidió agregar esta clase de tipo plataforma.

Gender : La clase Gender se hizo con el mismo propósito de la clase Platform agregar de forma mas sencilla nuevos géneros de videojuegos.

DIAGRAMA DE CLASES

```mermaid
classDiagram
  direction LR
  class Store{
        -int id;
        -List <Sale> sales;
        -List <Receipt> receipts;
        -List <Employee> employees;
        -List <Customer> customers;
        -List <Category> categories;
        -List <VideoGame> videoGames;
        -List <Gender> gendes;
        -List <Platform> platforms;
        -VideoGame videoGame;
        -Employee employee;
        -Sale sale;
        -Customer customer;
        -Receipt receipt;
        -Gender gender;
        -Platform platform;

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
        +registerGende () void;
        +searchGender () Gender;
        +registerPlatform () void;
        +searchPlatform () Platform;
        +modifyPlatform () void;
        +deletePlatform () void;
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

  class Gender{
        -final int genderId;
        -String name;
        }
  class Platform{
        -final int platformId;
        -String name;
        -float price;
}
  class Person{
        -int id;
        -String name;
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
      }
  class Customer{
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
  Store "1" --> "0..*" Category
  Store "1" --> "0..*" Sale
  Store "1" --> "0..*" Employee
  Store "1" --> "0..*" Customer
  Store "1" --> "0..*" Receipt
  Store "1" --> "0..*" PhysicalGame
  Store "1" --> "0..*" DigitalGame
  Store "1" --> "0..*" Platform
  Store "1" --> "0..*" Gender

  VideoGame <|-- DigitalGame
  VideoGame <|-- PhysicalGame
  VideoGame "1" --> "0..*" Sale
  VideoGame "1" --> "1" Gender
  VideoGame "1" --> "0..*" Platform

  Category "1" --> "0..*" DigitalGame
  Category "1" --> "0..*" PhysicalGame
  Category "1" --> "0..*" Sale

  Person <|-- Employee
  Person <|-- Customer

  Sale "1" --> "1" Employee
  Sale "1" --> "1" Customer
  Sale "1" --> "0..*" VideoGame

  Receipt "1" --> "1" Sale


  





  
  
