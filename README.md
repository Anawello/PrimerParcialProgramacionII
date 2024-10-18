# 🏨 Sistema de Servicios de Hospedaje y Gastronomía

---

## Alumno

**Nombre del alumno**: Nicolás Culetto

## 📄 Descripción del Proyecto

Este proyecto es un sistema de gestión diseñado para administrar servicios de hospedaje y gastronomía, implementando
conceptos de Programación Orientada a Objetos (POO) en Java. El objetivo es crear una aplicación que permita gestionar
estos servicios, calcular precios finales con promociones y aplicar validaciones utilizando excepciones.

### Objetivos

- Implementar un modelo orientado a objetos que refleje la gestión de servicios de hospedaje y gastronomía.
- Aplicar promociones y descuentos según las condiciones definidas.
- Validar la integridad de los datos utilizando excepciones específicas.

## 🛠️ Funcionalidades del Sistema

El sistema ofrece las siguientes funcionalidades:

### 1. Gestión de Servicios

- **Servicios de Hospedaje**: Administración de hospedajes como habitaciones o cabañas.
- **Servicios de Gastronomía**: Manejo de servicios gastronómicos como menús específicos.
- **Aplicación de Promociones**: Aplicación de descuentos según el día de la semana y si el servicio está en promoción.

### 2. Promociones y Descuentos

- Promociones aplicables a servicios de hospedaje durante días hábiles (lunes a viernes).
- Descuentos para servicios de gastronomía basados en el día de la semana seleccionado.

### 3. Validaciones

- Manejo de excepciones para situaciones como códigos de servicio inválidos o duplicados, y atributos que no cumplen con
  las reglas del negocio.

### 4. Cálculo de Precio Final

- Método para calcular el precio final del servicio, teniendo en cuenta promociones y descuentos según el día y el tipo
  de servicio.

## 📦 Estructura del Proyecto

El proyecto está compuesto por las siguientes clases y subclases:

### 1. **Servicio** (Clase Abstracta)

- **Atributos**:
    - `codServicio`: Código del servicio (6 caracteres, con validación).
    - `porcentajeDescuento`: Porcentaje de descuento aplicable al servicio.
    - `enPromocion`: Indica si el servicio está en promoción.
    - `diaCreacion`: Indica si el día en el que se creo el servicio.
- **Métodos Abstractos**:
    - `calcularPrecioFinal(LocalDate dia)`: Método abstracto para calcular el precio final del servicio, según el día.
    - `validarCodServicio(String codServicio)`: Valida si el codigo dado cumple el requisito de longitud de 6 digitos, en caso de no cumplirlo lanza una excepción.

### 2. **Hospedaje** (Subclase de Servicio)

- **Atributos Específicos**:
    - `hospedaje`: Tipo de hospedaje (ej. Cabaña, Habitación).
    - `precioPorNoche`: Precio por noche de hospedaje.
- **Métodos**:
    - `calcularPrecioFinal(LocalDate dia)`: Aplica descuentos entre semana (lunes a viernes) si el servicio está en
      promoción.
    - `isDiaPromocion(LocalDate dia)`: Verifica si el dia pertence al lapso de lunes a viernes.

### 3. **Gastronomía** (Subclase de Servicio)

- **Atributos Específicos**:
    - `gastronomia`: Tipo de servicio gastronómico (ej. desayuno, almuerzo).
    - `precio`: Precio del servicio gastronómico.
    - `diaSemDesc`: Día de la semana en que se aplica el descuento.
- **Métodos**:
    - `calcularPrecioFinal(LocalDate dia)`: Aplica el porcentaje de descuento si el día corresponde al día de descuento
      y si está en promoción.
    - `isPromocion(LocalDate dia)`: Verifica si el dai dado aplica parta la promoción del servicio.

### 4. **Sistema** (Clase Principal)

- **Atributos**:
    - `lstServicio`: Lista de servicios disponibles (hospedaje y gastronomía).
- **Métodos**:
    - `traerServicio(String codServicio)`: Retorna un servicio específico según su código.
    - `traerServicio(boolean enPromocion)`: Retorna una lista de servicios que están en promoción.
    - `traerServicio(boolean enPromocion, LocalDate dia)`: Retorna una lista de servicios en promoción y que apliquen
      descuentos según la fecha.
    -
    `agregarGastronomia(String codServicio, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc)`:
    Agrega un servicio de gastronomía al sistema.
    -
    `agregarGastronomia(String codServicio, LocalDate dia, double porcentajeDescuento, boolean enPromocion, String gastronomia, double precio, int diaSemDesc)`:
    Agrega un servicio de gastronomía al sistema con un día de creacón especifico.
    -
    `agregarHospedaje(String codServicio, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche)`:
    Agrega un servicio de hospedaje al sistema.
    -
    `agregarHospedaje(String codServicio, LocalDate dia, double porcentajeDescuento, boolean enPromocion, String hospedaje, double precioPorNoche)`:
    Agrega un servicio de gastronomía al sistema con un día de creacón especifico.
