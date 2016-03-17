## Jvm Internals
#### Łukasz Jercha
[![Build Status](https://travis-ci.org/ljercha/jvm.svg?branch=master)](https://travis-ci.org/ljercha/jvm)

Laboratorium 01
***
> Aplikacja rzuca wyjątkiem OutOfMemoryExpection, gdyż wypełniam całą stertę alokując pamięc metodą rekurencyjnie.
>   Z [dokumentacji](http://docs.oracle.com/javase/7/docs/technotes/tools/windows/java.html#nonstandard) wynika iż można modyfikować wielkość sterty.  

Uruchomienie projektu:
```bash

 mvn compile -f lab01
 mvn exec:java -f lab01 -Dexec.mainClass="lab01.Main"
 ```

***
Laboratorium 02  
Wyniki aplikacji:
  
  
> REFLEKSJA wywolanie metody:562.1315 ns
  
> REFLEKSJA odczytanie zmiennej:958.7505 ns 
  
> REFLEKSJA zapisanie zmiennej:885.8244 ns
  
> NORMALNE wywolanie metody:103.33035 ns
  
> NORMALNE odczytanie zmiennej:71.61855 ns
  
> NORMALNE zapisanie zmiennej:189.40955
  

***
Laboratorium 03  
Projekt zawiera 2 klasy testowanie za pomocą unit testów w porównaniu do jacksona.  

Uruchomienie projektu:
```bash

 mvn test
 ```
  
