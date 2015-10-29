package ni.edu.uccleon

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class WorkerController {
  static allowedMethods = [
    index: "GET",
    create: ["GET", "POST"],
    delete: ["GET", "POST"]
  ]

  def index() {
    [workers: Worker.list()]
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
}
