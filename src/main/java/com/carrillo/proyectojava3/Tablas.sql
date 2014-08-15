
create table categoria (id integer primary key
                auto_increment,
                descripcion varchar(80));

create table producto (id_producto integer primary key
            auto_increment,id_categoria integer,
            descripcion varchar(80),
            foreign key (id_categoria) references categoria(id));

create table precio (id_precio integer primary key
            auto_increment,id_prod integer,
            precio float,
            foreign key (id_prod) references producto(id_producto));