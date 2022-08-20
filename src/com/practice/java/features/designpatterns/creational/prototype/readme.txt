-- Concepts --
1. Avoid costly creation
2. Avoids subclassing
3. Typically doesn't use "new" (only first instance with new, after that use clone).
4. Usually implemented with a Registry (when needed creates the clone of the object from Registry)
5. Java example: java.lang.Object#clone()

-- Design --
1. Implements clone or cloneable interface, avoids using keyword new.
2. Each instance is still unique.
3. Shallow - immediate properties deep - copies object properties as well.
4. Can define some defaults at the time of initial objects creation.

-- Pitfalls --
1. Not clear when to use
2. Shallow vs Deep copy (Clone interface only shallow copy, custom implementation required for deep copy)

