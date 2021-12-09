CREATE TABLE public.entidad (
                                id_entidad serial NOT NULL,
                                nombre varchar NOT NULL,
                                ruc_ci varchar NOT NULL,
                                email varchar NULL,
                                telefono varchar NULL,
                                fecha_ingreso date NULL,
                                proveedor char NULL,
                                cliente char NULL
);

ALTER TABLE public.entidad ADD CONSTRAINT entidad_pk PRIMARY KEY (id_entidad);


COMMENT ON TABLE public.entidad IS 'Contiene los datos de los clientes y proveedores';

-- Column comments

COMMENT ON COLUMN public.entidad.proveedor IS 'verifica si es proveedor. S= Si, N = No';
COMMENT ON COLUMN public.entidad.cliente IS 'verifica si es cliente. S= Si, N = No';


--TABLA DE MODADLIDAD
CREATE TABLE public.modalidad (
                                  id_modalidad serial NOT NULL,
                                  modalidad varchar NOT NULL,
                                  precio numeric NULL,
                                  CONSTRAINT modalidad_pk PRIMARY KEY (id_modalidad)
);
COMMENT ON TABLE public.modalidad IS 'Almacena las modalidades de los servicios';



--TABLA DE RELACION CLIENTE MODALIDAD
CREATE TABLE public.cliente_modalidad (
              id serial NOT NULL,
              id_entidad int NULL,
              id_modalidad int NULL,
              CONSTRAINT cliente_modalidad_pk PRIMARY KEY (id),
              CONSTRAINT cliente_modalidad_fk FOREIGN KEY (id_entidad) REFERENCES public.entidad(id_entidad),
              CONSTRAINT cliente_modalidad_fk_1 FOREIGN KEY (id_modalidad) REFERENCES public.modalidad(id_modalidad)
);


--TABLA DE PRODUCTO
CREATE TABLE public.producto (
                                 id_producto serial NOT NULL,
                                 codigo numeric NULL,
                                 descripcion varchar NULL,
                                 fecha_vencimiento date NULL,
                                 cantidad numeric NULL,
                                 precio numeric NULL,
                                 CONSTRAINT producto_pk PRIMARY KEY (id_producto)
);


