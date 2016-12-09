-- Tables
--Table: Account
CREATE TABLE Account (
    Id int NOT NULL,
    Password varchar(200) NOT NULL,
    Active bool NOT NULL,
    Salt int NOT NULL,
    role varchar(1) NOT NULL
) ENGINE=InnoDB  ;

-- Table: Agreement
CREATE TABLE Agreement (
    Id int NOT NULL,
    Start_Date date NOT NULL,
    Name varchar(200) NOT NULL,
    End_Date date NOT NULL
) ENGINE=InnoDB ;

-- Table: AgreementBenefit
CREATE TABLE AgreementBenefit (
    Agreement_Id int NOT NULL,
    Benefit_Id int NOT NULL
) ENGINE=InnoDB ;

-- Table: Benefit
CREATE TABLE Benefit (
    Id int NOT NULL,
    Description varchar(1000)
) ENGINE=InnoDB ;

-- Table: Graduate
CREATE TABLE Graduate (
    Id int NOT NULL,
    Charge varchar(200) NOT NULL,
    Employer varchar(500) NOT NULL,
    Office_Address varchar(200) NOT NULL,
    Office_Phone int NOT NULL,
    User_id int NOT NULL
) ENGINE=InnoDB ;

-- Table: Membership
CREATE TABLE Membership (
    Id int NOT NULL,
    Start_Date date NOT NULL,
    Receipt blob NOT NULL,
    PaymentNumber int NOT NULL,
    Account_Id int NOT NULL,
    Rate_id int NOT NULL,
    End_Date date NOT NULL
) ENGINE=InnoDB ;

-- Table: Program
CREATE TABLE Program (
    Id int NOT NULL,
    Name varchar(50) NOT NULL,
    Duration int NOT NULL
) ENGINE=InnoDB ;

-- Table: Rate
CREATE TABLE Rate (
    Id int NOT NULL,
    Year date NOT NULL,
    Value int NOT NULL
) ENGINE=InnoDB ;

-- Table: Request
CREATE TABLE Request (
    Id int NOT NULL AUTO_INCREMENT,
    User_Id int NOT NULL,
    Date date NOT NULL,
    Commentary varchar(1000) NOT NULL,
    State char(1) NOT NULL,
    CONSTRAINT PK_REQUEST PRIMARY KEY (Id)
) ENGINE=InnoDB ;

-- Table: Rol
CREATE TABLE Rol (
  Id int NOT NULL,
  Name varchar(50) NOT NULL
) ENGINE=InnoDB ;

-- Table: Student
CREATE TABLE Student (
    Id int NOT NULL,
    User_id int NOT NULL,
    Semester int NOT NULL
) ENGINE=InnoDB ;

-- Table: User
CREATE TABLE User (
    Id int NOT NULL,
    FirstName varchar(200) NOT NULL,
    LastName varchar(200) NOT NULL,
    Email varchar(200) NULL,
    Phone varchar(20) NOT NULL,
    Cellphone varchar(20) NULL,
    Program_Id int NOT NULL,
    YearGraduate int NOT NULL,
    BirthDate date NOT NULL,
    Period int NOT NULL,
    Rol_Id int NOT NULL
) ENGINE=InnoDB ;

-- Table: Uses
CREATE TABLE Uses (
    Account_Id int NOT NULL,
    Agreement_Id int NOT NULL
) ENGINE=InnoDB ;

--- Primary keys ---
--- Table: Program ---
ALTER TABLE Program ADD CONSTRAINT PK_PROGRAM
  PRIMARY KEY (Id);
  
--- Table: Rol ---
ALTER TABLE Rol ADD CONSTRAINT PK_ROL
  PRIMARY KEY (Id);
  
--- Table: Person ---
ALTER TABLE User ADD CONSTRAINT PK_PERSON
  PRIMARY KEY (Id);
  
--- Table: Student ---
ALTER TABLE Student ADD CONSTRAINT PK_STUDENT
  PRIMARY KEY (Id);
  
--- Table: Graduate ---
ALTER TABLE Graduate ADD CONSTRAINT PK_GRADUATE
  PRIMARY KEY (Id);
  
--- Table: Account ---
ALTER TABLE Account ADD CONSTRAINT PK_PERSON_ACCOUNT
  PRIMARY KEY (Id);
  
--- Table: Membership ---
ALTER TABLE Membership ADD CONSTRAINT PK_MEMBERSHIP
  PRIMARY KEY (Id);
  
--- Table: Rate ---
ALTER TABLE Rate ADD CONSTRAINT PK_RATE
  PRIMARY KEY (Id);
  
--- Table: Uses ---
ALTER TABLE Uses ADD CONSTRAINT PK_USES
  PRIMARY KEY (Account_Id, Agreement_Id);
  
--- Table: Agreement ---
ALTER TABLE Agreement ADD CONSTRAINT PK_AGREEMENT
  PRIMARY KEY (Id);
  
--- Table: Benefit ---
ALTER TABLE Benefit ADD CONSTRAINT PK_BENEFIT
  PRIMARY KEY (Id);
  
--- Table: AgreementBenefit ---
ALTER TABLE AgreementBenefit ADD CONSTRAINT PK_AGREEMENTBENEFIT
  PRIMARY KEY (Agreement_Id, Benefit_Id);


-- foreign keys
-- Reference: Account_Uses (table: Uses)

ALTER TABLE Uses ADD CONSTRAINT FK_Account_Uses FOREIGN KEY (Account_Id)
    REFERENCES Account (Id);

-- Reference: Afiliacion_Cuenta (table: Membership)
ALTER TABLE Membership ADD CONSTRAINT FK_Afiliacion_Cuenta FOREIGN KEY (Account_Id)
    REFERENCES Account (Id);

-- Reference: AgreementBenefit_Agreement (table: AgreementBenefit)
ALTER TABLE AgreementBenefit ADD CONSTRAINT FK_AgreementBenefit_Agreement FOREIGN KEY (Agreement_Id)
    REFERENCES Agreement (Id);

-- Reference: Agreement_Uses (table: Uses)
ALTER TABLE Uses ADD CONSTRAINT FK_Agreement_Uses FOREIGN KEY (Agreement_Id)
    REFERENCES Agreement (Id);

-- Reference: Benefit_AgreementBenefit (table: AgreementBenefit)
ALTER TABLE AgreementBenefit ADD CONSTRAINT FK_Benefit_AgreementBenefit FOREIGN KEY (Benefit_Id)
    REFERENCES Benefit (Id);

-- Reference: Cuenta_User (table: Account)
ALTER TABLE Account ADD CONSTRAINT FK_Cuenta_User FOREIGN KEY (Id)
    REFERENCES User (Id);

-- Reference: Program_User (table: User)
ALTER TABLE User ADD CONSTRAINT FK_Program_User FOREIGN KEY (Program_Id)
    REFERENCES Program (Id);

-- Reference: Request_User (table: Request)
ALTER TABLE Request ADD CONSTRAINT FK_Request_User FOREIGN KEY (User_Id)
    REFERENCES User (Id);

-- Reference: Tarifa_Afiliacion (table: Membership)
ALTER TABLE Membership ADD CONSTRAINT FK_Tarifa_Afiliacion FOREIGN KEY (Rate_id)
    REFERENCES Rate (Id);

-- Reference: User_Graduate (table: Graduate)
ALTER TABLE Graduate ADD CONSTRAINT FK_User_Graduate FOREIGN KEY(User_id) 
    REFERENCES User(Id) ON DELETE CASCADE;

-- Reference: User_Student (table: Student)
ALTER TABLE Student ADD CONSTRAINT FK_User_Student FOREIGN KEY(User_id) 
    REFERENCES User(Id) ON DELETE CASCADE;
    
-- Reference: User_Rol (table: User)
ALTER TABLE User ADD CONSTRAINT FK_Rol_User FOREIGN KEY(Rol_Id)
  REFERENCES Rol(Id);
