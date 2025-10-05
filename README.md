# Assignment 2 – Algorithmic Analysis and Peer Code Review

**Author:** Amanzhol Madiyar (SE-2407)  
**Role:** Student A — Insertion Sort (with optimizations)  
**Course:** Design and Analysis of Algorithms, AITU

---

## Overview
Реализация **Insertion Sort** с учётом метрик (comparisons, moves/swaps, array accesses, time) и оптимизаций для почти отсортированных данных.  
Есть CLI-бенчмарк и экспорт результатов в CSV для построения графиков и отчёта.

---

## Project Structure
src/main/java/
  algorithms/InsertionSort.java
  metrics/PerformanceTracker.java
  cli/BenchmarkRunner.java
src/test/java/
  algorithms/InsertionSortTest.java
docs/
  analysis-report.pdf           <- финальный отчёт (PDF)
  performance-plots/            <- графики/CSV (по желанию)
benchmark_results.csv           <- CSV (или docs/performance-plots/)
pom.xml


## Requirements
- Java 17+
- Maven 3.9+

## Build & Test
```bash
mvn -q clean test


mvn -q exec:java


---

## Build & Test
```bash
mvn -q clean test
Sample Results (random, seed=7)
n	      time_ms	comparisons	  moves (swaps counter)	      array_accesses
100	    1.170	  3 076	            2 889	                       9 046
1 000	  16.989	250 609	           248 618	                749 839
5 000	  37.534	6 163 006	          6 153 025	              18 479 045
10 000	61.935	25 041 050	     25 021 067	                    75 103 173

Complexity (Insertion Sort)

Best: Θ(n)

Average: Θ(n²)

Worst: O(n²)

Space: O(1), Stable ✅, Adaptive ✅

Branch Strategy

main — только рабочие релизы (v0.1, v1.0)

feature/*, fix/*, docs/*, ci/* — фичи, правки, документы, CI

Commit storyline (пример):

init: maven project structure, junit5 setup

feat(metrics): performance counters

feat(algorithm): insertion sort with optimization

test(algorithm): edge cases

feat(cli): benchmark runner + CSV export

fix(metrics): adjust array access counting

docs(report): analysis report (PDF)

docs(readme): overview, usage, results

release: v1.0 final

