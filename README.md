[![Build Status](https://travis-ci.org/jesusgsdev/springboot2junit5.svg?branch=master)](https://travis-ci.org/jesusgsdev/springboot2junit5)

# Demo project using Spring Boot 2 and jUnit 5
In this demo project I will be using Spring Boot 2.0 and jUnit 5 in their latest releases.

## Current stack

- SpringBoot 2.0.0 M4
- jUnit 5.0.0
- H2 Database 1.4.196

# Bookshop HU
This module will be the main hub. Here we will have a H2 database were we will be storing
all books we are receiving from the different providers.

# Bookshop Provider One and Two
This two modules will be in charge of send books to the Bookshop HUB so they will be acting
as producers sending JSON petitions to Bookshop HUB. 
