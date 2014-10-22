## httpgener8

### Purpose

Provide simple generators for types found when dealing with the HTTP protocol.

### Usage

Generating HTTP codes and request/response headers can be done with the following:

```scala

import httpgener8._

// create generator for HTTPResponse object from your favorite framework
val genResponse = for {
  c  <- genValidHttpStatusCode
  hs <- Gen.listOfN(5, genStandardHttpResponseHeader)
  ss <- Gen.listOfN(5, ...)
} yield HTTPResponse(c, hs zip ss)

```

### Prerequisites

1. Java 8
2. Scala 2.11.3
3. SBT 0.13.0+

### Getting Started

Inside the root directory of the repository:

1. Launch SBT:

        $ sbt

2. Compile everything and run all tests:

        > test

### Code Structure

I use a less common structure to my code than many Scala projects so here is
the code structure outline and explanation:

* **Types:** I use a _more_ functional style of coding in Scala and as a
  result start coding from _*closed*_ algebraic data types (usually sum,
  product, and recursive types), which define the basic elements of the
  domain. These traits (types) and corresponding case classes/objects (value
  constructors) can be found in the `Types` trait for namespacing. See below
  for description of namespace organization.
* **"Classes":**  this does not refer to OO classes but rather typeclass
  definitions. I have a trait named `Classes` which contains typeclass
  definitions used to extend our basic sum, product, and recursive data
  types.
* **"Instances":** again this does not refer to "instances" of OO classes,
  rather this refers to implementations of typeclasses for specific types.
  In the trait named `Instances` you will find a number of implicits that
  can be mixed in to different contexts later the allows Scala to find
  the correct instance definition for a specific type of a typeclass based
  on the scope it is introduced. More specific scopes have higher precedence
  which means the default `scalacheck-http-generators` package instance definitions can be
  overridden in applicaation/client code at a higher level if necessary.
* **Functions:** I have a trait named `Functions`, which along side the
  interface to our core types and typeclasses provides the public API for
  the `scalacheck-http-generators` library/toolkit.
* **Namespacing:** You will note I am using traits for namespacing primitives
  that I then use to mixin to objects used for external package namespacing.
