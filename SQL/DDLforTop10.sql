-- 1. Question: Retrieve the second highest salary from an Employee table.
-- 2. Question: Find the nth highest salary from an Employee table.
-- 3. Question: Retrieve employees who do not manage anyone.
-- 4. Question: Calculate the average salary for each department along with the department name.
-- 5. Question: Retrieve the third highest distinct salary from an Employee table.
-- 6. Question: Identify employees who have the same salary as their manager.
-- 7. Question: Retrieve the top N distinct salaries from an Employee table.
-- 8. Question: Find employees who joined before their manager.
-- 9. Question: Retrieve the employees with the second lowest salary.
-- 10. Question: Calculate the cumulative salary for each department.

id, name, salary, manager_id, department_name, date_of_joining  

queries to create table and insert sample data:
CREATE TABLE employees (
    id INT PRIMARY KEY,
    name VARCHAR(255),
    salary DECIMAL(10, 2),
    manager_id INT,
    department_name VARCHAR(255),
    date_of_joining DATE
);

INSERT INTO employees (id, name, salary, manager_id, department_name, date_of_joining)
VALUES
    (1, 'John', 50000, NULL, 'HR', '2022-01-01'),
    (2, 'Jane', 60000, 1, 'HR', '2022-02-15'),
    (3, 'Bob', 55000, 2, 'IT', '2022-03-10'),
    (4, 'Alice', 70000, NULL, 'IT', '2022-04-05'),
    (5, 'Charlie', 65000, 2, 'HR', '2022-05-20'),
    (6, 'Diana', 75000, 4, 'IT', '2022-06-15'),
    (7, 'Eva', 80000, 4, 'HR', '2022-07-01'),
    (8, 'Frank', 72000, 4, 'IT', '2022-08-10'),
    (9, 'Grace', 68000, 1, 'IT', '2022-09-25'),
    (10, 'Henry', 67000, 1, 'HR', '2022-10-15'),
    (11, 'Jack', 55000, 5, 'IT', '2022-11-01'),
    (12, 'Lucy', 72000, 7, 'HR', '2022-12-05'),
    (13, 'Sam', 60000, 1, 'IT', '2023-01-15'),
    (14, 'Sophie', 65000, 6, 'HR', '2023-02-20'),
    (15, 'Michael', 51000, 9, 'IT', '2023-03-01'),
    (16, 'Olivia', 61000, 10, 'HR', '2023-04-05'),
    (17, 'William', 56000, 3, 'IT', '2023-05-10'),
    (18, 'Emily', 69000, 4, 'HR', '2023-06-15'),
    (19, 'Daniel', 74000, 4, 'IT', '2023-07-01'),
    (20, 'Ava', 73000, 1, 'HR', '2023-08-10'),
    (21, 'Matthew', 59000, 2, 'IT', '2023-09-25'),
    (22, 'Sofia', 66000, 1, 'IT', '2023-10-15'),
    (23, 'James', 54000, 5, 'HR', '2023-11-01'),
    (24, 'Isabella', 71000, 7, 'IT', '2023-12-05'),
    (25, 'Benjamin', 67000, 1, 'HR', '2024-01-15'),
    (26, 'Charlotte', 62000, 6, 'IT', '2024-02-20'),
    (27, 'Logan', 58000, 1, 'HR', '2024-03-01'),
    (28, 'Amelia', 70000, 10, 'IT', '2024-04-05'),
    (29, 'Mason', 64000, 3, 'HR', '2024-05-10'),
    (30, 'Mia', 75000, 4, 'IT', '2024-06-15'),
    (31, 'Ethan', 55000, 4, 'HR', '2024-07-01'),
    (32, 'Harper', 72000, 4, 'IT', '2024-08-10'),
    (33, 'Lucas', 68000, 1, 'HR', '2024-09-25'),
    (34, 'Evelyn', 59000, 5, 'IT', '2024-10-15'),
    (35, 'Alexander', 64000, 6, 'HR', '2024-11-01'),
    (36, 'Avery', 57000, 7, 'IT', '2024-12-05'),
    (37, 'Daniel', 70000, 1, 'IT', '2025-01-15'),
    (38, 'Liam', 63000, 2, 'HR', '2025-02-20'),
    (39, 'Luna', 61000, 1, 'IT', '2025-03-01'),
    (40, 'William', 56000, 5, 'HR', '2025-04-05'),
    (41, 'Abigail', 71000, 4, 'IT', '2025-05-10'),
    (42, 'Noah', 65000, 3, 'HR', '2025-06-15'),
    (43, 'Stella', 60000, 1, 'IT', '2025-07-01'),
    (44, 'Carter', 72000, 7, 'IT', '2025-08-10'),
    (45, 'Chloe', 69000, 1, 'HR', '2025-09-25'),
    (46, 'Sebastian', 62000, 4, 'IT', '2025-10-15'),
    (47, 'Zoey', 63000, 6, 'HR', '2025-11-01'),
    (48, 'Grayson', 57000, 7, 'IT', '2025-12-05'),
    (49, 'Aria', 68000, 1, 'IT', '2026-01-15'),
    (50, 'Jackson', 60000, 2, 'HR', '2026-02-20'),
    (51, 'Madison', 59000, 1, 'IT', '2026-03-01'),
    (52, 'Mateo', 58000, 5, 'HR', '2026-04-05'),
    (53, 'Scarlett', 69000, 4, 'IT', '2026-05-10'),
    (54, 'Jayden', 64000, 3, 'HR', '2026-06-15'),
    (55, 'Penelope', 67000, 1, 'IT', '2026-07-01'),
    (56, 'Ryan', 66000, 6, 'IT', '2026-08-10'),
    (57, 'Layla', 62000, 1, 'HR', '2026-09-25'),
    (58, 'Luke', 55000, 4, 'IT', '2026-10-15');