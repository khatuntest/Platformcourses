use Platform2;
CREATE TABLE Courses (
    id INT AUTO_INCREMENT PRIMARY KEY,  -- AUTO_INCREMENT replaced by IDENTITY
    title VARCHAR(100) NOT NULL,
    description TEXT,
	duration Varchar(50)
);

-- Admins_Courses Junction Table (many-to-many relationship)
CREATE TABLE Admins_Courses (
    admin_id INT,
    course_id INT,
    PRIMARY KEY (admin_id, course_id),
    FOREIGN KEY (admin_id) REFERENCES Admins(admin_id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
);

-- Instructors_Courses Junction Table (many-to-many relationship)
CREATE TABLE Instructors_Courses (
    instructor_id INT,
    course_id INT,
    PRIMARY KEY (instructor_id, course_id),
    FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
);

-- Create Student-Courses Relationship Table
CREATE TABLE Student_Courses (
    student_id INT,
    course_id INT,
    PRIMARY KEY (student_id, course_id),
    FOREIGN KEY (student_id) REFERENCES Students(id) ON DELETE CASCADE,
    FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
);

-- Create Lessons Table
CREATE TABLE Lessons (
    id INT  PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    otp VARCHAR(10),
    course_id INT,
    FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
);
-- Create Assignments Table
CREATE TABLE Assignments (
    id INT  PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    submission_link VARCHAR(255),
    feedback TEXT,
    grade float,
    course_id INT,
    FOREIGN KEY ( course_id ) REFERENCES Courses(id) ON DELETE CASCADE
);
-- Create Quizzes Table
CREATE TABLE Quizzes (
    id INT PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    description TEXT,
    number_of_questions INT,
    course_id INT,
    FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
);
CREATE TABLE Questions (
    id INT AUTO_INCREMENT PRIMARY KEY,  
    question_text TEXT NOT NULL,
    question_type VARCHAR(20) NOT NULL,  -- Replaced ENUM with VARCHAR
    options TEXT,  -- Store as JSON or comma-separated values
    correct_answer VARCHAR(255),
    quiz_id INT,
    FOREIGN KEY (quiz_id) REFERENCES Quizzes(id) ON DELETE CASCADE,
    CHECK (question_type IN ('MCQ', 'TRUE_FALSE', 'SHORT_ANSWER'))  -- Replacing ENUM with CHECK constraint
);
-- Create Media Files Table
CREATE TABLE Media_Files (
    id INT PRIMARY KEY,
    file_path VARCHAR(255) NOT NULL,
    course_id INT,
    FOREIGN KEY (course_id) REFERENCES Courses(id) ON DELETE CASCADE
);





insert into students(id, user_id, enrollment_date)
values (2, 2, '2024-12-19');


insert into users (id,name,email,password , role)
values (1,'menna','menna@gmail.com','123','student');
insert into users (id,name,email,password , role)
values (2,'malak','malak.com','283','student');







