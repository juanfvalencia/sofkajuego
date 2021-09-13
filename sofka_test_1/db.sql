CREATE DATABASE sofka_juego_2;

USE sofka_juego_2;

CREATE TABLE Usuarios(
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(255) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE Categorias(
    id int NOT NULL AUTO_INCREMENT,
    nombre varchar(255),
    complejidad int NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE Preguntas (
    id int NOT NULL AUTO_INCREMENT,
    idCategoria int NOT NULL,
    enunciado varchar(255) NOT NULL,
    opcionCorrecta int NOT NULL,
    opcion1 varchar(255) NOT NULL,
    opcion2 varchar(255) NOT NULL,
    opcion3 varchar(255) NOT NULL,
    opcion4 varchar(255) NOT NULL,
    PRIMARY KEY (id),
    CONSTRAINT FK_Preguntas_Categoria FOREIGN KEY (idCategoria) REFERENCES Categorias(id)
);

CREATE TABLE Juegos(
    id int NOT NULL AUTO_INCREMENT,
    idUsuario int NOT NULL,
    fecha DATETIME DEFAULT CURRENT_TIMESTAMP,
    premio FLOAT,
    completado TINYINT,
    PRIMARY KEY (id),
    CONSTRAINT FK_Juegos_Usuario FOREIGN KEY (idUsuario) REFERENCES Usuarios(id)
);

CREATE TABLE Rondas(
    id int NOT NULL AUTO_INCREMENT,
    idPregunta int NOT NULL,
    idJuego int NOT NULL,
    orden int,
    resultado TINYINT,
    puntaje int,
    PRIMARY KEY (id),
    CONSTRAINT FK_Rondas_Juego FOREIGN KEY (idJuego) REFERENCES Juegos(id),
    CONSTRAINT FK_Rondas_Pregunta FOREIGN KEY (idPregunta) REFERENCES Preguntas(id)
);

INSERT INTO Usuarios(nombre) VALUES('Felipe');

INSERT INTO Categorias(nombre, complejidad) VALUES('Social', 1);
INSERT INTO Categorias(nombre, complejidad) VALUES('Psicologia', 2);
INSERT INTO Categorias(nombre, complejidad) VALUES('Ciencias', 3);
INSERT INTO Categorias(nombre, complejidad) VALUES('Tecnologia', 4);
INSERT INTO Categorias(nombre, complejidad) VALUES('Informatica', 5);

INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(1, 'Pregunta Social 1', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(1, 'Pregunta Social 2', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(1, 'Pregunta Social 3', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(1, 'Pregunta Social 4', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(1, 'Pregunta Social 5', 1, 'A', 'B', 'C', 'D');

INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(2, 'Pregunta Psicologia 1', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(2, 'Pregunta Psicologia 2', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(2, 'Pregunta Psicologia 3', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(2, 'Pregunta Psicologia 4', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(2, 'Pregunta Psicologia 5', 1, 'A', 'B', 'C', 'D');

INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(3, 'Pregunta de Ciencias 1', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(3, 'Pregunta de Ciencias 2', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(3, 'Pregunta de Ciencias 3', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(3, 'Pregunta de Ciencias 4', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(3, 'Pregunta de Ciencias 5', 1, 'A', 'B', 'C', 'D');

INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(4, 'Pregunta de Tecnologia 1', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(4, 'Pregunta de Tecnologia 2', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(4, 'Pregunta de Tecnologia 3', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(4, 'Pregunta de Tecnologia 4', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(4, 'Pregunta de Tecnologia 5', 1, 'A', 'B', 'C', 'D');

INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(5, 'Pregunta de Informatica 1', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(5, 'Pregunta de Informatica 2', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(5, 'Pregunta de Informatica 3', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(5, 'Pregunta de Informatica 4', 1, 'A', 'B', 'C', 'D');
INSERT INTO Preguntas(idCategoria, enunciado, opcionCorrecta, opcion1, opcion2, opcion3, opcion4) VALUES(5, 'Pregunta de Informatica 5', 1, 'A', 'B', 'C', 'D');
