CREATE TABLE Students (
    studentId INT PRIMARY KEY AUTO_INCREMENT,
    rollNo INT UNIQUE NOT NULL,
    name VARCHAR(100) NOT NULL,
    age INT NOT NULL,
    gender CHAR(1) NOT NULL CHECK (gender IN ('M', 'F'))
);

CREATE TABLE Instructors (
    instructorId INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(100) NOT NULL,
    department VARCHAR(100) NOT NULL
);


CREATE TABLE Courses (
    courseId INT PRIMARY KEY AUTO_INCREMENT,
    courseCode VARCHAR(10) UNIQUE NOT NULL,
    courseName VARCHAR(100) NOT NULL,
    instructorId INT,
    FOREIGN KEY (instructorId) REFERENCES Instructors(instructorId)
);


CREATE TABLE Timeslots (
    timeslotId INT PRIMARY KEY AUTO_INCREMENT,
    startTime TIME NOT NULL,
    endTime TIME NOT NULL
);


CREATE TABLE Batches (
    batchId INT PRIMARY KEY AUTO_INCREMENT,
    courseId INT NOT NULL,
    batchName VARCHAR(50) NOT NULL,
    timeslotId INT NOT NULL,
    FOREIGN KEY (courseId) REFERENCES Courses(courseId),
    FOREIGN KEY (timeslotId) REFERENCES Timeslots(timeslotId)
);


CREATE TABLE Batch_Students (
    batchId INT NOT NULL,
    studentId INT NOT NULL,
    PRIMARY KEY (batchId, studentId),
    FOREIGN KEY (batchId) REFERENCES Batches(batchId),
    FOREIGN KEY (studentId) REFERENCES Students(studentId)
);
