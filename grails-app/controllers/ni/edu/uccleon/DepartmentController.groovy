package ni.edu.uccleon

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class DepartmentController {
  static allowedMethods = [
    index: "GET",
    create: ["GET", "POST"],
    delete: ["GET", "POST"],
    edit: "GET",
    update: "POST"
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

  def edit(Integer id) {
    def department = Department.get id

    if (!department) {
      response.sendError 404
    }

    [department: department]
  }

  def update(Integer id) {
    def department = Department.get id

    if (!department) {
      response.sendError 404
    }

    department.properties = params

    if (!department.save()) {
      chain action: "edit", id: id, model: [department: department]
      return
    }

    redirect action: "edit", params: [id: id]
  }
}
