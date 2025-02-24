# Proyecto: Automatización de Pruebas con Page Object Model (POM)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=bbog-of-automated-testing&metric=alert_status&token=15056f4f194e0c3dc8318b8a227e13750ddf4f07)](https://sonarcloud.io/summary/new_code?id=bbog-of-automated-testing)

## Descripción

Este repositorio contiene el proyecto de automatización correspondiente a la página web de uso público y gratuito [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login). A continuación, se brinda información importante sobre el contenido del proyecto con el fin de orientar a las personas que deseen utilizar la implementación.

## Herramientas utilizadas

### Lenguaje de programación: Java

![Java](https://img.shields.io/badge/Java-21-orange)

Java es una excelente opción para proyectos de automatización debido a su portabilidad, compatibilidad con múltiples sistemas operativos gracias a la JVM y su fuerte tipado. Su robustez y amplia comunidad aseguran estabilidad, facilidad de mantenimiento y soluciones constantes.

---

### Gestor de dependencias: Maven

![Maven](https://img.shields.io/badge/Maven-3.8.1-blue)

Maven permite la gestión eficiente de dependencias y automatización del ciclo de vida del proyecto (compilación, pruebas y empaquetado). Su integración con herramientas de CI/CD y su estructura estandarizada hacen que sea una opción ideal para proyectos Java.

---

### Framework de automatización: Selenium

![Selenium](https://img.shields.io/badge/Selenium-4.29.0-yellow)

Selenium es una de las herramientas más populares para la automatización de pruebas de software. Su compatibilidad con múltiples navegadores y sistemas operativos garantiza pruebas consistentes. Además, se integra fácilmente con herramientas de CI/CD como Jenkins y GitHub Actions.

---

### Framework de pruebas: TestNG

![TestNG](https://img.shields.io/badge/TestNG-7.4.0-green)

TestNG facilita la ejecución de pruebas en paralelo, permite la agrupación de casos de prueba, la generación de reportes detallados y la configuración flexible de ejecuciones, lo que lo convierte en una solución robusta para pruebas automatizadas.

---

### Patrón de diseño: Page Object Model

![POM](https://img.shields.io/badge/POM-✔-blueviolet)

![POM](https://miro.medium.com/v2/resize:fit:720/format:webp/1*dJKK2i4-D_wCrvrXC4zczw.png)

El patrón Page Object Model (POM) mejora la mantenibilidad y la legibilidad del código al encapsular los elementos y métodos de interacción de cada página web en objetos separados. Esto reduce la duplicación de código y permite un mantenimiento más eficiente en caso de cambios en la UI.

## Ventajas del Proyecto

- **Modularidad**: Separación de la lógica de las pruebas de la estructura de la UI, facilitando el mantenimiento.
- **Reutilización**: Uso de objetos de página reutilizables en múltiples pruebas.
- **Ejecución eficiente**: TestNG permite gestionar casos de prueba y generar reportes detallados.
- **Integración continua**: Compatible con **GitHub Actions** para ejecución automatizada en pipelines CI/CD.
- **Reportes automatizados**: Generación de reportes en HTML tras la ejecución de pruebas.

## Requisitos Previos

- **Java 17+**
- **Maven** instalado y configurado
- **WebDriver dependiendo de tu navegador** (para pruebas en Selenium)

## Estructura del Proyecto

```
kata-categoria-9-gfranc2-automated-testing/
│── .github/
│   ├── workflows/                               # Definición de pipelines de CI/CD en GitHub Actions
│   │   ├── kata-test-integration.yml            # Workflow para ejecutar pruebas automatizadas
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/           # Clases que representan las páginas web (POM)
│   │   │   ├── utils/           # Métodos reutilizables y configuración
│   │   │   ├── constants/       # Definición de constantes del proyecto
│   │   │   ├── listeners/       # Listeners para eventos de TestNG
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/           # Clases de prueba que validan los flujos
│── pom.xml                      # Gestión de dependencias con Maven
│── testNG.xml                   # Configuración de TestNG
│── AutomationReport.html         # Reporte de ejecución de pruebas
│── .gitignore                    # Archivos ignorados en el repositorio
│── README.md                     # Documentación del proyecto

```

## Explicación del Workflow en GitHub Actions

El archivo `kata-test-integration.yml` define un pipeline de CI/CD que se ejecuta en GitHub Actions. A continución, se detallan los pasos del flujo de trabajo:

```yml
   name: Run test workflow for kata
   
   on:
    push:
      branches:
        - master
        - staging
   
   jobs:
   integration-kata-test:
   runs-on: ubuntu-latest  # Define el sistema operativo en el que se ejecutará el workflow
   
       steps:
         - name: Checkout automation project
           uses: actions/checkout@v4  # Descarga el código fuente del repositorio
   
         - name: Set up JDK
           uses: actions/setup-java@v3
           with:
             distribution: 'adopt'      # Especifica la distribución de Java
             java-version: '21'         # Especifica la versión de Java

         - name: Install dependencies for automation project
           run: mvn clean install -DskipTests  # Descarga dependencias y compila sin ejecutar pruebas
   
         - name: Run test cases for automation kata project
           run: mvn test -P run-testing  # Ejecuta los casos de prueba con el perfil "run-testing"
   
         - name: Upload test report artifact
           if: always()
           uses: actions/upload-artifact@v4
           with:
             name: test-report  # Nombre del artefacto a subir
             path: AutomationReport.html  # Ruta del archivo generado con los resultados de la prueba
```

Cada sección configura el entorno, instala dependencias, ejecuta pruebas y sube los reportes generados. Si deseas personalizar el flujo de trabajo, puedes modificar este archivo según tus necesidades,
por ejemplo cambiar la versión de Java que quieres usar, los comandos de instalación/ejecución o añadir pasos adicionales.


## Instalación y Ejecución

1. Clona el repositorio:
   ```sh
   git clone https://github.com/tu-repositorio.git
   cd kata-categoria-9-gfranc2-automated-testing
   ```
2. Instala las dependencias necesarias para tu proyecto:
   ```sh
   mvn clean install -DskipTests
   ```

2. Ejecuta tus test con el comando:
   ```sh
    mvn test -P run-testing
   ```

4. Revisa los reportes generados en `AutomationReport.html`.

## Contribución

Si deseas contribuir, por favor sigue el estándar de código y envía un **Pull Request**.

## Licencia

Este proyecto es de libre uso y distribución para quien desee utilizarlo.

## Referencias

Patrón de diseño page object model POM https://www.selenium.dev/documentation/test_practices/encouraged/page_object_models/

Guía de inicio rápido para GitHub Actions https://docs.github.com/es/actions/writing-workflows/quickstart

Repositorio de dependencias maven https://mvnrepository.com/



