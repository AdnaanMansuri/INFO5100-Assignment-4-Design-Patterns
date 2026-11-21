# INFO5100 · Assignment 4 — Design Patterns

**Author:** Adnaan  ·  **Version:** 1.0

This submission implements the five required design patterns (Part I) plus the
State-Pattern redesign of the Lunar Rover (Part II, 30% bonus). Every class carries
full Javadoc (`@author`, `@version`, method purpose/params/returns, and attribute
rationale), and every pattern is demonstrated with JUnit 4 tests following the
course naming conventions (`<Class>Test`, `test<Method>()`, positive **and** negative
assertions).

## What's here

```
Submission/
├── src/                         ← source code (one package per pattern)
│   ├── singletondesignpattern/      Singleton       (SingleObject)
│   ├── facadedesignpattern/         Façade          (ShapeMakerFacade + Shape/Circle/Rectangle/Square)
│   ├── factorydesignpatterndemo/    Factory         (ShapeFactory + Shape/Circle/Rectangle/Square)
│   ├── statedesignpattern/          State           (Context + State/StartState/StopState)
│   ├── filterdesignpattern/         Filter/Criteria (Criteria + Male/Female/Single/And/Or + Person)
│   └── lunarroverstatepattern/      Part II — Lunar Rover redesigned with the State pattern
├── test/                        ← JUnit 4 test classes (mirrors the src packages)
│   ├── singletondesignpattern/SingleObjectTest.java
│   ├── facadedesignpattern/ShapeMakerFacadeTest.java
│   ├── factorydesignpatterndemo/ShapeFactoryTest.java
│   ├── statedesignpattern/StateTest.java
│   ├── filterdesignpattern/CriteriaTest.java
│   ├── lunarroverstatepattern/LunarRoverTest.java
│   └── testrunner/AllTestsRunner.java   ← runs every test class, prints a summary
├── lib/                         ← JUnit 4.13.2 + Hamcrest 1.3 (test dependencies)
├── sampleruns/                  ← screenshots of every demo run + JUnit results
└── build/                       ← compiled .class files (regenerated on build)
```

## Test results (all passing)

```
================ JUnit test run ================
SingleObjectTest                tests= 2  failures=0   PASS
ShapeMakerFacadeTest            tests= 3  failures=0   PASS
ShapeFactoryTest                tests= 5  failures=0   PASS
StateTest                       tests= 4  failures=0   PASS
CriteriaTest                    tests= 5  failures=0   PASS
LunarRoverTest                  tests=15  failures=0   PASS
------------------------------------------------
TOTAL   tests=34   failures=0   ->   ALL TESTS PASS
================================================
```

(Screenshot: `sampleruns/JUnit-Terminal.png`. Each demo run has its own
screenshot in `sampleruns/` — e.g. `Singleton-Demo.png`, `Filter-Demo.png`.)

## The patterns (Part I)

| Pattern | Key classes | Idea demonstrated |
|---|---|---|
| **Singleton** | `SingleObject` | private constructor + `static final` instance + `getInstance()`; the test proves two calls return the *same* object. |
| **Façade** | `ShapeMakerFacade` over `Shape`/`Circle`/`Rectangle`/`Square` | one simple interface (`drawCircle/Rectangle/Square`) hides the shape subsystem. |
| **Factory** | `ShapeFactory.getShape(String)` | centralizes object creation; the client names a type, not a class (case-insensitive, `null` for unknown). |
| **State** | `Context` + `StartState`/`StopState` | the context's behaviour changes as its `State` object is swapped. |
| **Filter** | `Criteria` + `CriteriaMale/Female/Single` + `AndCriteria/OrCriteria` | filter a list by decoupled, composable criteria. |

## Part II — Lunar Rover redesigned with the State pattern

The Assignment 3 Lunar Rover used enums plus one large `handle()` switch. Here each
state of the UML state machine is its own class:

- `RoverState` (abstract) — one method per event; unhandled events default to *ignored*.
- `DriveState` / `ToolsState` (abstract) — capture the shared `FLIP_SWITCH` behaviour.
- **DRIVE:** `RestState`, `AcceleratingForwardState`, `ConstantSpeedState`,
  `DeacceleratingState`, `AcceleratingBackwardState`.
- **TOOLS:** `IdleState`, `CameraReadyState`, `CameraCapturingState`,
  `CameraTemporizerState` (one camera-state class serves both cameras via a name field),
  `DrillOffState`, `DrillOnState`.
- `LunarRover` (the **Context**) just holds the current state + speed and *delegates*
  every event — no business logic switch anymore.

`LunarRover.main` replays the full Assignment 3 sample script; see
`sampleruns/LunarRover-Demo-1..3.png`.

## Build & run from the command line

From the `Submission/` folder (JDK 8+; JUnit jars are in `lib/`):

```bash
# Windows PowerShell — separator is ';'
javac -d build/classes (Get-ChildItem -Recurse src -Filter *.java).FullName
javac -d build/test-classes -cp "lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;build/classes" (Get-ChildItem -Recurse test -Filter *.java).FullName

# run all tests
java -cp "lib/junit-4.13.2.jar;lib/hamcrest-core-1.3.jar;build/classes;build/test-classes" testrunner.AllTestsRunner

# run any demo, e.g.
java -cp build/classes lunarroverstatepattern.LunarRover
```

## Producing the JUnit screenshots for submission (NetBeans / Eclipse)

1. Create a Java project and copy the `src/` and `test/` packages into it.
2. Add `lib/junit-4.13.2.jar` and `lib/hamcrest-core-1.3.jar` to the test classpath
   (or use the IDE's bundled JUnit 4).
3. Right-click each test class → **Run / Test** and screen-capture the green bar.
   Capture at least `SingleObjectTest`, `ShapeMakerFacadeTest`, `ShapeFactoryTest`,
   `StateTest`, `CriteriaTest`, and `LunarRoverTest`.
