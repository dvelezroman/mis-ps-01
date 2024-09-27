# Sistema de Gestión de Inventario

Este es un sistema de gestión de inventario diseñado para una tienda de productos electrónicos. La aplicación permite a los usuarios realizar operaciones CRUD (Crear, Leer, Actualizar y Eliminar) sobre los productos en el inventario.

## Requisitos

- JDK 17 o superior
- Docker
- Docker compose
- PostgreSQL
- Maven

## Instalación

1. **Clonar el repositorio**:
    ```bash
    git clone <URL_DEL_REPOSITORIO>
    cd SistemaInventario

2. **Correr docker compose**
    ```bash
    docker-compose up -d

3. **Compilar el proyecto**:
    ```bash
    mvn clean install

4. **Ejecutar la aplicación**:

Si estás usando un IDE como NetBeans, simplemente abre el proyecto y ejecuta la clase InventarioForm.
Si prefieres ejecutar desde la línea de comandos, usa el siguiente comando:
    ```bash
    java -cp target/SistemaInventario-1.0-SNAPSHOT.jar tu_paquete.InventarioForm

5. **Uso**

La interfaz gráfica te permitirá ingresar información sobre los productos y realizar las operaciones CRUD.
Usa los botones correspondientes para agregar, leer, actualizar o eliminar productos en el inventario.

**Contribuciones**
Las contribuciones son bienvenidas. Si deseas contribuir a este proyecto, por favor abre un issue o crea una pull request.

**Licencia**
Este proyecto está bajo la Licencia MIT. Consulta el archivo LICENSE para más detalles.

**Contacto**
Si tienes alguna pregunta o comentario, no dudes en contactarme a través de [dvelez2793@utm.edu.ec].