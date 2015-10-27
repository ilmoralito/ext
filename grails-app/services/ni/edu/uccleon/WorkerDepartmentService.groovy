package ni.edu.uccleon

import grails.transaction.Transactional

@Transactional
class WorkerDepartmentService {

  def getWorkers(String position, Department department) {
    def query = WorkerDepartment.where {
      position == position && department == department
    }

    if (position == "Manager") {
      query.find().worker
    } else {
      query.list().worker
    }
  }
}
