/**
 * 1. Guarantees only one instance is created
 * 2. control of resource
 * 3. Lazily loaded
 * 4. ex: Runtime, Logger, Spring beans, Graphic Managers
 */

Steps to create Singleton:
1. Create a private static variable
2. Mark constructor with no args as private
4. Get instance returns instance if not null else return already created instance.

Pitfalls:
1. overused
2. everything a singleton, slows the application
3. difficult to unit test since most of them are private.
4. They are not thread safe if not properly implemented.
