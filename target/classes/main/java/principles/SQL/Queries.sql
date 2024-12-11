SELECT *
FROM students
WHERE GPA > (
    SELECT AVG(GPA)
    FROM students);


SELECT AVG(number_of_students)
FROM classes
WHERE teacher_id IN (
    SELECT id
    FROM teachers
    WHERE subject = 'English' OR subject = 'History');


SELECT subject, MAX(salary_by_subject.avg_salary) AS max_salary
FROM (
    SELECT subject, AVG(monthly_salary) AS avg_salary
    FROM teachers
    GROUP BY subject) salary_by_subject;


