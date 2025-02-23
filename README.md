# Proyecto: Automatización de Pruebas con Page Object Model (POM)

[![Quality Gate Status](https://sonarcloud.io/api/project_badges/measure?project=bbog-ob-automated-testing&metric=alert_status&token=15056f4f194e0c3dc8318b8a227e13750ddf4f07)](https://sonarcloud.io/summary/new_code?id=bbog-ob-automated-testing)

## Descripción

Este repositorio contiene el proyecto de automatización correspondiente a la página web de uso público y gratuito [OrangeHRM](https://opensource-demo.orangehrmlive.com/web/index.php/auth/login). A continuación, se brinda información importante sobre el contenido del proyecto con el fin de orientar a las personas que deseen utilizar la implementación.

## Herramientas utilizadas

### Lenguaje de programación: Java

![Java](https://img.shields.io/badge/Java-17-orange)

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

## Estructura del Proyecto

```
kata-categoria-9-gfranc2-automated-testing/
│── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── pages/          # Clases que representan las páginas web (POM)
│   │   │   ├── utils/          # Métodos reutilizables y configuración
│   │   │   ├── constants/      # Definición de constantes usadas en el proyecto
│   │   │   ├── listeners/      # Implementaciones de listeners para reporte de eventos
│   ├── test/
│   │   ├── java/
│   │   │   ├── tests/          # Clases de prueba que validan los flujos
│── pom.xml                      # Gestión de dependencias con Maven
│── testNG.xml                   # Configuración de TestNG
│── AutomationReport.html        # Reporte de ejecución de pruebas
│── .gitignore                   # Archivos ignorados en el repositorio
│── README.md                    # Documentación del proyecto
```

## Requisitos Previos

- **Java 17+**
- **Maven** instalado y configurado
- **WebDriver dependiendo de tu navegador** (para pruebas en Selenium)

## Instalación y Ejecución

1. Clona el repositorio:
   ```sh
   git clone https://github.com/tu-repositorio.git
   cd kata-categoria-9-gfranc2-automated-testing
   ```
2. Instala las dependencias y ejecuta las pruebas:
   ```sh
   mvn clean test
   ```
3. Revisa los reportes generados en `AutomationReport.html`.

## Contribución

Si deseas contribuir, por favor sigue el estándar de código y envía un **Pull Request**.

## Licencia

Este proyecto es de libre uso y distribución para quien desee utilizarlo.



