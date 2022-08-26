-- Concepts --
Check if constructing an object is complex(like more arguments)
Cannot have constructors for every combination. Build object as desired.
Easy to implement
Force immutability
ex: StringBuilder, DocumentBuilder, Locale.Builder

-- Design --
What constructor to use?
Multiple constructors are difficult to manage.
Builder pattern overcomes this problem.

-- Pitfalls --
static inner class
Immutable
