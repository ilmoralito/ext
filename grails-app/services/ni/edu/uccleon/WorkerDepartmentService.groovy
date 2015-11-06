package ni.edu.uccleon

import grails.transaction.Transactional

@Transactional
class WorkerDepartmentService {

  def getWorkerDepartmentData() {
    def criteria = WorkerDepartment.createCriteria()
    def result = criteria.list {
      projections {
        groupProperty "department"
      }
    }

    def data = result.groupBy { it.extensionNumber }.collect { o ->
      [
        ext: o.key,
        meta: o.value.collect { d ->
          [
            department: d,
            manager: getWorkers("Manager", d),
            collaborators: getWorkers("Collaborator", d)
          ]
        }
      ]
    }

    data.sort { it.ext }
  }

  def getWorkers(String position, Department department) {
    def query = WorkerDepartment.where {
      position == position && department == department
    }

    if (position == "Manager") {
      query.find().worker.fullName
    } else {
      query.list().worker.fullName
    }
  }

  def membersInDepartment(Department department) {
    WorkerDepartment.where { department == department }
  }
}
