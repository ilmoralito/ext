package ni.edu.uccleon

class WorkerDepartment {
  Worker worker
  Department department
  String position

  static constraints = {
    worker nullable: false
    department nullable: false
    position inList: ["Manager", "Collaborator"]
  }

  String toString() { department }
}
