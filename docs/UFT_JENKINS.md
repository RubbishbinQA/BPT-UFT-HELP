# UFT - Ejecución de scripts de prueba automatizados utilizando Jenkins

## ¿Qué es Jenkins?

En las actividades del desarrollo de software, los desarrolladores hacen commits de su código muchas veces por día (al menos una vez). Esta integración de nuevo codigo debe verificarse (utilizando herramientas de compilación, pruebas unitarias e integración) para garantizar que el software no se rompa y que los desarrolladores no introducen ningún defecto. Este proceso se llama [Integración Continua](https://es.wikipedia.org/wiki/Integraci%C3%B3n_continua) y es práctica de desarrollo detectar estos problemas relacionados con la integración del código tan pronto como sea posible en el ciclo de vida del desarrollo del software. [Jenkins](https://es.wikipedia.org/wiki/Jenkins) es una  herramienta de integración continua que realiza esta verificación periódicamente o cada vez que el desarrollador envía el código al repositorio.

Jenkins es una aplicación basada en la web, totalmente GRATIS y de código abierto.

## Configuración de Jenkins-QTP:

* Los ingenieros comiten sus cambios SVN / Git / ALM.
* Jenkins activa una prueba siempre que el usuario realice una confirmación ya sea periódicamente / manualmente.
* Jenkins recibe la ultima versión del código y lo implementa.
* Jenkins ejecuta la prueba y archiva los resultados.
* El usuario puede ver los resultados en Jenkins directamente.

Para comprender la configuración anterior, hagamos lo siguiente:

1. Crear un script UFT:

    Por favor, revisa aquí el repositorio de [vinsguru](https://github.com/vinsguru/tag-qtp-jenkins-demo) para una mejor referencia.

2. Crear un "runner file":

    Se puede tomar el ejemplo con el repositorio de arriba, que seria el archivo [runner.vbs](https://github.com/vinsguru/tag-qtp-jenkins-demo/blob/master/runner.vbs)

3. Creando un trabajo en Jenkins:

.........
```javascript
	DETALLES DEL PROCESO MAS ADELANTE :D
```

![JENKINS](https://media2.giphy.com/media/l2SpLfc08SyQobmiA/giphy.gif)
