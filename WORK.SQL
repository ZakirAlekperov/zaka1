/* ЗАДАЧА 1
Query the names of all the Japanese cities in the CITY table. The COUNTRYCODE for Japan is JPN.
The CITY table is described as follows:
*/

SELECT NAME FROM CITY WHERE COUNTRYCODE = "JPN";


/* ЗАДАЧА 2
Query a list of CITY names from STATION for cities that have an even ID number. Print the results in any order, but exclude duplicates from the answer.
The STATION table is described as follows:
*/

SELECT DISTINCT CITY FROM STATION WHERE MOD(ID,2)=0 ORDER BY CITY ASC; 

/* ЗАДАЧА 3
Query the average population for all cities in CITY, rounded down to the nearest integer.

Input Format

The CITY table is described as follows:
*/

SELECT ROUND (AVG(POPULATION)) FROM CITY;

/* ЗАДАЧА 4
Query the Western Longitude (LONG_W)where the smallest Northern Latitude (LAT_N) in STATION is greater than .
Round your answer to  decimal places.

*/

SELECT ROUND(LONG_W,4) FROM STATION WHERE LAT_N = ( SELECT MIN(LAT_N) FROM STATION WHERE LAT_N > 38.7780);


/* ЗАДАЧА 5
Given the CITY and COUNTRY tables, query the sum of the populations of all cities where the CONTINENT is 'Asia'.

Note: CITY.CountryCode and COUNTRY.Code are matching key columns.
*/

SELECT SUM(City.population) FROM Country INNER JOIN City ON Country.Code = City.CountryCode WHERE Country.Continent='Asia';

/* ЗАДАЧА 6
Given the CITY and COUNTRY tables, query the names of all cities where the CONTINENT is 'Africa'.

Note: CITY.CountryCode and COUNTRY.Code are matching key columns.

Input Format

The CITY and COUNTRY tables are described as follows:
*/

SELECT city.name FROM city JOIN country ON city.countrycode = country.code WHERE country.continent = 'Africa';