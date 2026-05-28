# Sistema de Ecommerce

El proyecto está desarrollado en Java y actualmente funciona mediante consola. El objetivo es convertirlo en una API RESTful completa con Spring Boot y MySQL.


## Estado del proyecto

> **Fase actual:** Java puro, lógica orientada a objetos, arquitectura por capas (domain, service, presentation), persistencia temporal en memoria. CRUD de productos, categorías y pedidos.
> **Etapa en desarrollo:** Migración a Spring Boot y persistencia con MySQL.



## Funcionalidades actuales

- Gestión de **productos**
- Gestión de **categorías**
- Gestión de **pedidos**
- Interacción mediante menú por consola



## Tecnologías actuales

| Tecnología | Uso |
|---|---|
| Java | Lenguaje principal |
| Git | Control de versiones |



## Estructura del proyecto

```
src/ 
├── domain/ 
│   ├── model/ 
│   ├── repository/ 
│   ├── interfaces/ 
│   └── exception/ 
├── service/        # Lógica de negocio 
├── presentation/ 
│   └── console/    # Interfaz por consola 
├── utils/ 
└── app/ 
    └── Main.java # Punto de entrada
```



## Cómo ejecutar

1. Clonar el repositorio

```bash
git clone https://github.com/ManuelBernardez/e-commerce.git
cd e-commerce
```

2. Abrir el proyecto en cualquier IDE compatible con Java.

3. Ejecutar la clase `Main.java`.



## Roadmap

- [x] CRUD de productos por consola
- [x] CRUD de categorías por consola
- [x] CRUD de pedidos por consola
- [ ] Migración a Spring Boot
- [ ] Persistencia con MySQL
- [ ] Implementación de endpoints REST
- [ ] Integración con frontend
- [ ] Carrito de compras
- [ ] Autenticación y autorización
- [ ] Configuración de CORS
- [ ] Dockerización



## Objetivos técnicos

- Aplicar principios SOLID
- Practicar arquitectura por capas
- Implementar una API REST escalable
- Integrar persistencia relacional con MySQL
- Preparar el sistema para despliegue con Docker



## Autor

Desarrollado por Manuel Bernardez,
Proyecto desarrollado con fines educativos.
