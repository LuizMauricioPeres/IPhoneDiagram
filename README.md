# Object Orientation and UML: iPhone Class Diagramming


EThis is a UML diagram that represents the class and interface structure for a system that includes a model of the iPhone, a device that incorporates the functionality of a music player, a telephone, and a web browser. This diagram was created as part of the design challenge for **Claro(2024) - Java com Spring Boot** in DIO.me.

![iphone](https://github.com/LuizMauricioPeres/IPhoneDiagram/blob/main/IPhone.png)

## Interfaces:

### DiskJokey

Interface responsible for signing a music player contract. Contains the following methods:
 ( play, pause, stop, next, previous, selectTrack and selectMusic ).

### Celular

Interface responsible for signing a contract for a wireless telephone device. Contains the following methods:
 ( call, receiveCall, power, volumeUp, VolumeDown and mute ).

### Browse

Interface responsável por firmar contrato de um navegador web. Contém os seguintes métodos:
 ( browse, search, download, openPage, newTab and refresh ).

## Class:

### IPhone
this implements functionals interfaces ( DiskJokey, Celular and Browse)

This diagram is an simple Prototype.