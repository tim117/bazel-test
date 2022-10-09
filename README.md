# Bazel With Everything

It is an exciting idea to have one build system managing your whole codebase. [Bazel](https://bazel.build/) is an open source build tool project to build and test your multi-language projects. Internally at Google Blaze (Google's internal version of the Bazel build tool) has been fairly easy to work with. Bazel with everything is my attempt to try and setup a project in multiple ways, to test how well bazel works, and to determine whether I would use it again starting a new project.

## Disclaimers

- When making this project, I am using a Windows 11 PC to create this project. This repo might not work with a different setup.

- Since creating this project Bazel has gone through significant changes and could have much better support for Windows.

- I am writing this over 6 months after finishing my research on this topic, so a lot of things will probably be out of date and is all to the best of my memory.

## Setup

Traditionally I prefer using [vscode](https://code.visualstudio.com/) on my laptop for all types of projects. There is a [vscode bazel plugin](https://marketplace.visualstudio.com/items?itemName=BazelBuild.vscode-bazel) that worked pretty well for me. However, when working with Java, there is no support on vscode. All the Java files in this project were written with [Intellij Idea](https://www.jetbrains.com/idea/) which has a [plugin](https://plugins.jetbrains.com/plugin/8609-bazel) for the Bazel build system. I have found this plugin to often be out of date, not meant for use on windows, and hard to set up (however I eventually got it working although I don't remember all of the steps).

### Languages and Runtimes

This project has set up a couple different runtimes:

- Java
- Go
- Python
- NodeJS (JavaScript / TypeScript)

## Complaints

- Bazel seems to be written to work primarily the way that Google uses Blaze and primarily on linux. It was not pleasant wokring with it on a Windows 11 computer.

- A lot of configuration is needed to get non core languages (languages other than C++ and Java) set up with Bazel. Outside of these languages there is hardly any documentation to help you getting started. They are also not as stable cross machine versions (some things needed changes on windows to work).

## Findings

Working at Google, the Blaze build system has been an amazing tool to work with. Unfortunately, Bazel has not given me the same experience in this project. While it was good to work with once I had everything setup, the setup process took way too long and was often very confusing (I often looked at the actual Blaze setup at Google to help me with some of the setup for this workspace).

### Weird / annoying things I had to deal with

I don't remember every weird thing or all of the details that happened when building this project, so some might be vague or missing completely.

- **Dependencies**

  - Dependecy management can be awful. There is a lot of figuring out how packages depend on eachother especially in Java.

  - You need to know a lot about the third party packages you are using to get everything working. Bazel basically pulls down all of the dependencies in your project to have a local version of them and does not by default take into account anything that is not specified. If a dependency of a dependency of a dependency is missing, you will need to find that and make sure you include it.

- **Windows things**

  - WSL: Since the Blaze build tool at Google is used with linux, in order to have the least friction I tried to develop in WSL. On my WSL Bazel ran pretty slowely compared to outside of WSL which led me to try setting everything up on windows. On top of that IDE support for working in WSL isn't the best for all IDEs.

  - Architecture: Sometimes when building the targets they did not come out correctly due to windows architecture stuff. I remember having to edit some workspace configuration stuff to get it all working.

- **Java**

  - To get a standard spring boot app took much more effort than I wouldv'e liked.

  - 3rd party dependencies were the worst to work with in Java.

- **TypeScript / NodeJS**

  - Typescript is the last thing that I looked at and it had a lot of complexities when managing node_modules. It seemed like it was generating some bzl files automatically. I still haven't figured out what is going on here.

  - At the time of writing this project. TypeScript did not seem to be fully supported by Bazel which made it extremely hard to work with.

### Recommendation

While I would still keep all files in a mono-repo if I was running a company, I would not start with Bazel as of today for the kind of things that I primarily work on. However if I was working with only the core bazel languages (or python) without many 3rd party dependencies, I think Bazel could be a great solution to start your project with.

### What's next

In the future, there is a good chance that I revisit Bazel either with this project or with a new project to see how it has advanced, and next time I will be sure to document my findings as I am going so that it can, hopefully, be helpful to more people who are messing around with Bazel.
