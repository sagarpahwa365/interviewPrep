

-- 1. Question: Retrieve the second highest salary from an Employee table.
-- Method 1:
SELECT MAX(salary) AS SecondHighestSalary
FROM employees
WHERE salary < (SELECT MAX(salary) FROM employees);
-- Method 2:
SELECT salary AS SecondHighestSalary
FROM employees
ORDER BY salary DESC limit 1 OFFSET 1;
-- Explanation:
-- Method 1 is preferable as it handles ties in a more straightforward manner.


-- 2. Question: Find the nth highest salary from an Employee table.
-- Method 1:
SELECT DISTINCT salary
FROM employees
ORDER BY salary DESC
LIMIT 1 OFFSET 3;


-- 3. Question: Retrieve employees who do not manage anyone.
-- Method 1:
SELECT * FROM employees
WHERE id NOT IN (
	SELECT DISTINCT manager_id FROM employees WHERE manager_id IS NOT NULL
);
-- Method 2:
SELECT * FROM employees e1
WHERE NOT EXISTS (SELECT 1 FROM employees e2 WHERE e2.manager_id = e1.id);
-- Explanation:
-- Method 2 using NOT EXISTS is often more efficient as it avoids potential issues with NULL values.


-- 4. Question: Calculate the average salary for each department along with the department name.
-- Method 1:
SELECT department_name, AVG(salary) AS average_salary
FROM employees e
GROUP BY department_name;
-- Method 2:
SELECT department_name, AVG(salary) OVER (PARTITION BY department_name) AS average_salary
FROM employees;
-- Explanation:
-- Method 1 is standard and easy to understand, while Method 2 is useful for more complex windowing functions.


-- 5. Question: Identify employees who have the same salary as their manager.
-- Method 1:
SELECT e1.*
FROM employees e1
JOIN employees e2 ON e1.manager_id = e2.id AND e1.salary = e2.salary;
-- Method 2:
SELECT * FROM employees
WHERE (id, salary) IN (SELECT manager_id, salary FROM employees);
-- Explanation:
-- Method 1 using explicit JOIN is generally more readable and performs well.


-- 6. Question: Retrieve the top N distinct salaries from an Employee table.
-- Method 1:
SELECT DISTINCT salary
FROM employees
ORDER BY salary DESC
LIMIT N;
-- Method 2:
SELECT salary
FROM employees
GROUP BY salary
ORDER BY salary DESC
LIMIT N;
-- Explanation:
-- Method 1 is concise and often performs better with an appropriate index on the salary column.


-- 7. Question: Find employees who joined before their manager.
-- Method 1:
SELECT e1.*
FROM employees e1
JOIN employees e2 ON e1.manager_id = e2.id AND e1.date_of_joining < e2.date_of_joining;
-- Method 2:
SELECT e1.*
FROM employees e1
WHERE EXISTS (SELECT 1 FROM employees e2 WHERE e2.id = e1.manager_id AND e1.date_of_joining < e2.date_of_joining);
-- Explanation:
-- Method 1 using explicit JOIN is often more readable and performs well.


-- 8. Question: Calculate the cumulative salary for each department.
-- Method 1:
SELECT e.department_name, SUM(e.salary) OVER (PARTITION BY e.department_name ORDER BY e.department_name) AS cumulative_salary
FROM employees e;
-- Method 2:
SELECT e.department_id, e.id, e.salary, (
    SELECT SUM(salary) FROM employees e2
    WHERE e2.department_id = e.department_id AND e2.id <= e.id
) AS cumulative_salary
FROM employees e;
-- Explanation:
-- Method 1 is generally more efficient as it utilizes the window function for cumulative sums.
