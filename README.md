# Jenkins packages
=========================
A collection of packages written in Groovy useful for Jenkins.

# 📜 Table of Contents
- [Setup project](#setup-project)
- [Package project](#package-project)
- [Usage](#usage)

# Setup project 
Jetbrains' Intellij IDE is suggested to open this project.

1. Clone the repository to your local.
2. Open project with Intellij by running `idea .` in the root folder of this repository.
3. Let IDE import the maven project.
4. Go to maven auto-reload settings and enable reload on any change.

## Run tests
Environment variables to setup before running tests:

```bash
# Needed variables
export K8S_HOST=
export K8S_TOKEN=
export GITHUB_TOKEN=
export SLACK_HOOK=
```

Use maven wrapper. Run the following command:

```bash
# All tests
./mvnw -e test

# Custom test
./mvnw -e -Dtest=GithubRepositoryApiClientTest test
```

# Package project
Use maven wrapper. Run the following command:

```bash
./mvnw package -DskipTests=true
```

# Usage

```groovy
URL jarURL = new File("/var/lib/jenkins/jenkins-packages.jar").toURI().toURL()
this.class.classLoader.addURL(jarURL)
LinkedHashSet<String> options = new LinkedHashSet<>(["a", "b", "c"])
Object dropdown = Class.forName("com.lozuwa.ui.service.Dropdown").getDeclaredConstructor().newInstance(options)
println(dropdown.render())
```

## Github
[Github](./documentation/github.md)

## Kubernetes
[Kubernetes](./documentation/kubernetes.md)

## Slack
[Slack](./documentation/slack.md)

## UI
[UI Components](./documentation/ui.md)
