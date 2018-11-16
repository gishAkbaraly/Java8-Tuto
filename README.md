# Java8-Tuto



This tutorial is a mix of what I could find on the internet, to give you the different knowledge to make your development

Welcome to my introduction to Java 8. This tutorial is a mix a of what I could find on internet ( with my personal touch ;) ). It will give you the main features of the API. 

## Table of Contents

* [Maps](#maps)

## Maps

Maps don't support stream, that means, there is no `stream()` method available. But you create a streams using the keys, values or entry of the map : `map.keySet().stream()`, `map.values().stream()` and `map.entrySet().stream()`. There is a bunch of new features include in `Map` interface that we will see right now. 

### putIfAbsent
Associate a value with key only if the key does not exist of if the value of the key is null

### forEach 
Consume all key-value of the map



