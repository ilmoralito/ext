package ni.edu.uccleon

class Department {
  String name
  Integer extensionNumber

  static constraints = {
    name blank: false, unique: true
    extensionNumber min: 1
  }

  String toString() { name }
}
