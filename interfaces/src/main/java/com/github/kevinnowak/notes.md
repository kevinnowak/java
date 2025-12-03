# About Interfaces
* Describing what classes should do, without specifying how they should do it
* A class can implement one or more interfaces
* An interface is not a class but a set of requirements for the classes that want to conform to the interface
* All methods of an interface are automatically ```public``` -> supplying the keyword ```public``` is not necessary
* Interfaces can supply constants
* Interfaces never have instance fields
* Before Java 8, all methods in an interface were ```abstract```
* Records and enumeration classes can implement interfaces -> they cannot extend other classes though
* Interfaces can be ```sealed```
* Interfaces kind of bring multiple inheritance

# Comparable Interface
* The compareTo method of the Comparable interface returns an integer
* ```Integer.compare``` and ```Double.compare``` methods are safer options to avoid overflowing / floating-point inaccuracies
* It is recommended that ```x.compareTo(y)``` should be zero exactly when ```x.equals(y)```
* Each compareTo method should start out with the test ```if (getClass() != other.getClass()) throw new ClasCastException();```

# Properties of Interfaces
* Just as methods in an interface are automatically ```public```, fields are always ```public static final```

# Static and Private Methods
* As of Java 8, you are allowed to add ```static``` methods to interfaces
* Methods in an interface can be ```private```
* A private method can be ```static``` or an instance method

# Default Methods
* You can supply a ```default``` implementation for any interface method
* An important use for default methods is interface evolution -> adding a non-default method to an interface is not source-compatible

# Resolving Default Method Conflicts
