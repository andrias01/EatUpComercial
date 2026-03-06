# EatUpComercial 🍽️

Bienvenido al repositorio central del **Módulo Comercial** de la aplicación **EatUp**. Este proyecto se desarrolla bajo una arquitectura de **microservicios** como parte de la materia **Software 3** en la **Universidad Católica de Oriente (UCO)**.

---

## 📌 Información del Proyecto
* **Semestre:** 2026-1
* **Institución:** Universidad Católica de Oriente (Rionegro, Antioquia)
* **Materia:** Software 3
* **Docente:** NOREÑA BLANDÓN JUAN PABLO

---

## 🏗️ Arquitectura de Microservicios
El sistema está diseñado para ser escalable e independiente. El módulo comercial se divide en los siguientes microservicios, donde cada integrante del equipo tiene la responsabilidad de un componente específico:



<p align="center">
  <img src="imagenesReadme/arquetipoReferencia.png" alt="Diagrama de Arquitectura EatUpComercial" width="800">
</p>

### Equipo de Desarrollo y Responsables

| Microservicio | Responsable | Foto (Click para ir al Perfil) |
| :--- | :--- | :---: |
| **VENDEDORES** | *Andrea Avendaño Jurado* | <a href="https://github.com/Anxdrx"><img src="https://avatars.githubusercontent.com/u/168867627?v=4" width="80" height="80" style="border-radius: 50%;"></a> |
| **DESCUENTOS** | *Juan Jose Narvaez Marin* | <a href="https://github.com/juanjosenarvaez13"><img src="https://avatars.githubusercontent.com/u/142563412?v=4" width="80" height="80" style="border-radius: 50%;"></a> |
| **CLIENTES** | *María Salome Gonzalez Blandón* | <a href="https://github.com/msgonzale"><img src="https://avatars.githubusercontent.com/u/165715137?v=4" width="80" height="80" style="border-radius: 50%;"></a> |
| **PROVEEDORES** | *Juan Camilo Bernal* | <a href="https://github.com/juancabernal"><img src="https://avatars.githubusercontent.com/u/170989469?v=4" width="80" height="80" style="border-radius: 50%;"></a> |
| **VENTAS** | *Andres Felipe Velez Alcaraz* | <a href="https://github.com/andrias01"><img src="https://avatars.githubusercontent.com/u/103292498?s=400&u=175e635ba13d385e698d7b40eb9c2cebe64ea27e&v=4" width="80" height="80" style="border-radius: 50%;"></a> |
| **COMPRAS** | *Nombre del Estudiante* | <a href="https://github.com/USUARIO_DE_GITHUB"><img src="imagenesReadme/compras.png" width="80" height="80" style="border-radius: 50%;"></a> |
| **MESAS** | *Alexandra Puerta Bustamante* | <a href="https://github.com/USUARIO_DE_GITHUB"><img src="imagenesReadme/mesas.png" width="80" height="80" style="border-radius: 50%;"></a> |

---

## 📁 Estructura del Repositorio
Cada carpeta a nivel de raíz representa un microservicio independiente.

```bash
EatUpComercial/
├── VENDEDORES/      # Gestión de personal de ventas
├── DESCUENTOS/      # Gestión de Descuentos
├── CLIENTES/        # Registro y fidelización de usuarios
├── PROVEEDORES/     # Gestión de suministros y contactos
├── VENTAS/          # Procesamiento de pedidos y facturación
├── COMPRAS/         # Gestión de inventario y egresos
├── MESAS/           # Control y disponibilidad de áreas físicas
└── imagenesReadme/  # Recursos visuales del proyecto (Fotos y diagramas)
```
<p align="center">
  <img src="imagenesReadme/ramas.png" alt="TRAERME LA RAMA DEV DEL REPOSITORIO Y PARARME SOBRE ELLA" width="800">
</p>

<p align="center">
  <img src="imagenesReadme/flujoGitHub.png" alt="FLUJO DE TRABAJO GITHUB" width="800">
</p>

## 🚀 FLUJO DE TRABAJO GITHUB - PROYECTO

```bash
# 1️⃣ Clonar repositorio
git clone <URL_DEL_REPOSITORIO>

# 2️⃣ Entrar al proyecto
cd nombre-del-proyecto

# 3️⃣ Cambiar a rama de desarrollo
git checkout dev

# 4️⃣ Crear rama para nueva funcionalidad
git checkout -b nombreDeRama

# Verificar rama actual
git branch

# ==========================================
# 🔎 ANTES DE SUBIR CAMBIOS (IMPORTANTE)
# ==========================================

# Ver si hay cambios nuevos en el repositorio remoto
git fetch

# Revisar qué cambios hicieron otros compañeros
git log --oneline --graph --all
# o Tambian
git loc

# Si no afecta tu trabajo, actualizar tu rama
git pull origin DEV

# ==========================================
# 📦 PREPARAR CAMBIOS
# ==========================================

# Ver qué archivos cambiaron
git status

# Agregar cambios al stage
git add .

# Crear commit con mensaje claro y detallado
git commit -m "Descripción clara y detallada de la funcionalidad implementada"

# Subir rama al repositorio
git push -u origin nombreDeRama

# ==========================================
# 🔁 CREAR PULL REQUEST
# ==========================================
# Ir a GitHub
# Crear Pull Request hacia la rama DEV
# En el repositorio en la nube debe aparcer Compare & pull request aqui poner un buen titulo y una excelente descripción
# Ya listo lo anterior dar click en Create pull request esperar que gitHub compare esa rama con la DEV con el fin de no encontrar un conflicto.
# Esperar revisión del equipo IMPORTENTE antes de dar click en Merge pull requies
# Luego de fucionar la rama con DEV te desplazas mas abajo y buscas Delete branch
# Asi eliminas la rama que usastes ya que cumplio su objetivo. 
# Puedo seguir con ese nombre de rama de formar local para seguir realizando nuevas funcionalidades y seguir el mismo flujo.

# ==========================================
# 🛠 COMANDOS IMPORTANTES
# ==========================================

# Cambiar de rama
git checkout nombreDeRama

# ⚠️ PELIGROSO ⚠️
# Este comando ELIMINA TODOS los cambios locales
# que no estén guardados en un commit.
# No se pueden recuperar fácilmente.
git reset --hard

# Revertir un commit SIN borrar historial (más seguro)
git revert <hash_del_commit>

# ==========================================
# 🌳 ESTRUCTURA DE RAMAS
# ==========================================
# main  -> Producción (estable)
# DEV   -> Desarrollo
# nombreRamasIndividuales/* -> Ramas individuales

```

## 📁 📚 Documentación obligatoria por Microservicio

Para mantener orden, claridad y facilitar la integración entre equipos, **cada microservicio debe incluir dentro de su propia carpeta un archivo de documentación**.

Se recomienda crear dentro de cada carpeta de microservicio su propio README:

- `README.md` (preferido ✅)  
  ó  
- `estructura.txt`

---

### 📌 ¿Qué debe contener esta documentación?

Cada microservicio debe documentar obligatoriamente:

---

### 🗄 1️⃣ Esquema de Base de Datos

Debe incluir:

- Nombre de la tabla  
- Campos  
- Tipo de dato  
- Clave primaria (PK)  
- Claves foráneas (FK)  
- Relaciones  

Ejemplo:

```txt
Tabla: vendedores

- id (UUID) PK
- nombre (VARCHAR 100)
- email (VARCHAR 100)
- telefono (VARCHAR 20)
- estado (BOOLEAN)
```

---

### 🔌 2️⃣ Endpoints que expone el microservicio

Debe documentarse cada endpoint con:

- Método HTTP (GET, POST, PUT, DELETE)  
- Ruta  
- Descripción  
- JSON de entrada (Request)  
- JSON de salida (Response)  

Ejemplo:

```json
POST /api/vendedores

Request:
{
  "nombre": "Juan Perez",
  "email": "juan@email.com",
  "telefono": "3001234567"
}

Response:
{
  "id": "uuid-generado",
  "nombre": "Juan Perez",
  "email": "juan@email.com",
  "telefono": "3001234567",
  "estado": true
}
```

---

## 🎯 Objetivo

- Evitar confusiones entre microservicios  
- Facilitar integración entre equipos  
- Permitir pruebas cruzadas  
- Definir claramente los contratos de API  
- Reducir errores en producción  

---

## 🚨 Regla del equipo

Ningún microservicio debe subirse al repositorio sin su documentación actualizada.  

La documentación hace parte del entregable obligatorio.

## 📦 PROPUESTAS DE JSON PARA ALGUNOS SERVICIOS


## 👨‍🍳 VENDEDORES

```json
{
  "vendedores": [
    {
      "tipo_documento": "CC",
      "identificacion": "1234567890",
      "nombre": "Juan Pérez García",
      "telefono": "3001234567",
      "correo": "juan.perez@email.com",
      "estado": "Activo"
    },
    {
      "tipo_documento": "CC",
      "identificacion": "9876543210",
      "nombre": "María López Rodríguez",
      "telefono": "3109876543",
      "correo": "maria.lopez@email.com",
      "estado": "Activo"
    },
    {
      "tipo_documento": "CE",
      "identificacion": "5555555555",
      "nombre": "Carlos Martínez Sánchez",
      "telefono": "3205555555",
      "correo": "carlos.martinez@email.com",
      "estado": "Inactivo"
    }
  ],
  "metadatos": {
    "total_vendedores": 5,
    "activos": 4,
    "inactivos": 1
  }
}

```
## 👤 CLIENTES

```json
{
  "id": 1,
  "primer_nombre": "Andrés",
  "segundo_nombre": "",
  "primer_apellido": "Pérez",
  "segundo_apellido": "",
  "activo": true,
  "direccion": "Calle 123 #45-67",
  "ciudad": "Bogotá",
  "telefono": "3001234567",
  "correo": "andres.perez@email.com",
  "tipo_documento": "CC",
  "numero_documento": "123456789",
  "vendedor_asignado": "9876543210",
  "total_compras_historico": 1250000,
  "descuentos_activos": [
    {
      "categoria_id": "CAT-001",
      "nombre": "Cumpleaños",
      "porcentaje": 15,
      "fecha_aplicacion": "2026-02-21"
    }
  ]
}
```
## 🪑 MESAS

```json
{
  "resumen_estado": {
    "total_registradas": 24,
    "ocupadas": 8,
    "desocupadas": 10,
    "reservadas": 6
  },
  "mesas": [
    {
      "numero_mesa": "Mesa 1",
      "ubicacion": "Terraza",
      "estado": "Desocupado",
      "configuracion_adicional": ["Accesible"],
      "detalles_sesion": null
    },
    {
      "numero_mesa": "Mesa 12",
      "ubicacion": "Planta Baja",
      "estado": "Ocupada",
      "configuracion_adicional": ["Area VIP", "Con vista"],
      "detalles_sesion": {
        "comensales": 4,
        "hora_apertura": "12:30 PM",
        "cliente_id": "1020304050",
        "vendedor_id": "9876543210",
        "tiempo_transcurrido_min": 45
      }
    },
    {
      "numero_mesa": "Mesa 2",
      "ubicacion": "Interior",
      "estado": "Reservado",
      "configuracion_adicional": [],
      "detalles_sesion": {
        "comensales": 2,
        "hora_reserva": "07:00 PM",
        "cliente_nombre": "Carlos Ruiz"
      }
    }
  ]
}
```
## 🎁 DESCUENTOS
```json
{
  "dashboard_resumen": {
    "categorias_activas": 12,
    "descuentos_asignados": 48,
    "clientes_con_descuento": 156,
    "porcentaje_descuento_promedio": "18%"
  },
  "categorias_descuento": [
    {
      "id": "CAT-001",
      "nombre": "Cumpleaños",
      "porcentaje": 15,
      "descripcion": "Descuento especial para clientes en su día de cumpleaños",
      "estado": "Activa"
    },
    {
      "id": "CAT-002",
      "nombre": "Venta Superior $1M",
      "porcentaje": 20,
      "descripcion": "Para clientes que hayan realizado compras superiores a $1,000,000",
      "estado": "Activa"
    },
    {
      "id": "CAT-003",
      "nombre": "Día Festivo",
      "porcentaje": 15,
      "descripcion": "Descuento aplicable en días festivos y fechas especiales",
      "estado": "Activa"
    },
    {
      "id": "CAT-004",
      "nombre": "Cliente Frecuente",
      "porcentaje": 10,
      "descripcion": "Para clientes con más de 10 visitas al mes",
      "estado": "Activa"
    }
  ],
  "asignaciones_recientes": [
    {
      "cliente_id": 1,
      "cliente_nombre": "Andrés Pérez",
      "descuento_aplicado": "Cumpleaños",
      "porcentaje": 15,
      "fecha_asignacion": "2026-02-21",
      "total_compras_historico": 1250000
    },
    {
      "cliente_id": 4,
      "cliente_nombre": "Ana Martínez",
      "descuentos_multiples": ["Venta Superior $1M", "Cliente Frecuente"],
      "contacto": "ana.martinez@email.com",
      "total_compras_historico": 2100000
    },
    {
      "cliente_id": 6,
      "cliente_nombre": "Carolina Díaz",
      "estado_descuento": "Sin descuentos",
      "total_compras_historico": 680000
    }
  ]
}
```
## 🍲 RECETAS
```json
{
  "recetario": [
    {
      "id": "REC-001",
      "nombre": "Bandeja Paisa",
      "categoria": "Receta",
      "estado": "Activo",
      "visible_en_menu": true,
      "costeo": {
        "costo_base": 6.17,
        "margen_ganancia_porcentaje": 35,
        "precio_venta": 9.48
      },
      "ingredientes_y_subrecetas": [
        { "nombre": "Arroz Blanco", "cantidad": 0.2, "unidad_medida": "kg", "costo_unitario": 3.5, "subtotal": 0.70 },
        { "nombre": "Frijoles Rojos", "cantidad": 0.15, "unidad_medida": "kg", "costo_unitario": 4.2, "subtotal": 0.63 },
        { "nombre": "Carne Molida", "cantidad": 0.15, "unidad_medida": "kg", "costo_unitario": 12.8, "subtotal": 1.92 },
        { "nombre": "Plátano Maduro", "cantidad": 0.1, "unidad_medida": "unidad", "costo_unitario": 2.1, "subtotal": 0.21 },
        { "nombre": "Chicharrón", "cantidad": 0.08, "unidad_medida": "kg", "costo_unitario": 15.5, "subtotal": 1.24 },
        { "nombre": "Aguacate", "cantidad": 0.05, "unidad_medida": "kg", "costo_unitario": 6.3, "subtotal": 0.32 },
        { "nombre": "Huevos", "cantidad": 1, "unidad_medida": "unidad", "costo_unitario": 0.35, "subtotal": 0.35 },
        { "nombre": "Arepa", "cantidad": 1, "unidad_medida": "unidad", "costo_unitario": 0.8, "subtotal": 0.80 }
      ]
    }
  ]
}
```
## 🧾 VENTAS (ORDEN)
```json
{
  "orden_id": "ORD-2026-0045",
  "vendedor": {
    "id": "9876543210",
    "nombre": "María López Rodríguez"
  },
  "mesa": {
    "numero_actual": "Mesa 12",
    "ubicacion": "Planta Baja",
    "comensales": 4,
    "hora_apertura": "2026-03-04T12:30:00Z",
    "tiempo_activo_minutos": 45
  },
  "cliente": {
    "es_consumidor_final": false,
    "id": "1020304050",
    "nombre": "Carlos Andrés Ruiz",
    "descuento_aplicado": {
      "nombre": "Cumpleaños",
      "porcentaje": 15
    }
  },
  "items_pedido": [
    {
      "item_instancia_id": "ITEM-001-A",
      "id_receta": "REC-001",
      "nombre": "Bandeja Paisa",
      "estado_cocina": "En Preparación",
      "cantidad": 2,
      "comentario": "Sin cebolla",
      "mesa_origen": "Mesa 12"
    }
  ],
  "totales": {
    "subtotal_bruto": 24.45,
    "valor_descuento": 3.67,
    "total_a_pagar": 20.78
  }
}
```
## 👨‍🍳 ACTUALIZACIÓN ESTADO COCINA
```json
{
  "orden_id": "ORD-2026-0045",
  "item_instancia_id": "ITEM-002-B",
  "nuevo_estado": "Listo",
  "hora_finalizacion": "2026-03-04T13:15:00Z"
}
```
