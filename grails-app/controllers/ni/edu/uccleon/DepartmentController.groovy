package ni.edu.uccleon

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class DepartmentController {
  static allowedMethods = [
    index: "GET",
    create: ["GET", "POST"],
    delete: ["GET", "POST"]
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

  def delete(Integer id) {
    def department = Department.get id

    if (!department) {
      response.sendError 404
    }

    if (request.method == "POST") {
      department.delete()

      redirect action: "index"
    }

    [department: department]
  }
}
