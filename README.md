# PlataformaCombustible-Android

## 1. Nombre del Proyecto
**Scrum Backlog Inicial Proyecto Combustibles – Versión Android**

---

## 2. Descripción General
El sistema simula funcionalidades básicas asociadas a la administración de inventario, registro de salidas y consulta de precios de combustible, tomando como referencia el contexto normativo del sector energético en Colombia.

El proyecto representa una primera aproximación a la capa de presentación (Frontend móvil) de una arquitectura mayor.

---

## 3. Objetivo
Desarrollar una aplicación Android que permita:
- Consultar precio de combustible según tipo de vehículo.
- Administrar inventario de combustible.
- Registrar salidas con cálculo automático y generación de historial.

---

## 4. Tecnologías Utilizadas
- **Lenguaje:** Java
- **IDE:** Android Studio
- **SDK mínimo:** API 21 (Android 5.0 Lollipop)
- **Arquitectura:** Activities + Intents
- **Componentes UI:**
  - LinearLayout
  - ScrollView
  - Button
  - EditText
  - Spinner
  - TextView
  - ListView
  - Toast
- **Estructuras de Datos:**
  - ArrayList
- **Control de versiones:** Git
- **Repositorio remoto:** GitHub

---

## 5. Historias de Usuario Implementadas
### 5.1 Consulta de Precio
Como usuario, deseo seleccionar el tipo de vehículo para consultar el precio del combustible correspondiente.
Funcionalidad:
- Spinner para selección.
- Cálculo simulado de precio.
- Visualización en pantalla.

---

### 5.2 Manejo de Inventario
Como estación de servicio, deseo registrar cantidades de combustible para llevar control del inventario disponible.
Funcionalidad:
- Registro de galones.
- Acumulación dinámica.
- Actualización en tiempo real.

---

### 5.3 Registro de Salidas
Como estación de servicio, deseo registrar salidas de combustible indicando tipo, cantidad y fecha.
Funcionalidad:
- Selector de tipo (Corriente, Extra, Diesel).
- Cálculo automático (galones × precio).
- Validación de inventario.
- Generación de historial dinámico.
- Registro automático de fecha.
- ListView con salidas recientes.

---

## 6. Estructura del Proyecto
app/
├── java/co.edu.unipiloto.scrumbacklog/
│ ├── MainActivity.java
│ ├── ConsultaActivity.java
│ ├── InventarioActivity.java
│ └── SalidasActivity.java
│
├── res/
│ ├── layout/
│ │ ├── activity_main.xml
│ │ ├── activity_consulta.xml
│ │ ├── activity_inventario.xml
│ │ └── activity_salidas.xml
│ └── values/

---

## 7. Alcance del Proyecto

Este proyecto representa una implementación básica de la capa de presentación.  

No incluye:

- Base de datos persistente.
- Backend.
- Autenticación.
- Microservicios.
- Integración normativa dinámica.

Su finalidad es académica y de aprendizaje del entorno Android.

---

## 8. Instalación y Ejecución

1. Clonar repositorio: https://github.com/juandiegogalindo/AndroidStudio-ActividadScrum.git
2. Abrir en Android Studio.
3. Sincronizar Gradle.
4. Ejecutar en emulador o dispositivo físico.

---

## 9. Autores
1. Juan Pablo Coronado
2. Juan Diego Galindo
3. Sofia Torres Paez
   
Ingeniería de Sistemas  
Universidad Piloto de Colombia  

---
