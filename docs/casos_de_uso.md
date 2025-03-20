**Descripción**: El sistema del diario del cazador permite a los cazadores buscar y solicitar cacerias de monstruos, y a los Investigadores del gremio gestionar dichas cazerias. Además, el sistema puede enviar notificaciones y recordatorios de los niveles de investigación de los monstruos cuando la investigación está próxima a completarse, utilizando una relación de **inclusión** (`<<include>>`) y de **extensión** (`<<extend>>`).

---

## Elementos del Diagrama de Casos de Uso

| Elemento                          | Descripción                                                                                          |
|-----------------------------------|------------------------------------------------------------------------------------------------------|
| **Actor: Cazadores**                | Cazador del diario del cazador que busca y solicita cacerias de monstruos.                                   |
| **Actor: Investigadores**          | Investigadores del diario del cazador que registra y gestiona los cacerias de monstruos.                           |
| **Actor: Sistema de Notificaciones** | Sistema externo encargado de enviar recordatorios sobre las investigaciones.                                |
| **Caso de Uso: Buscar Monstruo​**     | Permite al Cazadore buscar monstruos en el diario.                                                    |
| **Caso de Uso: Solicitar Caceria** | Permite al Cazadore solicitar la Caceria de un montruo.                                             |
| **Caso de Uso: Registrar Caceria** | Permite al Investigadores registrar la Caceria de un montruo solicitado por un cazador.                                      |
| **Caso de Uso: Enviar Notificación** | Envía una notificación a los Cazadores cuando se registra un Caceria (`<<include>>`).                  |
| **Caso de Uso: Recordatorio Investigación** | Extiende el caso de uso "Enviar Notificación" cuando la investigación está por terminar (`<<extend>>`). |

---

## Relaciones entre los Elementos

| Relación                                          | Descripción                                                                                     |
|---------------------------------------------------|-------------------------------------------------------------------------------------------------|
| **Cazadores → Buscar Monstruo​**                        | Asociación: El Cazadores interactúa con el sistema para buscar monstruos en el diario.             |
| **Cazadores → Solicitar Caceria**                  | Asociación: El Cazadores interactúa con el sistema para solicitar un Caceria de montruo.           |
| **Investigadores → Registrar Caceria**            | Asociación: El Investigadores registra un Caceria cuando se solicita un montruo.                 |
| **Registrar Caceria → Enviar Notificación**      | **Inclusión** (`<<include>>`): Al registrar la Caceria, se envía una notificación automática al Cazadores. |
| **Enviar Notificación → Recordatorio Investigación** | **Extensión** (`<<extend>>`): Se envía un recordatorio adicional cuando la investigación está próxima a terminar. |

---

## Explicación de las Relaciones de Inclusión (`<<include>>`) y Extensión (`<<extend>>`)

- **Incluir Enviar Notificación**: Cada vez que el Investigadores registra un Caceria (caso de uso "Registrar Caceria"), se activa automáticamente el caso de uso "Enviar Notificación" como una operación obligatoria para informar al Cazadores sobre la investigación.
  
- **Extender con Recordatorio Investigación**: **Recordatorio Investigación** extiende el caso de uso **Enviar Notificación**. La extensión (`<<extend>>`) se activa solo cuando la investigación está próximo a terminar, generando un recordatorio adicional para el Cazadores sobre investigación.

---

## Diagrama Completo

**Descripción Visual**: A continuación se representa el diagrama de casos de uso, con los actores y los casos de uso, y las relaciones de asociación, inclusión y extensión.

---
***(En proceso)***



Este modelo de diagrama de casos de uso para el sistema diario del cazador, ayuda a visualizar cómo interactúan los actores (Cazadores, Investigadores y Sistema de Notificaciones) con las funcionalidades clave.

---

# **Especificaciones de los Casos de Uso**

|  Actor | Cazador |
|---|---|
| Descripción  | _Breve descripción del actor_  |
| Características  | _Características que describen al actor_ |
| Relaciones | _Relaciones que tiene con otros actores. Básicamente cuando realiza las mismas acciones que otro actor._  |
| Referencias | _Que casos de uso realiza_ |   
|  Notas |  _Notas adicionales_ |
| Autor  | _Quien desarrolla la especificación del actor_ |
|Fecha | _Fecha de la especificación_ |

|  Actor | XXX (Nombre del Actor) |
|---|---|
| Descripción  | _Breve descripción del actor_  |
| Características  | _Características que describen al actor_ |
| Relaciones | _Relaciones que tiene con otros actores. Básicamente cuando realiza las mismas acciones que otro actor._  |
| Referencias | _Que casos de uso realiza_ |   
|  Notas |  _Notas adicionales_ |
| Autor  | _Quien desarrolla la especificación del actor_ |
|Fecha | _Fecha de la especificación_ |



