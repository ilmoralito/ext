package ni.edu.uccleon

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class WorkerController {
  static allowedMethods = [
    index: "GET",
    create: ["GET", "POST"],
    delete: ["GET", "POST"],
    edit: "GET",
    update: "POST"
  ]

  def index() {
    respond Worker.list()
  }

  def create() {
    if (request.method == "POST") {
      def worker = new Worker(params)

      if (!worker.save()) {
        return [worker: worker]
      }
    }
  }

  def delete(Integer id) {
    def worker = Worker.get id

    if (!worker) {
      response.sendError 404
    }

    if (request.method == "POST") {
      //remove from workerDepartment
      def workerInWorkerDepartment = WorkerDepartment.findByWorker worker
      if (workerInWorkerDepartment) {
        workerInWorkerDepartment.delete()
      }

      //remove from worker
      worker.delete()

      redirect action: "index"
    }

    [worker: worker]
  }

  def edit(Integer id) {
    def worker = Worker.get id

    if (!worker) {
      response.sendError 404
    }

    [worker: worker]
  }

  def update(Integer id) {
    def worker = Worker.get id

    if (!worker) {
      response.sendError 404
    }

    worker.properties = params

    if (!worker.save()) {
      chain action: "edit", id: id, model: [worker: worker]
      return
    }

    redirect action: "edit", params: [id: id]
  }
}
