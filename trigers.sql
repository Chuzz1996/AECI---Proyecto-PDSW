CREATE TRIGGER autoIncrementStudent
BEFORE INSERT ON Student
FOR EACH ROW
BEGIN
  DECLARE autoIncrement int default 1;
  SELECT MAX(Id)+1 INTO autoIncrement FROM Student;
  set new.Id := autoIncrement;
END;
/
CREATE TRIGGER autoIncrementGraduate
BEFORE INSERT ON Graduate
FOR EACH ROW
BEGIN
  DECLARE autoIncrement int default 1;
  SELECT MAX(Id)+1 INTO autoIncrement FROM Graduate;
  set new.Id := autoIncrement;
END;
/
