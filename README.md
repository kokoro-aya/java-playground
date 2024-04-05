A simple Java program to illustrate multi-layer design as well as combination of MVC pattern and the repository pattern.

Usage:

```bash

$ cd src/main/java/

# To build the Java program
$ ./build.sh

# To run the program
$ ./run.sh

```

The `Launcher.java` provides a simple single-threaded example to run the program sequentially by creating 3 accounts and 
performing actions on these accounts.

The `Main.java` runs roughly the same things but with the bank and clients on different threads. The use case guarantees
that no race condition should occur. But the program itself is not thread-safe.

To discuss the thread-safety and transaction, please refer to my [TDD-Kata](https://github.com/kokoro-aya/TDD-Kata) 
repository. This Java program is here to provide a simplest example of MVC, repository pattern and multi-layer.

No dependency is required (that's why you can build with `build.sh` instead of downloading Gradle).

No test is provided because this is not a TDD courseware.

The code didn't handled nulls, exceptions properly, and some algorithm implementations were not optimal as they are not 
the main issue that is discussed here.

`Animal.java` is irrelevant.