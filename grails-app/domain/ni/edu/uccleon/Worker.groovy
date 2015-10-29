package ni.edu.uccleon

import org.grails.databinding.BindUsing

class Worker {
  @BindUsing({
    obj, source -> source["fullName"]?.toLowerCase()?.tokenize(" ")*.capitalize().join(" ")
  })
  String fullName
  String email

  static constraints = {
    fullName blank: false
    email email: true, unique: true, blank: false, validator: { email, worker ->
      def emailTokenized = email.tokenize("@")

      if (emailTokenized[0].tokenize(".").size() != 2 || emailTokenized[1] != "ucc.edu.ni") {
        return "not.valid.email"
      }
    }
  }

  static mapping = {
    sort "fullName"
  }

  String toString() { fullName }
}
