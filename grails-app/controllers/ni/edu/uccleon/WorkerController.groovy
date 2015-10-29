package ni.edu.uccleon

import grails.plugin.springsecurity.annotation.Secured

@Secured("ROLE_ADMIN")
class WorkerController {
  static allowedMethods = [
    index: "GET",
    create: ["GET", "POST"]
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
}
