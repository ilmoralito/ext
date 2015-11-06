package ni.edu.uccleon

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class DepartmentController {
  static allowedMethods = [
    index: "GET",
    create: ["GET", "POST"]
  ]

  def index() {
    respond Department.list()
  }

  def create() {
    if (request.method == "POST") {
      def department = new Department(params)

      if (!department.save()) {
        return [department: department]
      }
    }
  }
}
