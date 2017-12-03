# Business Process Testing

BPT es un framework de automatización integrado con la suite de herramientas de pruebas de HP. BPT ayuda a los analistas de negocios en el proceso de automatización. También se puede diseñar escenarios de automatización y ejecutarlos según sus requisitos sin conocimiento de automatización/codificación.

Un escenario de prueba consiste en una serie de Business Components, diseñados para verificar un determinado proceso en la aplicación.

BPT Framework:

* Components: Es un conjunto reutilizable de sentencias de automatización que realiza una tarea predefinida particular. Es similar a una función VBScript, pero está diseñado para usarse con el framework BPT
* Application Area: Es un repositorio que contiene todos los recursos necesarios para desarrollar los Business Components. Los recursos incluyen repositorio de objetos compartidos; bibliotecas funcionales reutilizables... etc.
* Flows: Util cuando se necesita usar componentes similares en el mismo orden en múltiples BPT. Entonces, en lugar de agregar los mismos componentes en todos y cada uno de los BPT, se puede crear un flujo de Business Components. El flow se puede invocar directamente en lugar de llamar a cada componente por separado.
* Business Process Test: Escenario que comprende un flujo en serie de Business Components, diseñado para probar un proceso específico de una aplicación.

## Por qué BPT?

BPT supera y soluciona desafíos que con otros frameworks tomaria tiempo y esfuerzo. Es un marco estandarizado donde involucra al equipo de desarrollo, analistas, etc., que define un proceso estándar para desarrollar.

Algunos desafíos con la automatización a mencionar:

* La falta de coordinación entre expertos en la materia (B.A., devs, etc.) y del àrea de Q.A. realizando la automatización.
* No hay papel para los testers manuales en el proceso de automatización, tendencia que sigue en aumento si el tester no tiene aptitudes en la codificaciòn.
* La falta de estándares en el desarrollo de la automatización, ya que, para cada empresa la implementaciòn es diferente y los resultados del [ROI](https://www.infoq.com/news/2009/04/testing-roi) determina que tan buena fue la decisiòn al implementar el framework de automatizaciòn.
* Existe la posibilidad de un mayor esfuerzo de mantenimiento de los scripts sin un framework robusto. Por lo general, las personas que no explotan la herramienta con la que se esta trabajando a su favor, tienden a desarrollar scripts ineficientes.

## Implementaciòn de BPT Framework:

Dentro de la herramienta, existen modulos que dentro tienen componentes necesarios para el desarrollo de las pruebas con BPT.

Los modulos y componentes se pueden detallar de la siguiente manera:

* Business Components Module
	* Manual Components
	* Automated Components
	* Keyword-Driven Components
	* Scripted Components

* Test Plan module: Este es el módulo donde se arrastran y sueltan los componentes en un orden lógico para BPT, que formará un escenario de prueba y donde se pueden depurar los componentes.
* Test Lab module: Nos permite ejecutar las pruebas de procesos y ver los resultados. Incluso se pueden ejecutar en paralelo pruebas BPT en las diferentes máquinas que usen esl módulo.

El proceso típico de automatización BPT implica las siguientes etapas:

* Crear los componentes manuales
* Automatizar los componentes
* Desarrollar los Flow's o BPT's
* Debug de los BPT
* Ejecuciòn de los BPT

### Paso 1) Crear los componentes manuales

```javascript
	DETALLES CON IMAGENES DEL PROCESO MAS ADELANTE :D
```
### Paso 2) Automatización de los componentes manuales
```javascript
	DETALLES CON IMAGENES DEL PROCESO MAS ADELANTE :D
```
### Paso 3) Desarrollando las BPT
```javascript
	DETALLES CON IMAGENES DEL PROCESO MAS ADELANTE :D
```
### Paso 4) Depuración del BPT
```javascript
	DETALLES CON IMAGENES DEL PROCESO MAS ADELANTE :D
```
### Paso 5) Ejecutando el BPT
```javascript
	DETALLES CON IMAGENES DEL PROCESO MAS ADELANTE :D
```
##
```javascript
EL DOCUMENTO SE MEJORARA CONFORME APRENDO LA HERRAMIENTA
```
### BONUS CODE!!!

![JAVARULES](http://i.imgur.com/1U54XsG.gif)

En la carpeta "samples" de este repositorio encontraran un archivo .java donde detalla la implementacion de [TestNG](http://testng.org/doc/) con el framework BPT.

Tambièn se subiran samples con mas informaciòn que ayude con las implementaciones de BPT en diferentes proyectos.