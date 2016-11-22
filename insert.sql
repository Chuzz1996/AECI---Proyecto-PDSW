--Insert Table: Rol--
INSERT INTO Rol (Id, Name)
  VALUES(1,'Graduado');
INSERT INTO Rol (Id, Name)
  VALUES(2,'Estudiante');
--Inset Table: Program--
INSERT INTO Program (Id, Name, Duration)
  VALUES (1,'Ingenieria Civil',10);
INSERT INTO Program (Id, Name, Duration)
  VALUES (2,'Ingenieria Electronica',10);
INSERT INTO Program (Id, Name, Duration)
  VALUES (3,'Ingenieria Electrica',10);
INSERT INTO Program (Id, Name, Duration)
  VALUES (4,'Ingenieria De Sistemas',10);
INSERT INTO Program (Id, Name, Duration)
  VALUES (5,'Ingenieria Industrial',10);
INSERT INTO Program (Id, Name, Duration)
  VALUES (6,'Matematicas',10);
INSERT INTO Program (Id, Name, Duration)
  VALUES (7,'Economia',10);
INSERT INTO Program (Id, Name, Duration)
  VALUES (8,'Administracion de Empresas',10);
INSERT INTO Program (Id, Name, Duration)
  VALUES (9,'Ingenieria Mecanica',10);
INSERT INTO Program (Id, Name, Duration)
  VALUES (10,'Ingenieria Biomedica',10);
--Insert Table: User--
INSERT INTO User (Id, FirstName, LastName, Email, Phone, Cellphone, Program_Id, YearGraduate, BirthDate, Period, Rol_Id)
  VALUES (1,'Felipe','Losada','felipe.losada@mail.escuelaing.edu.co','2697490','+573158207964',4,2018,'1996-07-29',1,2);
INSERT INTO User (Id, FirstName, LastName, Email, Phone, Cellphone, Program_Id, YearGraduate, BirthDate, Period, Rol_Id)
  VALUES (2,'Johan','Ramirez','johan.ramirez-c@mail.escuelaing.edu.co','2178695','+573043330674',4,2024,'1995-06-28',2,2);
INSERT INTO User (Id, FirstName, LastName, Email, Phone, Cellphone, Program_Id, YearGraduate, BirthDate, Period, Rol_Id)
  VALUES (3,'Kevin','Mendieta','kevin.mendieta-p@mail.escuelaing.edu.co','6052522','+573003013372',4,2018,'1998-04-24',2,2);
INSERT INTO User (Id, FirstName, LastName, Email, Phone, Cellphone, Program_Id, YearGraduate, BirthDate, Period, Rol_Id)
  VALUES (4,'Juan','Mejia','juan.mejia-s@mail.escuelaing.edu.co','5932175','+573153555576',4,2014,'1994-12-24',1,1);
INSERT INTO User (Id, FirstName, LastName, Email, Phone, Cellphone, Program_Id, YearGraduate, BirthDate, Period, Rol_Id)
  VALUES (5,'Sebastian','Moreno','sebastian.moreno-r@mail.escuelaing.edu.co','724690','+573115969184',4,2014,'1997-08-18',1,1);  
--Insert Table: Student--
INSERT INTO Student(Id, User_id, Semester)
  VALUES(1,1,8);
INSERT INTO Student(Id, User_id, Semester)
  VALUES(2,2,9);
INSERT INTO Student(Id, User_id, Semester)
  VALUES(3,3,8);
--Insert Table: Graduate--
INSERT INTO Graduate(Id, Charge, Employer, Office_Address, Office_Phone, User_id)
  VALUES(1, 'Analista de ventanas', 'Ventanas Fuertes LTDA', '', 3352462, 4);
INSERT INTO Graduate(Id, Charge, Employer, Office_Address, Office_Phone, User_id)
  VALUES(2, 'Investigador de lo desconocido', 'Misterios SA', '', 999999, 5);
--Insert Table: Request--
INSERT INTO Request(Id,User_Id, Date, Commentary, State)
  VALUES(1,1,'2016-06-13','','A');
INSERT INTO Request(Id,User_Id, Date, Commentary, State)
  VALUES(2,2,'2016-05-03','','E');
INSERT INTO Request(Id,User_Id, Date, Commentary, State)
  VALUES(3,3,'2016-03-23','','A');
INSERT INTO Request(Id,User_Id, Date, Commentary, State)
  VALUES(4,4,'2016-10-17','','E');
INSERT INTO Request(Id,User_Id, Date, Commentary, State)
  VALUES(5,5,'2016-11-01','','E');