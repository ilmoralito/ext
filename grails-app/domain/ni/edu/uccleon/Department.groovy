package ni.edu.uccleon

import org.grails.databinding.BindUsing

class Department {
  @BindUsing({
    obj, source -> source["name"]?.toLowerCase()?.tokenize(" ")*.capitalize().join(" ")
  })
  String name
  Integer extensionNumber

  static constraints = {
    name blank: false, unique: true
    extensionNumber min: 1
  }

  String toString() { name }
}
