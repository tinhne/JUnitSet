# JUnitSet

Small practice project (December 2023) for writing JUnit 5 tests, including a data-driven parameterized test whose inputs are read from an Excel sheet with Apache POI.

## What it practises

- JUnit 5 lifecycle hooks (`@BeforeEach`, `@AfterEach`) and plain `@Test` methods
- `@ParameterizedTest` with a `@MethodSource` factory
- Loading test data from an `.xlsx` file using Apache POI (`WorkbookFactory`, `Sheet`, `Row`, `Cell`)

## Contents

| File | Description |
| --- | --- |
| `src/Algorithm/math.java` | Class under test: `isPrimeNumber(n)` (trial division up to √n), `multiplication(a, b)`, `add(a, b)` |
| `src/Algorithm/ExcelDataReader.java` | Reads every row of a sheet into `List<List<Integer>>` |
| `src/Algorithm/mathTest.java` | `multiplication` test, and `TestPrimeNumber`, which runs once per Excel row and asserts every number in the row is prime |
| `Book1.xlsx` | Test data: `Sheet1`, 4 rows × 5 numbers |

The fourth row of `Book1.xlsx` contains non-prime values (for example 12 and 24), so that invocation of `TestPrimeNumber` fails as written.

## Tech stack

| Layer | Technology |
| --- | --- |
| Language | Java 21 (`maven.compiler.source/target` in `pom.xml`) |
| Testing | JUnit Jupiter (declared as `RELEASE` in `pom.xml`; the IntelliJ module uses JUnit 5.8.1), JUnit 4 also declared |
| Excel | Apache POI 4.1.2 (`poi`, `poi-ooxml`) |
| IDE | IntelliJ IDEA module `Com.JUnit.iml` |

## How to run

The sources live directly in `src/Algorithm/`, which is the source root of the IntelliJ module, not the Maven default `src/main/java` / `src/test/java`. Run the tests from IntelliJ:

1. Open the folder in IntelliJ IDEA with a JDK 21.
2. In `mathTest.getPrimeNumbersFromExcel`, change the hard-coded Windows path to the `Book1.xlsx` file in this repository (for example `"Book1.xlsx"` when the working directory is the project root).
3. Run `mathTest`.

`mvn test` will not find these classes unless they are moved into the standard Maven layout.

## Author

**Lê Văn Trung Tính** — Software Engineer | AI Product Builder

- Website: [trungtinh.site](https://trungtinh.site)
- GitHub: [@tinhne](https://github.com/tinhne)
