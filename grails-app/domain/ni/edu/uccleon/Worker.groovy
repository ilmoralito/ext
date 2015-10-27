package ni.edu.uccleon

class Worker {
  String fullName
  String email

  static constraints = {
    fullName blank: false
    email email: true, unique: true, blank: false, validator: { email, worker ->
      if (email.tokenize("@")[1] != "ucc.edu.ni") {
        return "not.valid.email"
      }
    }
  }

  String toString() { fullName }
}
